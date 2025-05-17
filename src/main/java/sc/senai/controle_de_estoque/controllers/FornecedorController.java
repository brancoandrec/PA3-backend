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
import java.util.Optional;

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

    @GetMapping("/buscarporid/{codigo}")
    public ResponseEntity<?> buscarFornecedorPorCodigo(@PathVariable Long codigo) {
        try{
            Optional<Fornecedor> fornecedor = fornecedorService.buscarFornecedorPorId(codigo);
            if (fornecedor.isPresent()) {
                return ResponseEntity.ok(fornecedor.get());
            }
            else return ResponseEntity.notFound().build();

        }

        catch (Exception e) {
            return new ResponseEntity<>("Erro de consulta ", HttpStatusCode.valueOf(504));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> criarFornecedor(@RequestBody Fornecedor fornecedor){
        try{

            Fornecedor fornecedorCriado = fornecedorService.criarFornecedor(fornecedor);
            return ResponseEntity.ok(fornecedorCriado);

        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao criar fornecedor ", HttpStatusCode.valueOf(504));
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

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluirFornecedor(@PathVariable Long codigo){
        try {
            fornecedorService.excluirFornecedor(codigo);
            return ResponseEntity.ok("Excluído com Sucesso");
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }




}
