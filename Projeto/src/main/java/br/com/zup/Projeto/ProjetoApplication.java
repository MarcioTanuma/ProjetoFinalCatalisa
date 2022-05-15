package br.com.zup.Projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// Security autoconfig para nao validar usuario e senha
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class);
	}


	@Bean
	public PasswordEncoder getPasswordencoder(){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;


	}

}
