package sc.senai.controle_de_estoque.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sc.senai.controle_de_estoque.config.JWTAuthenticationFilter;
import sc.senai.controle_de_estoque.entities.Usuario;
import sc.senai.controle_de_estoque.services.UsuarioService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para autenticação (login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario, HttpServletResponse response) {
        try {
            // Autenticação com as credenciais do usuário
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha())
            );

            // Configurando o contexto de segurança
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Gerando o token JWT
            String token = JWTAuthenticationFilter.createToken(authentication);

            // Retornando o token como resposta
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Login bem-sucedido");
        } catch (Exception ex) {
            return ResponseEntity.status(401).body("Erro ao autenticar: " + ex.getMessage());
        }
    }
}
