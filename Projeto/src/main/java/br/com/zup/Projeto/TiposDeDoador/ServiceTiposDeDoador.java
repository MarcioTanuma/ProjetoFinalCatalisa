package br.com.zup.Projeto.TiposDeDoador;

import br.com.zup.Projeto.TiposDeBeneficiario.OsTiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeBeneficiario.RepositoryTiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeBeneficiario.TiposDeBeneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTiposDeDoador
{    @Autowired
private RepositoryTiposDeDoador repositoryTiposDeDoador;

    public void servicetiposdedoador()
    {for (OsTiposDeDoador umTipoDeDoador: OsTiposDeDoador.values()) {
        TiposDeDoador maisUmTipoDeDoador = new TiposDeDoador();
        maisUmTipoDeDoador.setTiposDeDoador(umTipoDeDoador);
        repositoryTiposDeDoador.save(maisUmTipoDeDoador);
    }
    }
    public TiposDeDoador readTiposDeDoadorTiposDeDoador(OsTiposDeDoador osTiposDeDoador)
    {
        TiposDeDoador readTiposDeDoadorTiposDeDoador = null;
        readTiposDeDoadorTiposDeDoador = repositoryTiposDeDoador.findBytiposDeDoador(osTiposDeDoador);
        return  readTiposDeDoadorTiposDeDoador;
    }


}

