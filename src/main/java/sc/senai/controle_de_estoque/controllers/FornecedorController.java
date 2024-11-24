package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.DTO.AlterarFornecedorDTO;
import sc.senai.controle_de_estoque.entities.DTO.CriarItemDTO;
import sc.senai.controle_de_estoque.entities.Fornecedor;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.services.FornecedorService;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarFornecedor() {
        try {
            List<Fornecedor> fornecedor = fornecedorService.listarFornecedores();
            return ResponseEntity.ok(fornecedor);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro de consulta ", HttpStatusCode.valueOf(504));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> criarFornecedor(@RequestBody Fornecedor fornecedor){
        try{
            Fornecedor fornecedorCriado = fornecedorService.criarFornecedor(fornecedor);
            return ResponseEntity.ok(fornecedorCriado);

        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao criar item ", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar/{codigo}")
    public ResponseEntity<?> atualizarFornecedor(@PathVariable Long codigo, @RequestBody AlterarFornecedorDTO alterarFornecedor) {
        try {

            AlterarFornecedorDTO alterarFornecedorDTO = fornecedorService.alterarForncedorPorId(alterarFornecedor, codigo);


            return ResponseEntity.ok(alterarFornecedorDTO);
        } catch (Exception ex) {

            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }


}
