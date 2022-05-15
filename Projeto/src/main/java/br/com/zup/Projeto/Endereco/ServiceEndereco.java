package br.com.zup.Projeto.Endereco;

import br.com.zup.Projeto.Endereco.NumeroEComplemento.ServiceNumeroEComplemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEndereco
{
    @Autowired
    private RepositoryEndereco repositoryEndereco;
    @Autowired
    private ServiceNumeroEComplemento serviceNumeroEComplemento;
    public Endereco createEndereco(Endereco endereco)
    {
        Endereco createEndereco = null;
        serviceNumeroEComplemento.createNumeroEComplemento(endereco.getNumeroEComplemento());
        createEndereco = repositoryEndereco.save(endereco);
        return createEndereco;
    }
}
