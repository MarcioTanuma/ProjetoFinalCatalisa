package br.com.zup.Projeto.postagem;


import br.com.zup.Projeto.JWT.JWTComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RequestMapping("/postagens")
@RestController
public class PostagemController {
    @Autowired
    private PostagemService postagemService;
    @Autowired
    private JWTComponente jwtComponente;

    /*
    Metodo com ID e trabalhando com Token e seus Claims
    @PostMapping()
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, HttpServletRequest request){
        String toke = request.getHeader("Authorization");
        Claims claims = jwtComponente.getClaims(toke.substring(6));
        return postagemService.cadastrarPostagem((int) claims.get("idUsuario"), postagem);
    }

     */

    // metodo utilizando o email com authentication
    @PostMapping()
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, Authentication authentication){
        String email = authentication.getName();
        return postagemService.cadastrarPostagem(email, postagem);
    }

    @DeleteMapping("/{idPostagem}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPostagem(@PathVariable int idPostagem, Authentication authentication){
        try{
            postagemService.apagarMensagem(idPostagem, authentication.getName());
        }catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}


