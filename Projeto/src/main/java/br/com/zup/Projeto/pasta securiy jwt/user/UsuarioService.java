package br.com.zup.Projeto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario cadastrarUsuario(Usuario usuario){
        String encode = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encode);
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPeloId(int id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()){
            throw new RuntimeException("Usuario não encontrado");
        }
        return usuarioOptional.get();
    }

    public Usuario buscarUsuarioPeloEmail(String email){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isEmpty()){
            throw new RuntimeException("Usuario não encontrado");
        }
        return usuarioOptional.get();
    }
}
