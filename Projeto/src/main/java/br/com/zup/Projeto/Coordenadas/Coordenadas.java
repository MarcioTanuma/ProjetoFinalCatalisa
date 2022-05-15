package br.com.zup.Projeto.Coordenadas;

import javax.persistence.*;

@Entity
@Table(name = "coordenadas")
public class Coordenadas
{
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Coordenadas() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
