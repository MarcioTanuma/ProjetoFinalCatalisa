package br.com.zup.Projeto.Beneficiario;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;




@SpringBootTest
class BeneficiarioServiceTest {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @MockBean
    private RepositoryBeneficiario repositoryBeneficiario;

    private MockMvc mockMvc;

    @Test
    public void testarCadastroDeBeneficiario(){
        Beneficiario beneficiario = new Beneficiario();
        Mockito.when(repositoryBeneficiario.save(Mockito.any(Beneficiario.class)))
                .thenReturn(beneficiario);

        Beneficiario objBeneficiarioTeste = beneficiarioService.cadastrarBeneficiario(beneficiario);
        Assertions.assertEquals(beneficiario, objBeneficiarioTeste);
    }

    @Test
    public void testarlistagemDeBeneficiarios() {
        Beneficiario beneficiario = new Beneficiario();
        List<Beneficiario> beneficiarioIterable = Arrays.asList(beneficiario);
        Mockito.when(repositoryBeneficiario.findAll()).thenReturn(beneficiarioIterable);

        Assertions.assertTrue(beneficiarioService.listarBeneficiarios() instanceof List);
    }

    @Test
    public void testarListarBeneficiarioPorId(){

        Optional<Beneficiario> beneficiario = Optional.of(new Beneficiario());
        Optional<Beneficiario> beneficiarioOptional = beneficiario;
        Mockito.when(repositoryBeneficiario.findById(Mockito.anyInt())).thenReturn(beneficiarioOptional);

        Assertions.assertEquals(beneficiario, beneficiarioService.listarBeneficiarioPorId(12));
    }

    @Test
    public void testarDeletarBeneficiario(){

        final Optional<Beneficiario> beneficiario = Optional.of(new Beneficiario());

        Mockito.when(repositoryBeneficiario.findById(1))
                .thenReturn(beneficiario);

        Optional<Beneficiario> result = beneficiarioService.deletarBeneficiario(1);

        Mockito.when(repositoryBeneficiario.findById(1)).thenReturn(beneficiario).thenReturn(null);

    }








}