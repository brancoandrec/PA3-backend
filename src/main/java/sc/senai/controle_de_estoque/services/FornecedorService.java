package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.DTO.AlterarFornecedorDTO;
import sc.senai.controle_de_estoque.entities.Fornecedor;
import sc.senai.controle_de_estoque.repositories.FornecedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

     private FornecedorRepository fornecedorRepository;
     public FornecedorService(FornecedorRepository fornecedorRepository) {
         this.fornecedorRepository = fornecedorRepository;
     }

     // crud de forncedor

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        Fornecedor f = new Fornecedor();
        f.setNome(fornecedor.getNome());
        f.setContato(fornecedor.getContato());
        f.setEndereco(fornecedor.getEndereco());
        return fornecedorRepository.save(f);

    }
//verificar se esta funcionando, adaptado para usar id e o dto que é parecido com a classe fornecedor
public AlterarFornecedorDTO alterarForncedorPorId(AlterarFornecedorDTO alterarForncedorDTO , Long id) throws Exception{
    Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

    if(fornecedor.isEmpty()) {
        throw new Exception("fornecedor nao encontrado" + id);

    }
    Fornecedor f = fornecedor.get();
    f.setNome(alterarForncedorDTO.getNome());
    f.setContato(alterarForncedorDTO.getContato());
    f.setEndereco(alterarForncedorDTO.getEndereco());
    fornecedorRepository.save(f);
     return alterarForncedorDTO;




    }



    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);

    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);

    }




    }


