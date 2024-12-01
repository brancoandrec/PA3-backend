package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.ConjuntoItens;
import sc.senai.controle_de_estoque.entities.DTO.AlterarConjuntoItensDTO;
import sc.senai.controle_de_estoque.entities.Projeto;
import sc.senai.controle_de_estoque.services.ConjuntoItensService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conjuntoitens")
public class ConjuntoItensController {

    private ConjuntoItensService conjuntoItensService;

    public ConjuntoItensController(ConjuntoItensService conjuntoItensService) {
        this.conjuntoItensService = conjuntoItensService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarConjuntoItens() {
        try {
            List<ConjuntoItens> conjuntoItensList = conjuntoItensService.listarConjuntoItens();
            return ResponseEntity.ok(conjuntoItensList);

        } catch (Exception ex) {
            return new ResponseEntity<>("erro", HttpStatusCode.valueOf(504));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionarConjuntoItens(@RequestBody ConjuntoItens conjuntoItens) {
        try {
            ConjuntoItens conj = conjuntoItensService.criarConjuntoItens(conjuntoItens);
            return ResponseEntity.ok(conj);

        } catch (Exception ex) {
            return new ResponseEntity("erro", HttpStatusCode.valueOf(504));
        }


    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarConjuntoItens(@RequestBody AlterarConjuntoItensDTO alterarConjuntoItensDTO) {
        try {
            conjuntoItensService.atualizarConjunto(alterarConjuntoItensDTO);
            return ResponseEntity.ok(alterarConjuntoItensDTO);

        } catch (Exception ex) {
            return new ResponseEntity("erro", HttpStatusCode.valueOf(504));
        }


    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id ) {
        try {
            Optional<ConjuntoItens> conj = conjuntoItensService.buscarPorId(id);
            if(Optional.ofNullable(conj).isPresent()) {
                return ResponseEntity.ok(conj.get());
            } else return ResponseEntity.notFound().build();

        } catch (Exception ex) {
            return new ResponseEntity("erro", HttpStatusCode.valueOf(504));
        }



    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirConjuntoItens(@PathVariable Long id ) {
        try {
            conjuntoItensService.excluir(id);
            return ResponseEntity.ok().build();

        } catch (Exception ex) {
            return new ResponseEntity("erro", HttpStatusCode.valueOf(504));
        }


    }

    @GetMapping("/projeto")
    public ResponseEntity<?> buscarPorProjeto(@RequestParam String projeto){
        try{
            List<ConjuntoItens> conjuntoItens = conjuntoItensService.buscarPorNomeProjeto(projeto);
            return ResponseEntity.ok(conjuntoItens);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar conjunto de itens", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<?> buscarPorIdProjeto(@PathVariable Long id){
        try{
            List<ConjuntoItens> conjuntoItens = conjuntoItensService.findByIdProjeto(id);
            return ResponseEntity.ok(conjuntoItens);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar conjunto de itens", HttpStatusCode.valueOf(504));
        }
    }




}