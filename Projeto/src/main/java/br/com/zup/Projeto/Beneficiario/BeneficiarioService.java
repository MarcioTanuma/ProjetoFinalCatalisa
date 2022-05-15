package br.com.zup.Projeto.Beneficiario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    private RepositoryBeneficiario repositoryBeneficiario;

    @Autowired
    public BeneficiarioService(RepositoryBeneficiario repositoryBeneficiario) {
        this.repositoryBeneficiario = repositoryBeneficiario;
    }

    public Beneficiario cadastrarBeneficiario(Beneficiario beneficiario){
        return repositoryBeneficiario.save(beneficiario);
    }

    public List<Beneficiario> listarBeneficiarios(){
        return repositoryBeneficiario.findAll();
    }

    public Optional<Beneficiario> listarBeneficiarioPorId(int id){
        return repositoryBeneficiario.findById(id);
    }

    public Optional<Beneficiario>  deletarBeneficiario (int id) {
        Optional<Beneficiario> objBeneficiario = repositoryBeneficiario.findById(id);
        if(!objBeneficiario.isEmpty() && objBeneficiario!=null) {
            repositoryBeneficiario.deleteById(id);
            return objBeneficiario;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Beneficiario> alterarBeneficiario(int id, Beneficiario beneficiario) {

        return repositoryBeneficiario.findById(id)
                .map(objBeneficiario -> {
                    objBeneficiario.setNome(beneficiario.getNome());
                    objBeneficiario.setEndereco(beneficiario.getEndereco());
                    objBeneficiario.setCpf(beneficiario.getCpf());
                    objBeneficiario.setDependentes(beneficiario.getDependentes());
                    objBeneficiario.setIdade(beneficiario.getIdade());
                    objBeneficiario.setEstadoCivil(beneficiario.getEstadoCivil());
                    objBeneficiario.setOrigemRenda(beneficiario.getOrigemRenda());
                    objBeneficiario.setTelefone(beneficiario.getTelefone());
                    Beneficiario objatualizar = repositoryBeneficiario.save(objBeneficiario);
                    return ResponseEntity.ok().body(objatualizar);
                }).orElse(ResponseEntity.notFound().build());
             }
}
