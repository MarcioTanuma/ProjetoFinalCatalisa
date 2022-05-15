package br.com.zup.Projeto.TableLoader;

import br.com.zup.Projeto.TiposDeBeneficiario.ServiceTiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeDoacoes.ServiceTiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoador.ServiceTiposDeDoador;
import br.com.zup.Projeto.TiposDeDonativos.ServiceTiposDeDonativos;
import br.com.zup.Projeto.TiposDeTipos.ServiceTiposDeTipos;
import br.com.zup.Projeto.TiposDeTipos.TiposDeTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableLoader
{   @Autowired
    private ServiceTiposDeTipos serviceTiposDeTipos;
    @Autowired
    private ServiceTiposDeDoador serviceTiposDeDoador;
    @Autowired
    private ServiceTiposDeDoacoes serviceTiposDeDoacoes;
    @Autowired
    private ServiceTiposDeBeneficiario serviceTiposDeBeneficiario;
    @Autowired
    private ServiceTiposDeDonativos serviceTiposDeDonativos;
    public void tableloader()
    {
        serviceTiposDeTipos.servicetiposdetipos();
        serviceTiposDeDoador.servicetiposdedoador();
        serviceTiposDeDoacoes.servicetiposdedoacoes();
        serviceTiposDeBeneficiario.servicetiposdebeneficiario();
        serviceTiposDeDonativos.servicetiposdedonativos();
    }
}
