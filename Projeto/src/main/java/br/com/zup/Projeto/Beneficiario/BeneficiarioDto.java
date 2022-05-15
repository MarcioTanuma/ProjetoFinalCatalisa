package br.com.zup.Projeto.Beneficiario;

import javax.persistence.Column;

public class BeneficiarioDto {

    private int id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = true)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = true)
    private String cep;
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

    public BeneficiarioDto() {
    }

    public BeneficiarioDto(int id, String nome, String telefone, String cpf, String cep, int idade, EstadoCivil estadoCivil, int dependentes, double renda, OrigemRenda origemRenda) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cep = cep;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
