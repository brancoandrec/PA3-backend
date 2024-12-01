package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.ConjuntoItens;
import sc.senai.controle_de_estoque.entities.DTO.AlterarConjuntoItensDTO;
import sc.senai.controle_de_estoque.repositories.ConjuntoItensRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConjuntoItensService {
    private ConjuntoItensRepository conjuntoItensRepository;
    public ConjuntoItensService(ConjuntoItensRepository conjuntoItensRepository) {
        this.conjuntoItensRepository = conjuntoItensRepository;
    }

    public ConjuntoItens criarConjuntoItens(ConjuntoItens conjuntoItens) {
        ConjuntoItens conjuntoIten = new ConjuntoItens();
        conjuntoIten.setItem(conjuntoItens.getItem());
        conjuntoIten.setQuantidade(conjuntoItens.getQuantidade());
        conjuntoIten.setProjeto(conjuntoItens.getProjeto());
        conjuntoIten.setLocalArmazen(conjuntoItens.getLocalArmazen());
        return conjuntoItensRepository.save(conjuntoIten);

    }

    public List<ConjuntoItens> listarConjuntoItens() {
        return conjuntoItensRepository.findAll();
    }

    public Optional<ConjuntoItens> buscarPorId(Long id) {
        return conjuntoItensRepository.findById(id);

    }

    public void excluir(Long id) {
        conjuntoItensRepository.deleteById(id);
    }

    public AlterarConjuntoItensDTO atualizarConjunto(AlterarConjuntoItensDTO conjuntoItensDTO) throws Exception{
        Optional<ConjuntoItens> conjuntoItens = conjuntoItensRepository.findById(conjuntoItensDTO.getId());

        if(Optional.ofNullable(conjuntoItens.get()).isPresent()) {
            conjuntoItens.get().setItem(conjuntoItensDTO.getItem());
            conjuntoItens.get().setQuantidade(conjuntoItens.get().getQuantidade());
            conjuntoItens.get().setProjeto(conjuntoItens.get().getProjeto());
            conjuntoItens.get().setLocalArmazen(conjuntoItens.get().getLocalArmazen());

            conjuntoItensRepository.save(conjuntoItens.get());
            return conjuntoItensDTO;
        }
        throw new Exception("Conjunto não encontrado");

    }

    public List<ConjuntoItens> buscarPorNomeProjeto(String nomeProjeto){
        return conjuntoItensRepository.findByProjetoNomeContainingIgnoreCase(nomeProjeto);
    }

}
