package br.com.zup.Projeto.Doadores;

import br.com.zup.Projeto.TiposDeDoador.OsTiposDeDoador;
import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/doador")
@RestController
public class ControllerDoador
{
    @Autowired
    private ServiceDoador serviceDoador;
    @Autowired
    private ServiceDTO serviceDTO;
    @PostMapping
    public DoadorODTO postDoador(@RequestBody DoadorIDTO doadorIDTO)
    {
        Doador postDoador = null;
        postDoador = serviceDoador.createDoador(serviceDTO.doador(doadorIDTO));
        return serviceDTO.doadorODTO(postDoador);
    }
    @GetMapping("/{ID}")
    public /*DoadorODTO*/TiposDeDoador getDoador(@PathVariable(name = "ID") int doadorId)
    {
        /*
        Doador getDoador = null;
        getDoador = serviceDoador.readDoadorId(doadorId);
        return serviceDTO.doadorODTO(getDoador);*/
        TiposDeDoador tiposdedoador = new TiposDeDoador();
        tiposdedoador.setId(doadorId);
        tiposdedoador.setTiposDeDoador(OsTiposDeDoador.VITIMASDEABUSOSEXUAL);
        return tiposdedoador;
    }

}
