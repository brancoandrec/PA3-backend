package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Fornecedor;
import sc.senai.controle_de_estoque.repositories.FornecedorRepository;

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



}
