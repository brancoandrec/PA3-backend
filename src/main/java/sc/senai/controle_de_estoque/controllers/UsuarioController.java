package sc.senai.controle_de_estoque.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.entities.DTO.AlterarSenhaUsuarioDTO;
import sc.senai.controle_de_estoque.entities.DTO.AlterarUsuarioDTO;
import sc.senai.controle_de_estoque.entities.Usuario;
import sc.senai.controle_de_estoque.services.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarUsuarios(){
        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch(Exception ex){
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
    }





    @PostMapping("/add")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario){
        try {
            Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(usuarioCriado);
        } catch (Exception ex){
//            return new ResponseEntity("Erro", HttpStatusCode.valueOf(504));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + ex.getMessage());
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody AlterarUsuarioDTO usuario){
        try {
            usuario = usuarioService.alterarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }


    @PatchMapping("/alterar/senha")
    public ResponseEntity<?> atualizarSenhaUsuario(@RequestBody AlterarSenhaUsuarioDTO alterarSenhaUsuarioDTO){
        try {
            Usuario usuario = usuarioService.atualizarSenhaUsuario(alterarSenhaUsuarioDTO);
            return ResponseEntity.ok(usuario);
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Long codigo){
        try {
            usuarioService.excluirUsuario(codigo);
            return ResponseEntity.ok("Excluído com Sucesso");
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }


    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<?> buscarUsuarioPorCodigo(@PathVariable Long codigo){
        try {
            Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(codigo);
            if(Optional.ofNullable(usuario).isPresent())
                return ResponseEntity.ok(usuario.get());
            else
                return ResponseEntity.notFound().build();

        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }

}
