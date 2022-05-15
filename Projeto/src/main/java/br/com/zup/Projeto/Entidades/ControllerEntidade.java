package br.com.zup.Projeto.Entidades;

import br.com.zup.Projeto.Doadores.Doador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/entidade")
@RestController
public class ControllerEntidade
{
    @Autowired
    private ServiceDTOEntidades serviceDTOEntidades;
    @Autowired
    private ServiceEntidades serviceEntidades;
    @PostMapping
    public EntidadeODTO postEntidade(@RequestBody EntidadeIDTO entidadeIDTO)
    {
        Entidade postEntidade = null;
        postEntidade = serviceEntidades.createEntidade(serviceDTOEntidades.entidade(entidadeIDTO));
        return serviceDTOEntidades.entidadeODTO(postEntidade);
    }
    @GetMapping("/{ID}")
    public EntidadeODTO getEntidade(@PathVariable(name = "ID") int entidadeId)
    {
        Entidade getEntidade = null;
        getEntidade = serviceEntidades.readEntidadeId(entidadeId);
        return serviceDTOEntidades.entidadeODTO(getEntidade);
    }

}
