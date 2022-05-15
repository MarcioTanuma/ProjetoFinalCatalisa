package br.com.zup.Projeto.TiposDeDoador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ServiceTiposDeDoadorTest
{
    @Autowired
    private ServiceTiposDeDoador servicetiposdedoador;
    @MockBean
    private RepositoryTiposDeDoador repositoryTiposDeDoador;

    @Test
    public void testServiceTiposDeDoadorNoThrow()
    {
        TiposDeDoador serviceTiposDeDoador = new TiposDeDoador();
        serviceTiposDeDoador.setTiposDeDoador(OsTiposDeDoador.CRIANCAS);
        serviceTiposDeDoador.setId(1);
        Mockito.when(repositoryTiposDeDoador.save(Mockito.any(TiposDeDoador.class)))
                .thenReturn(serviceTiposDeDoador);
        TiposDeDoador testServiceTiposDeDoador = null;
        /*testServiceTiposDeDoador = servicetiposdedoador.servicetiposdedoador();*/
        servicetiposdedoador.servicetiposdedoador();
        Assertions.assertDoesNotThrow(() -> servicetiposdedoador.servicetiposdedoador());
        /*Assertions.assertNotNull(testServiceTiposDeDoador);
        Assertions.assertEquals(serviceTiposDeDoador, testServiceTiposDeDoador);*/
    }
    /*@Test
    public void testServiceTiposDeDoadorThrow()
    {
        TiposDeDoador serviceTiposDeDoador = new TiposDeDoador();
        Mockito.when(repositoryTiposDeDoador.save(Mockito.any(TiposDeDoador.class)))
               .thenReturn(serviceTiposDeDoador);
        servicetiposdedoador.servicetiposdedoador();
        Assertions.assertThrows(Exception.class, () -> servicetiposdedoador.servicetiposdedoador());
    }*/
}
