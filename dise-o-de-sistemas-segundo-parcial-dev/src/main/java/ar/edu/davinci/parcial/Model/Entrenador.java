package ar.edu.davinci.parcial.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String genero;
    private int edad;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "entrenador_id")
    private List<Pokemon> pokemons = new ArrayList<>();

    public Entrenador() {
    }

    public Entrenador(String nombre, Date fechaNacimiento, String nacionalidad, String genero, int edad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.edad = edad;
    }

    public void capturarPokemon(Pokemon pokemon) {
        if (pokemons.size() < 5) {
            pokemons.add(pokemon);
        } else {
            System.out.println("No se pueden tener más de 5 pokemons.");
        }
    }

    public void pelear(Entrenador otroEntrenador) {
        System.out.println(this.getNombre() + " está peleando contra " + otroEntrenador.getNombre());

        List<Pokemon> misPokemons = this.getPokemons();
        List<Pokemon> pokemonsRival = otroEntrenador.getPokemons();

        int indicePokemonActual = 0;
        int indicePokemonRivalActual = 0;

        while (indicePokemonActual < misPokemons.size() && indicePokemonRivalActual < pokemonsRival.size()) {
            Pokemon miPokemon = misPokemons.get(indicePokemonActual);
            Pokemon pokemonRival = pokemonsRival.get(indicePokemonRivalActual);

            miPokemon.atacar(pokemonRival);

            if (pokemonRival.getVida() <= 0) {
                System.out.println(pokemonRival.getEspecie() + " de " + otroEntrenador.getNombre() + " murio");
                indicePokemonRivalActual++;
            } else {
                pokemonRival.atacar(miPokemon);
                    if (miPokemon.getVida() <= 0) {
                        System.out.println(miPokemon.getEspecie() + " de " + this.getNombre() + " murio");
                        indicePokemonActual++;
                    }
            }
        }

        // Verificar quién fue el ganador del enfrentamiento
        if (indicePokemonActual >= misPokemons.size()) {
            System.out.println(this.getNombre() + " gano la pelea contra " + otroEntrenador.getNombre());
        } else {
            System.out.println(otroEntrenador.getNombre() + " gano la pelea contra " + this.getNombre());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
