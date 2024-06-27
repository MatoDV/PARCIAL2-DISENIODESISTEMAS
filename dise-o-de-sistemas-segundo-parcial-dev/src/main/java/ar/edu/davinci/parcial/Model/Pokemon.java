package ar.edu.davinci.parcial.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String especie;
    private float vida;
    private int poder;

    public Pokemon() {
    }

    public Pokemon(String tipo, String especie, float vida, int poder) {
        this.tipo = tipo;
        this.especie = especie;
        this.vida = 100;
        this.poder = poder;
    }

    public void atacar(Pokemon otroPokemon) {
    int poderAtaque = this.getPoder();

    float daño = poderAtaque * 0.2f;

    otroPokemon.restarVida(daño);

    System.out.println(this.getEspecie() + "Ataco a" + otroPokemon.getEspecie() + " y fue efectivo, causandole" + daño);

    if(otroPokemon.getVida() <=0){
        System.out.println(otroPokemon.getEspecie() + "murio");
    }
    }


    public void restarVida(float cantidad) {
        this.vida -= cantidad;
    }

    public void aumentarVida(float cantidad) {
        this.vida += cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}
