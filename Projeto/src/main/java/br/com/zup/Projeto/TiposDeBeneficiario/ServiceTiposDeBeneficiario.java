package br.com.zup.Projeto.TiposDeBeneficiario;

import br.com.zup.Projeto.TiposDeDoacoes.OsTiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoacoes.RepositoryTiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoacoes.TiposDeDoacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTiposDeBeneficiario
{    @Autowired
private RepositoryTiposDeBeneficiario repositoryTiposDeBeneficiario;

    public void servicetiposdebeneficiario()
    {for (OsTiposDeBeneficiario umTipoDeBeneficiario : OsTiposDeBeneficiario.values()) {
        TiposDeBeneficiario maisUmTipoDeBeneficiario = new TiposDeBeneficiario();
        maisUmTipoDeBeneficiario.setTiposDeBeneficiario(umTipoDeBeneficiario);
        repositoryTiposDeBeneficiario.save(maisUmTipoDeBeneficiario);
    }
    }


}
