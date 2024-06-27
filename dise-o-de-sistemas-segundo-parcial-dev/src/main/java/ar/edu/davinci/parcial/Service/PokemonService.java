package ar.edu.davinci.parcial.Service;

import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Repository.PokemonRepository;
import ar.edu.davinci.parcial.controller.PokemonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon crearPokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }
    public Pokemon recuperarPokemonPorId(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public List<Pokemon> buscarPokemonsPorRangoDePoder(int minPoder, int maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }
}
