package br.com.zup.Security.Security;

import br.com.zup.Security.JWT.FiltroDeAutenticacao;
import br.com.zup.Security.JWT.JWTComponent;
import br.com.zup.Security.JWT.UsuarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ConfiguracoesDeSeguranca extends WebSecurityConfigurerAdapter
{
    private static final String[] GET_PUBLICOS =
	{
        "/usuario/{\\d+}"
    };
    private static final String[] POST_PUBLICOS =
    {
        "/usuario/"     ,
        "/produtos"
    };

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTComponent jwtComponent;

    @Override
    protected void configure(HttpSecurity http) throws Exception 
	{
        http.csrf().disable();
        http.cors().configurationSource(configuracaodeCors());

        http.authorizeRequests().antMatchers(HttpMethod.POST, POST_PUBLICOS).permitAll()
                                .antMatchers(HttpMethod.GET, GET_PUBLICOS).permitAll()
                                .anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new FiltroDeAutenticacao(jwtComponent, authenticationManager()));
	}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt());
    }
	@Bean
    protected CorsConfigurationSource configuracaodeCors()
    {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
	@Bean
    BCryptPasswordEncoder bCrypt()
	{
		return new BCryptPasswordEncoder();
	}

}
