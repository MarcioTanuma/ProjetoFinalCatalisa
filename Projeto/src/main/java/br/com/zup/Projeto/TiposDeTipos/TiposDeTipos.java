package br.com.zup.Projeto.TiposDeTipos;

import br.com.zup.Projeto.TiposDeDoador.OsTiposDeDoador;

import javax.persistence.*;

@Entity
@Table(name = "tiposdetipos")
public class TiposDeTipos
{
    @Enumerated(value = EnumType.STRING)
    private OsTiposDeTipos tiposDeTipos;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public TiposDeTipos() {
    }

    public OsTiposDeTipos getTiposDeTipos() {
        return tiposDeTipos;
    }

    public void setTiposDeTipos(OsTiposDeTipos tiposDeTipos) {
        this.tiposDeTipos = tiposDeTipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
