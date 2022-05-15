package br.com.zup.Projeto.TiposDeDoador;

import br.com.zup.Projeto.Doadores.Doador;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryTiposDeDoador extends CrudRepository<TiposDeDoador, Integer>
{
    public TiposDeDoador findBytiposDeDoador(OsTiposDeDoador osTiposDeDoador);
}
