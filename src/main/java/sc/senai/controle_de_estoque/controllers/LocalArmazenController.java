package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.ConjuntoItens;
import sc.senai.controle_de_estoque.entities.DTO.AlterarLocalArmazenDTO;
import sc.senai.controle_de_estoque.entities.LocalArmazen;
import sc.senai.controle_de_estoque.services.ConjuntoItensService;
import sc.senai.controle_de_estoque.services.LocalArmazenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localarmazen")
public class LocalArmazenController {

    private final ConjuntoItensService conjuntoItensService;
    private LocalArmazenService localArmazenService;
    public LocalArmazenController(LocalArmazenService localArmazenService, ConjuntoItensService conjuntoItensService) {
        this.localArmazenService = localArmazenService;
        this.conjuntoItensService = conjuntoItensService;
    }

    //codigo copiado de fornecedor controller

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarLocalArmazen() {
        try {
            List<LocalArmazen> local = localArmazenService.listarLocalArmazen();
            return ResponseEntity.ok(local);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro de consulta ", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/buscarporid/{codigo}")
    public ResponseEntity<?> buscarLocalArmazenPorCodigo(@PathVariable Long codigo) {
        try{
            Optional<LocalArmazen> local = localArmazenService.buscarLocalArmazenPorId(codigo);
            if (local.isPresent()) {
                return ResponseEntity.ok(local.get());
            }
            else return ResponseEntity.notFound().build();

        }

        catch (Exception e) {
            return new ResponseEntity<>("Erro de consulta ", HttpStatusCode.valueOf(504));
        }

    }



    @PostMapping("/add")
    public ResponseEntity<?> criarLocalArmazen(@RequestBody LocalArmazen localArmazen){
        try{
            LocalArmazen localArmazencriado = localArmazenService.criarLocalArmazen(localArmazen);
            return ResponseEntity.ok(localArmazencriado);

        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao criar item ", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar/{codigo}")
    public ResponseEntity<?> atualizarLocalArmazen(@PathVariable Long codigo, @RequestBody AlterarLocalArmazenDTO alterarLocalArmazenDTO) {
        try {

            AlterarLocalArmazenDTO alterarLocalArmazenDTOcriado = localArmazenService.alterarLocalArmazen(alterarLocalArmazenDTO, codigo);


            return ResponseEntity.ok(alterarLocalArmazenDTOcriado);
        } catch (Exception ex) {

            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }


    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluirLocalArmazen(@PathVariable Long codigo){
        try {
            localArmazenService.excluirLocalArmazen(codigo);
            return ResponseEntity.ok("Excluído com Sucesso");
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }











}
