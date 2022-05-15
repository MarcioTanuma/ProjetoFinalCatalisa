package br.com.zup.Projeto.postagem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostagemRepository extends CrudRepository<Postagem, Integer> {
    List<Postagem> findAllByUsuarioEmail(String email);
    List<Postagem> findAllByUsuarioId(int usuarioId);
}
