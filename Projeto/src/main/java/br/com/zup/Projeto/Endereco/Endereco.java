package br.com.zup.Projeto.Endereco;

import br.com.zup.Projeto.Endereco.NumeroEComplemento.NumeroEComplemento;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco
{
    @ManyToOne
    private NumeroEComplemento numeroEComplemento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public Endereco() {
    }

    public NumeroEComplemento getNumeroEComplemento() {
        return numeroEComplemento;
    }

    public void setNumeroEComplemento(NumeroEComplemento numeroEComplemento) {
        this.numeroEComplemento = numeroEComplemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
