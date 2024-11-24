package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

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
    public ResponseEntity<?> addItem(@RequestBody Item item){
        try{

        }
    }
}
