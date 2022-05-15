package br.com.zup.Projeto.Entidades;

import br.com.zup.Projeto.TiposDeTipos.OsTiposDeTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/doadores", method = RequestMethod.GET)
@RestController
public class ControllerEntidades
{
    @Autowired
    private ServiceEntidades serviceEntidades;

    @GetMapping()
    public Iterable<Entidade> getEntidades()
    {
        Iterable<Entidade> getEntidades = null;
        getEntidades = serviceEntidades.readEntidades();
        return getEntidades;
    }
    @GetMapping("/beneficiario/{beneficiario}")
    public Iterable<Entidade> getEntidadesBeneficiario(@PathVariable(name = "beneficiario") String string)
    {
        Iterable<Entidade> getEntidades = null;
        getEntidades = serviceEntidades.readEntidadesEnumString(OsTiposDeTipos.BENEFICIARIO, string);
        return getEntidades;
    }
    @GetMapping("/doador/{doador}")
    public Iterable<Entidade> getEntidadesDoador(@PathVariable(name = "doador") String string)
    {
        Iterable<Entidade> getEntidades = null;
        getEntidades = serviceEntidades.readEntidadesEnumString(OsTiposDeTipos.DOADOR, string);
        return getEntidades;
    }
}
