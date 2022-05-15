package br.com.zup.Projeto.Doadores;

import org.springframework.stereotype.Service;

@Service
public class ServiceDTO
{
    public Doador doador(DoadorIDTO doadorIDTO)
    {
        Doador doador = new Doador();
        doador.setNome(doadorIDTO.getNome());
        doador.setTelefone(doadorIDTO.getTelefone());
        doador.setCpf(doadorIDTO.getCpf());
        doador.setEndereco(doadorIDTO.getEndereco());
        return doador;
    }

    public DoadorODTO doadorODTO(Doador doador)
    {
        DoadorODTO doadorODTO = new DoadorODTO();
        doadorODTO.setNome(doador.getNome());
        doadorODTO.setTelefone(doador.getTelefone());
        doadorODTO.setCpf(doador.getCpf());
        doadorODTO.setEndereco(doador.getEndereco());
        doadorODTO.setId(doador.getId());
        return doadorODTO;
    }
}
