package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.DTO.CriarItemDTO;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.services.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarItem(){
        try {
            List<Item> item = itemService.listarItems();
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro de consulta ", HttpStatusCode.valueOf(504));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> criarItem(@RequestBody CriarItemDTO item){
        try{
            Item itemCriado = itemService.criarItem(item);
            return ResponseEntity.ok(itemCriado);

        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao criar item ", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar/{codigo}")
    public ResponseEntity<?> atualizarItem(@PathVariable Long codigo, @RequestBody Item item) {
        try {

            Item itemAtualizado = itemService.atualizarItem(codigo, item);


            return ResponseEntity.ok(itemAtualizado);
        } catch (Exception ex) {

            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }



    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluiritem(@PathVariable Long codigo){
        try {
            itemService.excluirItem(codigo);
            return ResponseEntity.ok("Excluída com Sucesso");
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<?> buscaritemPorCodigo(@PathVariable Long codigo){
        try {
            Optional<Item> item = itemService.BuscarPorId(codigo);
            if(Optional.ofNullable(item).isPresent())
                return ResponseEntity.ok(item.get());
            else
                return ResponseEntity.notFound().build();

        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }



}
