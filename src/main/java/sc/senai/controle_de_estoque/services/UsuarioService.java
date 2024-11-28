package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.DTO.AlterarSenhaUsuarioDTO;
import sc.senai.controle_de_estoque.entities.DTO.AlterarUsuarioDTO;
import sc.senai.controle_de_estoque.entities.Usuario;
import sc.senai.controle_de_estoque.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String passwd =usuario.getSenha();
        usuario.setSenha(passwd);
        usuarioRepository.save(usuario);
        return usuario;

    }

    public AlterarUsuarioDTO alterarUsuario(AlterarUsuarioDTO alterarUsuarioDTO) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(alterarUsuarioDTO.getId());

        if (Optional.ofNullable(usuario).isPresent()) {
            usuario.get().setNome(alterarUsuarioDTO.getNome());
            usuario.get().setEmail(alterarUsuarioDTO.getEmail());
            usuario.get().setSenha(alterarUsuarioDTO.getSenha());
            usuario.get().setCargo(alterarUsuarioDTO.getCargo());
            usuarioRepository.save(usuario.get());
            return alterarUsuarioDTO;
        }
        throw new Exception("Usuário não existe");
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);

    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }

    public Optional<Usuario> getUsuarioAuth(String email){
        return usuarioRepository.findByEmail(email);
    }



    public Usuario atualizarSenhaUsuario(AlterarSenhaUsuarioDTO alterarSenhaUsuarioDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(alterarSenhaUsuarioDTO.getId());
        String passwd = alterarSenhaUsuarioDTO.getSenha();
        usuario.get().setSenha(passwd);
        return usuarioRepository.save(usuario.get());
    }


}
