package br.com.zup.Projeto.JWT;

import br.com.zup.Projeto.exceptions.TokenNotValidException;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FiltroDeAutorizacaoJWT extends BasicAuthenticationFilter {
    private JWTComponente jwtComponente;
    private UserDetailsService userDetailsService;

    public FiltroDeAutorizacaoJWT(AuthenticationManager authenticationManager,
                                  JWTComponente jwtComponente, UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtComponente = jwtComponente;
        this.userDetailsService = userDetailsService;
    }

    public UsernamePasswordAuthenticationToken pegarAutenticacao(HttpServletRequest request, String token){
        if (!jwtComponente.isTokenValid(token)){
            throw new TokenNotValidException();
        }

        Claims claims = jwtComponente.getClaims(token);
        UserDetails usuario = userDetailsService.loadUserByUsername(claims.getSubject());

        return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = request.getHeader("Authorization");

        if(token != null && token.startsWith("Token ")){
            try {
                UsernamePasswordAuthenticationToken auth = pegarAutenticacao(request, token.substring(6));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }catch (TokenNotValidException exception){
                System.out.println(exception.getMessage());
            }
        }
        /*Davi: Este metodo está chamando meu GET, sem argumentos, e assim gerando uma série de excessões que impedem a testagem de outras classes*/
        chain.doFilter(request, response);
        /*; Quando comentado ele passa a responder todas as requisicoes com 200OK, ou seja continua impedindo a testagem, que m* hein*;*/
    }
}
