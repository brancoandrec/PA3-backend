package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.DTO.AlterarCompraDTO;
import sc.senai.controle_de_estoque.services.CompraService;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    private CompraService compraService;
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> criarItem(@RequestBody Compra compra) {
        try{
            Compra compr = compraService.criarCompra(compra);
            return ResponseEntity.ok(compr);

        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao criar compra", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarItem() {
        try{
            List<Compra> compra = compraService.buscarTodas();
            return ResponseEntity.ok(compra);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar compra", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarItem(@RequestBody AlterarCompraDTO compraDTO) {
        try {
            compraService.atualizarCompra(compraDTO);
            return ResponseEntity.ok(compraDTO);
        }catch (Exception ex) {
            return new ResponseEntity<>("Erro ao alterar compra", HttpStatusCode.valueOf(504));
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirItem(@PathVariable Long id) {
        try {
            compraService.excluir(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao excluir compra", HttpStatusCode.valueOf(504));
        }

    }

    @GetMapping("/fornecedor")
    public ResponseEntity<?> buscarPorFornecedor(@RequestParam String fornecedor) {
        try{
            List<Compra> compras = compraService.buscarComprasPorNomeFornecedor(fornecedor);
            return ResponseEntity.ok(compras);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar compra", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/projeto")
    public ResponseEntity<?> buscarPorProjeto(@RequestParam String projeto){
        try{
            List<Compra> compras = compraService.buscarPorNomeProjeto(projeto);
            return ResponseEntity.ok(compras);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar compra", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<?> buscarPorProjetoId(@PathVariable Long id){
        try{
            List<Compra> compras = compraService.findByProjetoId(id);
            return ResponseEntity.ok(compras);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar compra", HttpStatusCode.valueOf(504));
        }
    }
}
