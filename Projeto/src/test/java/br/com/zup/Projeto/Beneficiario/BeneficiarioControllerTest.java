package br.com.zup.Projeto.Beneficiario;


import br.com.zup.Projeto.Endereco.Endereco;
import br.com.zup.Projeto.Endereco.NumeroEComplemento.NumeroEComplemento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(BeneficiarioController.class)
class BeneficiarioControllerTest {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private MockMvc mockMvc;

    private Beneficiario beneficiarioDto;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        beneficiarioDto = new Beneficiario();
        beneficiarioDto.setNome("Marcio");
        beneficiarioDto.setCpf("12345678");
        beneficiarioDto.setDependentes(2);
        beneficiarioDto.setIdade(25);
        Endereco endereco = new Endereco();
        endereco.setCep("12345");
        endereco.setBairro("Teste");
        endereco.setCidade("Sao Paulo");
        endereco.setEstado("SP");
        endereco.setLogradouro("Logradouro");
        NumeroEComplemento numero = new NumeroEComplemento();
        numero.setNumero("123");
        numero.setComplemento("centro");
        endereco.setNumeroEComplemento(numero);
        beneficiarioDto.setEndereco(endereco);
        beneficiarioDto.setEstadoCivil(EstadoCivil.MENOR);
        beneficiarioDto.setTelefone("112233555");
        beneficiarioDto.setOrigemRenda(OrigemRenda.PROPRIA);
        beneficiarioDto.setRenda(10000);
        beneficiarioDto.setEmail("teste@gmail.com");

        objectMapper = new ObjectMapper();
    }

    @Test
    public void testarCadastroBeneficiario() throws Exception {
        Mockito.when(beneficiarioService.cadastrarBeneficiario(Mockito.any(Beneficiario.class)))
                .thenReturn(beneficiarioDto);
        String json = objectMapper.writeValueAsString(beneficiarioDto);
        ResultActions resultadoDaRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/beneficiarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

        String jsonResposta = resultadoDaRequisicao.andReturn().getResponse().getContentAsString();
        Beneficiario beneficiario = objectMapper.readValue(jsonResposta, Beneficiario.class);

    }


}