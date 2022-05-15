package br.com.zup.Projeto.Beneficiario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("beneficiarios")
public class BeneficiarioController {

    private BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    public Beneficiario cadastrarBeneficiario(@RequestBody Beneficiario beneficiario){
        return beneficiarioService.cadastrarBeneficiario(beneficiario);
    }

    @GetMapping
    public List<Beneficiario> listarBeneficiarios(){
        return beneficiarioService.listarBeneficiarios();
    }

    @DeleteMapping("/{id}")
    public Optional<Beneficiario> deletarBeneficiario(@PathVariable int id){
        return beneficiarioService.deletarBeneficiario(id);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity alterarBeneficiario(@PathVariable("id") int id, @RequestBody Beneficiario beneficiario) {
        return beneficiarioService.alterarBeneficiario(id, beneficiario);
    }


}
