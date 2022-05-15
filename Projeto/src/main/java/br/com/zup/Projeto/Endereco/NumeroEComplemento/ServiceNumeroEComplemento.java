package br.com.zup.Projeto.Endereco.NumeroEComplemento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceNumeroEComplemento
{
    @Autowired
    private RepositoryNumeroEComplemento repositoryNumeroEComplemento;

    public NumeroEComplemento createNumeroEComplemento(NumeroEComplemento numeroEComplemento)
    {
        NumeroEComplemento createNumeroEComplemento = null;
        createNumeroEComplemento = repositoryNumeroEComplemento.save(numeroEComplemento);
        return createNumeroEComplemento;
    }

}
