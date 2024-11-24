package sc.senai.controle_de_estoque.config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Usuario;
import sc.senai.controle_de_estoque.services.UsuarioService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final UsuarioService usuarioService;

    public UserDetailsServiceCustom(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioService.getUsuarioAuth(username);
        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuario nao encontrado");


        String role = usuario.get().getCargo();
        if(!role.startsWith("ROLE_"))
            role = "ROLE_"+role;
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        Set<GrantedAuthority> authorities = new HashSet();
        authorities.add(authority);

        User user = new User(usuario.get().getEmail(), usuario.get().getSenha(), authorities);
        return user;


    }
}