package br.com.zup.Projeto.TiposDeDoacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTiposDeDoacoes {
    @Autowired
    private RepositoryTiposDeDoacoes repositoryTiposDeDoacoes;

    public void servicetiposdedoacoes()
    {for (OsTiposDeDoacoes umTipoDeDoacao : OsTiposDeDoacoes.values()) {
            TiposDeDoacoes maisUmTipoDeDoacao = new TiposDeDoacoes();
            maisUmTipoDeDoacao.setTiposDeDoacoes(umTipoDeDoacao);
            repositoryTiposDeDoacoes.save(maisUmTipoDeDoacao);
    }
    }
}