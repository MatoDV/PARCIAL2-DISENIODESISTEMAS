package ar.edu.davinci.parcial.controller;


import ar.edu.davinci.parcial.Model.Entrenador;
import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController{
    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<Entrenador> crearEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador nuevoEntrenador = entrenadorService.crearEntrenador(entrenador);
        return new ResponseEntity<>(nuevoEntrenador, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> recuperarEntrenadorPorId(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.recuperarEntrenadorPorId(id);
        if (entrenador != null) {
            return new ResponseEntity<>(entrenador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{entrenadorId}/capturar")
    public ResponseEntity<Entrenador> capturarPokemon(@PathVariable Long entrenadorId, @RequestBody Pokemon pokemon) {
        Entrenador entrenador = entrenadorService.capturarPokemon(entrenadorId, pokemon);
        if (entrenador != null) {
            return new ResponseEntity<>(entrenador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Entrenador>> buscarEntrenadoresPorNombre(@RequestParam String nombre) {
        List<Entrenador> entrenadores = entrenadorService.buscarEntrenadorPorNombre(nombre);
        if (!entrenadores.isEmpty()) {
            return new ResponseEntity<>(entrenadores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pelear/{entrenadorId}/vs/{segundoEntrenadorId}")
    public ResponseEntity<String> peleaDeEntrenadores(@PathVariable Long entrenadorId1,@PathVariable Long entrenadorId2) {
        try {
            entrenadorService.pelear(entrenadorId1, entrenadorId2);
            return new ResponseEntity<>("La pelea termino correctamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al intentar pelear: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
