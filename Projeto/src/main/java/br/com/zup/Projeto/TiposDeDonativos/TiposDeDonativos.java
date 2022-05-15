package br.com.zup.Projeto.TiposDeDonativos;

import br.com.zup.Projeto.TiposDeDoacoes.OsTiposDeDoacoes;

import javax.persistence.*;

@Entity
@Table(name = "tiposdedonativos")
public class TiposDeDonativos
{
    @Enumerated(value = EnumType.STRING)
    private OsTiposDeDonativos tiposDeDonativos;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public TiposDeDonativos() {
    }

    public OsTiposDeDonativos getTiposDeDonativos() {
        return tiposDeDonativos;
    }

    public void setTiposDeDonativos(OsTiposDeDonativos tiposDeDonativos) {
        this.tiposDeDonativos = tiposDeDonativos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
