package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.Log;
import sc.senai.controle_de_estoque.services.LogService;

import java.util.List;

@RestController
@RequestMapping("log")
public class LogController {

    private LogService logService;
    public LogController(LogService logService) {
        this.logService = logService;
    }


    @GetMapping("/buscar")
    public ResponseEntity<?> buscarLog() {
        try{
            List<Log> l = logService.listarLogs();
            return ResponseEntity.ok(l);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao buscar logs", HttpStatusCode.valueOf(504));
        }
    }

}
