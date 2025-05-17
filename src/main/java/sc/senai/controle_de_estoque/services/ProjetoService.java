package sc.senai.controle_de_estoque.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.DTO.AlterarProjetoDTO;
import sc.senai.controle_de_estoque.entities.Projeto;
import sc.senai.controle_de_estoque.repositories.ProjetoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    private ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criarProjeto(Projeto projeto){
        Projeto proj = new Projeto();
        proj.setNome(projeto.getNome());
        proj.setDescricao(projeto.getDescricao());
        proj.setDataInicio(projeto.getDataInicio());
        return projetoRepository.save(proj);
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public AlterarProjetoDTO atualizarProjeto(AlterarProjetoDTO projetoDTO) throws Exception{
        Optional<Projeto> projeto = projetoRepository.findById(projetoDTO.getId());

        if(Optional.ofNullable(projeto).isPresent()){
            projeto.get().setNome(projetoDTO.getNome());
            projeto.get().setDescricao(projetoDTO.getDescricao());
            projeto.get().setDataInicio(projetoDTO.getDataInicio());

            projetoRepository.save(projeto.get());
            return projetoDTO;
        }
        throw new Exception("Projeto não existe");


    }

    public Optional<Projeto> buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id);
    }

    public void excluirProjeto(Long id) {
        projetoRepository.deleteById(id);
    }

    public void atualizarDescricaoProjeto(Long id, String descricao) {
        Optional<Projeto> projeto = buscarProjetoPorId(id);
        if(Optional.ofNullable(projeto).isPresent()) {
            projeto.get().setDescricao(descricao);
            projetoRepository.save(projeto.get());
        }
    }
}
