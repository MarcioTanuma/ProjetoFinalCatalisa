package br.com.zup.Projeto.AgendarDoacao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/doar")
@RestController
public class ControllerDoar
{
    @PostMapping
    public Doacao postDoar(@RequestBody Doacao doacao)
    {
        Doacao postDoar = null;

    return doacao;
    }


}
