package br.com.zup.Projeto.TiposDeDonativos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTiposDeDonativos
{
  @Autowired
  private RepositoryTiposDeDonativos repositoryTiposDeDonativos;

  public void servicetiposdedonativos()
  {for (OsTiposDeDonativos umTipoDeDonativo: OsTiposDeDonativos.values()) {
          TiposDeDonativos maisUmTipoDeDonativo = new TiposDeDonativos();
          maisUmTipoDeDonativo.setTiposDeDonativos(umTipoDeDonativo);
          repositoryTiposDeDonativos.save(maisUmTipoDeDonativo);

    }
  }
}
