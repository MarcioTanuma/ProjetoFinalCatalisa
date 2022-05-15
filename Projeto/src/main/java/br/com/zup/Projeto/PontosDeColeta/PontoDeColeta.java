package br.com.zup.Projeto.PontosDeColeta;

import br.com.zup.Projeto.Coordenadas.Coordenadas;
import br.com.zup.Projeto.Entidades.*;
import br.com.zup.Projeto.TiposDeBeneficiario.TiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeDoacoes.TiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
import br.com.zup.Projeto.TiposDeDonativos.TiposDeDonativos;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "pontosdecoleta")
public class PontoDeColeta
{
    @ManyToOne
    private Coordenadas coordenadas;
    private String nome;
    private String telefone;
    private String cep;
    @ManyToOne(targetEntity = Entidade.class)
    private List<Entidade> entidades;
    @ManyToOne(targetEntity = TiposDeBeneficiario.class)
    private List<TiposDeBeneficiario> beneficiarios;
    @ManyToOne(targetEntity = TiposDeDonativos.class)
    private List<TiposDeDonativos> donativos;
    @ManyToOne(targetEntity = TiposDeDoador.class)
    private List<TiposDeDoador> doadores;
    @ManyToOne(targetEntity = TiposDeDoacoes.class)
    private List<TiposDeDoacoes> doacoes;
    private LocalTime funcionamento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    public PontoDeColeta() {
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidade> entidades) {
        this.entidades = entidades;
    }

    public List<TiposDeBeneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<TiposDeBeneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<TiposDeDonativos> getDonativos() {
        return donativos;
    }

    public void setDonativos(List<TiposDeDonativos> donativos) {
        this.donativos = donativos;
    }

    public List<TiposDeDoador> getDoadores() {
        return doadores;
    }

    public void setDoadores(List<TiposDeDoador> doadores) {
        this.doadores = doadores;
    }

    public List<TiposDeDoacoes> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<TiposDeDoacoes> doacoes) {
        this.doacoes = doacoes;
    }

    public LocalTime getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(LocalTime funcionamento) {
        this.funcionamento = funcionamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
 /*@ElementCollection()
    @Enumerated()
    @OrderColumn()
    @Type(type = "br.com.zup.Projeto.Entidades.Doacoes")
    @Column(name = "doadores", table = "doadores")
    @MapKeyColumn(name = "doadores", table = "doadores",  )*/
//private Set<Doadores> doadores = EnumSet.noneOf(Doadores.class);
//@ElementCollection(targetClass = Doacoes.class)



    /*@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Doacoes", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)*/