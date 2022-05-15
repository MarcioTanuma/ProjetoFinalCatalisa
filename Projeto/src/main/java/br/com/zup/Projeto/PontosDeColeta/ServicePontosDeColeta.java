package br.com.zup.Projeto.PontosDeColeta;

import br.com.zup.Projeto.Entidades.Entidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicePontosDeColeta {
    @Autowired
    private RepositoryPontosDeColeta repositoryPontosDeColeta;

    public PontoDeColeta createPontoDeColeta(PontoDeColeta pontoDeColeta) {
        PontoDeColeta createPontoDeColeta = null;
        createPontoDeColeta = repositoryPontosDeColeta.save(pontoDeColeta);
        return createPontoDeColeta;
    }

    public Iterable<PontoDeColeta> readPontoDeColeta() {
        Iterable<PontoDeColeta> readPontoDeColeta = null;
        readPontoDeColeta = repositoryPontosDeColeta.findAll();
        return readPontoDeColeta;
    }

    public PontoDeColeta readPontoDeColetaId(int id) {
        Optional<PontoDeColeta> pontoDeColetaOptional;
        pontoDeColetaOptional = repositoryPontosDeColeta.findById(id);
        if (pontoDeColetaOptional.isEmpty())
            throw new RuntimeException("fail");
        else
            return pontoDeColetaOptional.get();
    }

    public PontoDeColeta updatePontoDeColeta(PontoDeColeta pontoDeColeta) {
        PontoDeColeta updatePontoDeColeta = null;
        updatePontoDeColeta = repositoryPontosDeColeta.save(pontoDeColeta);
        return updatePontoDeColeta;
    }

    public PontoDeColeta updatePontoDeColetaId(int id, PontoDeColeta pontoDeColeta) {
        readPontoDeColetaId(id);
        PontoDeColeta updatePontoDeColeta = null;
        updatePontoDeColeta = repositoryPontosDeColeta.save(pontoDeColeta);
        return updatePontoDeColeta;
    }

    public void deletePontoDeColeta(PontoDeColeta pontoDeColeta) {
        repositoryPontosDeColeta.delete(pontoDeColeta);
    }

    public void deletePontoDeColetaId(int id) {
        boolean emptyCatchBlock = false;
        readPontoDeColetaId(id);
        repositoryPontosDeColeta.deleteById(id);
        try {
            readPontoDeColetaId(id);
        } catch (RuntimeException runtimeException) {
            emptyCatchBlock = true;
        }
    }
}
