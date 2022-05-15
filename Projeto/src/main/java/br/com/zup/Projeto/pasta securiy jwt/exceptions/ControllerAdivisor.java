package br.com.zup.Projeto.exceptions;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(AccessoNegadoException.class)
    public ResponseEntity<?> runtimeHandler(AccessoNegadoException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<?> runtimeHandler(TokenNotValidException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }
}
