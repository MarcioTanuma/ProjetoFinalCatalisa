package br.com.zup.Projeto.AgendarDoacao;

import br.com.zup.Projeto.Doadores.Doador;
import br.com.zup.Projeto.Entidades.Entidade;
import br.com.zup.Projeto.TiposDeDoacoes.TiposDeDoacoes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "doacoes")
public class Doacao
{
    @ManyToOne
    private Doador doador;
    @ManyToOne
    private Entidade entidade;
    @ManyToOne
    private TiposDeDoacoes doacoes;
    private LocalDateTime horario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
}
