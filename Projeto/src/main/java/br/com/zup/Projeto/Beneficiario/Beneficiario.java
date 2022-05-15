package br.com.zup.Projeto.Beneficiario;

import br.com.zup.Projeto.Endereco.Endereco;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String nome;
    private String email;
    @Column(nullable = true)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String cpf;
    @ManyToOne
    private Endereco endereco;
    @Column(nullable = true)
    private int idade;
    @Column(nullable = true)
    private EstadoCivil estadoCivil;
    @Column(nullable = true)
    private int dependentes;
    @Column(nullable = true)
    private double renda;
    @Column(nullable = true)
    private OrigemRenda origemRenda;

    public Beneficiario() {
    }

    public Beneficiario(int id, String nome, String email, String telefone, String cpf, Endereco endereco, int idade, EstadoCivil estadoCivil, int dependentes, double renda, OrigemRenda origemRenda) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.estadoCivil = estadoCivil;
        this.dependentes = dependentes;
        this.renda = renda;
        this.origemRenda = origemRenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public OrigemRenda getOrigemRenda() {
        return origemRenda;
    }

    public void setOrigemRenda(OrigemRenda origemRenda) {
        this.origemRenda = origemRenda;
    }
}
