package br.com.zup.Projeto.TiposDeBeneficiario;

import br.com.zup.Projeto.TiposDeDoacoes.OsTiposDeDoacoes;

import javax.persistence.*;

@Entity
@Table(name = "tiposdebeneficiario")
public class TiposDeBeneficiario
{
    @Enumerated(value = EnumType.STRING)
    private OsTiposDeBeneficiario tiposDeBeneficiario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public TiposDeBeneficiario() {
    }

    public OsTiposDeBeneficiario getTiposDeBeneficiario() {
        return tiposDeBeneficiario;
    }

    public void setTiposDeBeneficiario(OsTiposDeBeneficiario tiposDeBeneficiario) {
        this.tiposDeBeneficiario = tiposDeBeneficiario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
