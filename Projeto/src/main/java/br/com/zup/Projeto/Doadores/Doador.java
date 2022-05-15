package br.com.zup.Projeto.Doadores;

import br.com.zup.Projeto.Endereco.Endereco;

import javax.persistence.*;

@Entity
@Table(name = "doadores")
public class Doador
{
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String cpf;
    //@Column(nullable = false)
    @ManyToOne
    private Endereco endereco;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public Doador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
