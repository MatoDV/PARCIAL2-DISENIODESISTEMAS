package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<Pokemon> crearPokemon(Pokemon pokemon){
        Pokemon nuevoPokemon = pokemonService.crearPokemon(pokemon);
        return new ResponseEntity<>(nuevoPokemon, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> recuperarPokemonPorId(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.recuperarPokemonPorId(id);
        if (pokemon != null) {
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar-por-poder")
    public ResponseEntity<List<Pokemon>> buscarPokemonsPorRangoDePoder(@RequestParam int minPoder, @RequestParam int maxPoder) {
        List<Pokemon> pokemons = pokemonService.buscarPokemonsPorRangoDePoder(minPoder, maxPoder);
        if (!pokemons.isEmpty()) {
            return new ResponseEntity<>(pokemons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
