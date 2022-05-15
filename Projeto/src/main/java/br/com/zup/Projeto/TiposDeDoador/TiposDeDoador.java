package br.com.zup.Projeto.TiposDeDoador;

import javax.persistence.*;

@Entity
@Table(name = "tiposdedoador")
public class TiposDeDoador
{
    @Enumerated(value = EnumType.STRING)
    private OsTiposDeDoador tiposDeDoador;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public TiposDeDoador() {
    }

    public OsTiposDeDoador getTiposDeDoador() {
        return tiposDeDoador;
    }

    public void setTiposDeDoador(OsTiposDeDoador tiposDeDoador) {
        this.tiposDeDoador = tiposDeDoador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
