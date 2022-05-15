package br.com.zup.Projeto.Entidades;

import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryEntidades extends CrudRepository<Entidade, Integer>
{
    Iterable<Entidade> findAllBydoadoresIn(Iterable<TiposDeDoador> doadores);
}
