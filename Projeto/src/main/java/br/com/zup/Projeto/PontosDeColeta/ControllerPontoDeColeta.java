package br.com.zup.Projeto.PontosDeColeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pontodecoleta")
@RestController
public class ControllerPontoDeColeta
{
    @Autowired
    private ServicePontosDeColeta servicePontosDeColeta;

    @PostMapping
    public PontoDeColeta postPontoDeColeta(@RequestBody PontoDeColeta pontoDeColeta)
    {
        PontoDeColeta postPontoDeColeta = null;
        postPontoDeColeta = servicePontosDeColeta.createPontoDeColeta(pontoDeColeta);
        return pontoDeColeta;
    }

    @GetMapping("/{ID}")
    public PontoDeColeta getPontoDeColeta(@PathVariable(name = "ID") int pontoDeColetaId)
    {
        PontoDeColeta getPontoDeColeta = null;
        getPontoDeColeta = servicePontosDeColeta.readPontoDeColetaId(pontoDeColetaId);
        return getPontoDeColeta;
    }

}
