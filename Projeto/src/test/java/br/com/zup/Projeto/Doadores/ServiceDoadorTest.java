package br.com.zup.Projeto.Doadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.Optional;
import java.util.Vector;

@SpringBootTest
public class ServiceDoadorTest
{
    @Autowired
    private ServiceDoador serviceDoador;
    @MockBean
    private RepositoryDoadores repositoryDoadores;

    @Test
    public void testCreateDoador()
    {
        Doador createDoador = new Doador();
        Mockito.when(repositoryDoadores.save(Mockito.any(Doador.class)))
               .thenReturn(createDoador);
        Doador testCreateDoador = serviceDoador.createDoador(createDoador);
        Assertions.assertNotNull(testCreateDoador);
        Assertions.assertEquals(createDoador, testCreateDoador);
    }
    @Test
    public void testReadDoador()
    {
        Iterable<Doador> readDoador = new Vector<Doador>();
        Mockito.when(repositoryDoadores.findAll())
               .thenReturn(readDoador);
        Iterable<Doador> testReadDoador = serviceDoador.readDoador();
        Assertions.assertNotNull(testReadDoador);
        Assertions.assertEquals(readDoador, testReadDoador);
    }
    @Test
    public void testReadDoadorIdNoThrow()
    {
        Optional<Doador> readDoadorId = Optional.of(new Doador());
        final int id = 1;
        Mockito.when(repositoryDoadores.findById(Mockito.anyInt()))
               .thenReturn(readDoadorId);
        Doador testReadDoadorId = serviceDoador.readDoadorId(id);
        Assertions.assertEquals(readDoadorId.get(), testReadDoadorId);
        Assertions.assertDoesNotThrow(() -> serviceDoador.readDoadorId(id));
    }
    @Test
    public void testReadDoadorIdThrow()
    {
        Optional<Doador> readDoadorId = Optional.empty();
        final int id = 1;
        Mockito.when(repositoryDoadores.findById(Mockito.anyInt()))
               .thenReturn(readDoadorId);
        Assertions.assertThrows(RuntimeException.class, () -> serviceDoador.readDoadorId(id));
    }
}
