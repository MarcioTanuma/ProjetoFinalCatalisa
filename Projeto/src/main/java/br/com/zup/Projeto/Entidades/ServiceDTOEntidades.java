package br.com.zup.Projeto.Entidades;

import br.com.zup.Projeto.Beneficiario.Beneficiario;
import br.com.zup.Projeto.Doadores.DoadorIDTO;
import br.com.zup.Projeto.TiposDeBeneficiario.OsTiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeBeneficiario.TiposDeBeneficiario;
import br.com.zup.Projeto.TiposDeDoacoes.OsTiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoacoes.TiposDeDoacoes;
import br.com.zup.Projeto.TiposDeDoador.OsTiposDeDoador;
import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
import br.com.zup.Projeto.TiposDeDonativos.OsTiposDeDonativos;
import br.com.zup.Projeto.TiposDeDonativos.TiposDeDonativos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceDTOEntidades
{
    public Entidade entidade(EntidadeIDTO entidadeIDTO)
    {
        Entidade entidade = new Entidade();
        entidade.setEndereco(entidadeIDTO.getEndereco());
        {List<TiposDeBeneficiario> list = new ArrayList<TiposDeBeneficiario>();
        int index = 0;
        for (String string : entidadeIDTO.getBeneficiarios()) {
             TiposDeBeneficiario tiposDeBeneficiario = new TiposDeBeneficiario();
             tiposDeBeneficiario.setTiposDeBeneficiario(OsTiposDeBeneficiario.valueOf(entidadeIDTO.getBeneficiarios().get(index)));
             list.add(tiposDeBeneficiario);
             index = index + 1;
        }
        entidade.setBeneficiarios(list);
        }
        {List<TiposDeDoador> list = new ArrayList<TiposDeDoador>();
            int index = 0;
            for (String string : entidadeIDTO.getDoadores()) {
                TiposDeDoador tiposDeDoador = new TiposDeDoador();
                tiposDeDoador.setTiposDeDoador(OsTiposDeDoador.valueOf(entidadeIDTO.getDoadores().get(index)));
                list.add(tiposDeDoador);
                index = index + 1;
            }
            entidade.setDoadores(list);
        }
        {List<TiposDeDonativos> list = new ArrayList<TiposDeDonativos>();
            int index = 0;
            for (String string : entidadeIDTO.getDonativos()) {
                TiposDeDonativos tiposDeDonativos = new TiposDeDonativos();
                tiposDeDonativos.setTiposDeDonativos(OsTiposDeDonativos.valueOf(entidadeIDTO.getDonativos().get(index)));
                list.add(tiposDeDonativos);
                index = index + 1;
            }
            entidade.setDonativos(list);
        }
        {List<TiposDeDoacoes> list = new ArrayList<TiposDeDoacoes>();
            int index = 0;
            for (String string : entidadeIDTO.getDoacoes()) {
                TiposDeDoacoes tiposDeDoacoes = new TiposDeDoacoes();
                tiposDeDoacoes.setTiposDeDoacoes(OsTiposDeDoacoes.valueOf(entidadeIDTO.getDoacoes().get(index)));
                list.add(tiposDeDoacoes);
                index = index + 1;
            }
            entidade.setDoacoes(list);
        }
        entidade.setCnpj(entidadeIDTO.getCnpj());
        entidade.setEmail(entidadeIDTO.getEmail());
        entidade.setEnderecoWeb(entidadeIDTO.getEnderecoWeb());
        entidade.setFuncionamento(entidadeIDTO.getFuncionamento());
        entidade.setNomeFantasia(entidadeIDTO.getNomeFantasia());
        entidade.setRazaoSocial(entidadeIDTO.getRazaoSocial());
        entidade.setTelefone(entidadeIDTO.getTelefone());
        return entidade;
    }
    public EntidadeODTO entidadeODTO(Entidade entidade)
    {
        EntidadeODTO entidadeODTO = new EntidadeODTO();
        entidadeODTO.setBeneficiarios(entidade.getBeneficiarios());
        entidadeODTO.setDoadores(entidade.getDoadores());
        entidadeODTO.setDonativos(entidade.getDonativos());
        entidadeODTO.setDoacoes(entidade.getDoacoes());
        entidadeODTO.setFuncionamento(entidade.getFuncionamento());
        entidadeODTO.setNomeFantasia(entidade.getNomeFantasia());
        entidadeODTO.setEmail(entidade.getEmail());
        entidadeODTO.setEndereco(entidade.getEndereco());
        entidadeODTO.setEnderecoWeb(entidade.getEnderecoWeb());
        entidadeODTO.setTelefone(entidade.getTelefone());
        entidadeODTO.setCnpj(entidade.getCnpj());
        entidadeODTO.setRazaoSocial(entidade.getRazaoSocial());
        entidadeODTO.setId(entidade.getId());
        return entidadeODTO;
    }
}
