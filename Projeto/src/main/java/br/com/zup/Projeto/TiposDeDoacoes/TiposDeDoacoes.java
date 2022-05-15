package br.com.zup.Projeto.TiposDeDoacoes;

import javax.persistence.*;

@Entity
@Table(name = "tiposdedoacoes")
public class TiposDeDoacoes
{
    @Enumerated(value = EnumType.STRING)
    private OsTiposDeDoacoes tiposDeDoacoes;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public TiposDeDoacoes() {
    }

    public OsTiposDeDoacoes getTiposDeDoacoes() {
        return tiposDeDoacoes;
    }

    public void setTiposDeDoacoes(OsTiposDeDoacoes tiposDeDoacoes) {
        this.tiposDeDoacoes = tiposDeDoacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
