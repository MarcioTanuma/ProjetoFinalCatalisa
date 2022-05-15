package br.com.zup.Projeto.Coordenadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

@Service
public class ServiceCoordenadas
{
    @Autowired
    private RepositoryCoordenadas repositoryCoordenadas;

    public double distancia(Coordenadas coordenadasA, Coordenadas coordenadasB)
    {
        double distancia = 0;
        distancia = sqrt( pow( coordenadasB.getLongitude() - coordenadasA.getLongitude() , 2 ) + pow( coordenadasB.getLatitude() - coordenadasA.getLatitude() , 2 ) );
        return distancia;
    }
    public Coordenadas createCoordenadas(Coordenadas coordenadas)
    {
        Coordenadas createCoordenadas = null;
        createCoordenadas = repositoryCoordenadas.save(coordenadas);
        return createCoordenadas;
    }
}
