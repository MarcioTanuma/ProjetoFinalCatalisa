package br.com.zup.Projeto.Endereco.NumeroEComplemento;

import javax.persistence.*;

@Entity
@Table(name = "numerosecompletementos")
public class NumeroEComplemento
{
    private String numero;
    private String complemento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public NumeroEComplemento() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
