package br.com.zup.Projeto.TiposDeTipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTiposDeTipos
{
    @Autowired
    private RepositoryTiposDeTipos repositoryTiposDeTipos;

    public void servicetiposdetipos()
    {for (OsTiposDeTipos umTiposDeTipos: OsTiposDeTipos.values()) {
        TiposDeTipos maisUmTiposDeTipos = new TiposDeTipos();
        maisUmTiposDeTipos.setTiposDeTipos(umTiposDeTipos);
        repositoryTiposDeTipos.save(maisUmTiposDeTipos);
    }

    }

}
