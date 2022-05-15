package br.com.zup.Projeto.Doadores;

import br.com.zup.Projeto.Endereco.NumeroEComplemento.ServiceNumeroEComplemento;
import br.com.zup.Projeto.Endereco.ServiceEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDoador
{
    @Autowired
    private RepositoryDoadores repositoryDoadores;
    @Autowired
    private ServiceEndereco serviceEndereco;
    @Autowired
    private ServiceNumeroEComplemento serviceNumeroEComplemento;
    public Doador createDoador(Doador doador)
    {
        Doador createDoador = null;
        serviceEndereco.createEndereco(doador.getEndereco());
        createDoador = repositoryDoadores.save(doador);
        return createDoador;
    }

    public Iterable<Doador> readDoador()
    {
        Iterable<Doador> readDoador = null;
        readDoador = repositoryDoadores.findAll();
        return readDoador;
    }
    public Doador readDoadorId(int id)
    {
        Optional<Doador> doadorOptional;
        doadorOptional = repositoryDoadores.findById(id);
        if(doadorOptional.isEmpty())
            throw new RuntimeException("fail");
        else
            return doadorOptional.get();
    }
    public Doador updateDoador(Doador doador)
    {
        Doador updateDoador = null;
        updateDoador = repositoryDoadores.save(doador);
        return updateDoador;
    }
    public Doador updateDoadorId(int id, Doador doador)
    {
        readDoadorId(id);
        Doador updateDoadorId = null;
        updateDoadorId = repositoryDoadores.save(doador);
        return updateDoadorId;
    }
    public void deleteDoador(Doador doador)
    {
        repositoryDoadores.delete(doador);
    }
    public void deleteDoadorId(int id)
    {
        boolean emptyCatchBlock = false;
        readDoadorId(id);
        repositoryDoadores.deleteById(id);
        try {readDoadorId(id);}
        catch (RuntimeException runtimeException)
        {emptyCatchBlock = true;}
    }

}
