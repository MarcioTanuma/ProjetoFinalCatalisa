package br.com.zup.Projeto.Entidades;

import br.com.zup.Projeto.Endereco.ServiceEndereco;
import br.com.zup.Projeto.TableLoader.TableLoader;
import br.com.zup.Projeto.TiposDeBeneficiario.TiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeDoacoes.TiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoador.OsTiposDeDoador;
import br.com.zup.Projeto.TiposDeDoador.ServiceTiposDeDoador;
import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
import br.com.zup.Projeto.TiposDeDonativos.TiposDeDonativos;
import br.com.zup.Projeto.TiposDeTipos.OsTiposDeTipos;
import br.com.zup.Projeto.TiposDeTipos.TiposDeTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntidades
{
    @Autowired
    private RepositoryEntidades repositoryEntidades;
    @Autowired
    private TableLoader tableLoader;
    @Autowired
    private ServiceTiposDeDoador serviceTiposDeDoador;
    @Autowired
    private ServiceEndereco serviceEndereco;
    public Entidade createEntidade(Entidade entidade)
    {
        Entidade createEntidade = null;
        tableLoader.tableloader();
        serviceEndereco.createEndereco(entidade.getEndereco());
        createEntidade = repositoryEntidades.save(entidade);
        return createEntidade;
    }
    public Iterable<Entidade> readEntidades()
    {
        Iterable<Entidade> readEntidade = null;
        readEntidade = repositoryEntidades.findAll();
        return readEntidade;
    }
    /*public Iterable<Entidade> readEntidadesDoador(Iterable<TiposDeDoador> iterable)
    {
        Iterable<Entidade> readEntidadesDoador = null;
        readEntidatesDoador = repositoryEntidades.findAllBydoadoresIn(iterable);
        return readEntidatesDoador;
    }*/
    public Iterable<Entidade> readEntidadesEnum(OsTiposDeTipos enuM, Iterable iterable)
    {
        Iterable<Entidade> readEntidadesEnum = null;
        switch (enuM){
            case BENEFICIARIO:
                    readEntidadesEnum = repositoryEntidades.findAllBydoadoresIn(iterable);
            case DOADOR:
                    readEntidadesEnum = repositoryEntidades.findAllBydoadoresIn(iterable);
            case DONATIVOS:
                    break;
            case DOACOES:
                    break;
            default:
                    break;
        }
        return readEntidadesEnum;
    }
    public Iterable<Entidade> readEntidadesEnumString (OsTiposDeTipos enuM, String string)
    {
        Iterable readEntidadesEnumString = null;
        TiposDeBeneficiario readEntidadesBeneficiario = null;
        TiposDeDoador readEntidadesDoador = null;
        TiposDeDonativos readEntidadesDonativos = null;
        TiposDeDoacoes readEntidadesDoacoes = null;
        switch (enuM){
            case BENEFICIARIO:
                    break;
            case DOADOR:
                    readEntidadesDoador = serviceTiposDeDoador.readTiposDeDoadorTiposDeDoador(OsTiposDeDoador.valueOf(string));
                    readEntidadesEnumString = List.of(readEntidadesDoador);
                    //return readEntidadesEnum(OsTiposDeTipos.DOADOR, readEntidadesEnumString);
            case DONATIVOS:
                    break;
            case DOACOES:
                    break;
            default:
                    break;
        }
        return readEntidadesEnum(OsTiposDeTipos.DOADOR, readEntidadesEnumString);
        //readEntidadesEnumString
        //return readEntidadesDoador(List.of(readEntidadeEnumString));
        //return readEntidadesEnum(List.of(readEntidadeEnumString));
    }
    public Entidade readEntidadeId(int id)
    {
        Optional<Entidade> entidadeOptional;
        entidadeOptional = repositoryEntidades.findById(id);
        if (entidadeOptional.isEmpty())
            throw new RuntimeException("fail");
        else
            return entidadeOptional.get();
    }

    public Entidade updateEntidade(Entidade entidade)
    {
        Entidade updateEntidade = null;
        updateEntidade = repositoryEntidades.save(entidade);
        return updateEntidade;
    }
    public Entidade updateEntidadeId(int id, Entidade entidade)
    {
        readEntidadeId(id);
        Entidade updateEntidadeId = null;
        updateEntidadeId = repositoryEntidades.save(entidade);
        return updateEntidadeId;
    }
    public void deleteEntidade(Entidade entidade)
    {
        repositoryEntidades.delete(entidade);
    }
    public void deleteEntidadeId(int id)
    {
        boolean emptyCatchBlock = false;
        readEntidadeId(id);
        repositoryEntidades.deleteById(id);
        try {readEntidadeId(id);}
        catch (RuntimeException runtimeException)
        {emptyCatchBlock = true;}
    }

}
