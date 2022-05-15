package br.com.zup.Projeto.Entidades;


import br.com.zup.Projeto.TiposDeDoador.TiposDeDoador;
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
class ServiceEntidadesTest {

    @Autowired
    private ServiceEntidades serviceEntidades;

    @MockBean
    private RepositoryEntidades repositoryEntidades;

    private MockMvc mockMvc;

    @Test
    public void testcadastrarEntidade(){
        Entidade entidade = new Entidade();
        Mockito.when(repositoryEntidades.save(Mockito.any(Entidade.class)))
                .thenReturn(entidade);
        Entidade objEntidadeTeste = serviceEntidades.createEntidade(entidade);
        Assertions.assertEquals(entidade, objEntidadeTeste);
    }
/*
    @Test
    public void testExibirEntidadeDoador(){
        Iterable<Entidade> readEntidatesDoador = null;
        TiposDeDoador tiposDeDoador = new TiposDeDoador();
        List<TiposDeDoador> beneficiarioIterable = Arrays.asList(tiposDeDoador);
        readEntidatesDoador = repositoryEntidades.findAllBydoadoresIn(beneficiarioIterable);
        Mockito.when(readEntidatesDoador).thenReturn(readEntidatesDoador);

        Assertions.assertTrue(serviceEntidades.readEntidadesDoador(beneficiarioIterable) instanceof List);

    }
*/
    @Test
    public void testReadEntidadeId(){
        Entidade entidade = new Entidade();
        Optional<Entidade> entidadeOptional = Optional.of(new Entidade());
        Mockito.when(repositoryEntidades.findById(Mockito.anyInt())).thenReturn(Optional.of(entidade));
        Assertions.assertEquals(entidade, serviceEntidades.readEntidadeId(12));
    }

    @Test
    public void testDeleteEntidadeId(){
        final Integer id = 22;
        Entidade entidade = new Entidade();
        Optional<Entidade> entidadeOptional = Optional.of(new Entidade());
        Mockito.when(repositoryEntidades.findById(Mockito.anyInt())).thenReturn(Optional.of(entidade));
        Assertions.assertEquals(entidade, serviceEntidades.readEntidadeId(id));
        serviceEntidades.deleteEntidadeId(id);
        Mockito.verify(repositoryEntidades).deleteById(id);
    }

    @Test
    public void testDeleteEntidade(){
        Entidade entidade = new Entidade();
        serviceEntidades.deleteEntidade(entidade);
        Mockito.verify(repositoryEntidades).delete(entidade);

    }



}