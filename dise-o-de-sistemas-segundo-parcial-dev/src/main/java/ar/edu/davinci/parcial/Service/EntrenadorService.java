package ar.edu.davinci.parcial.Service;

import ar.edu.davinci.parcial.Model.Entrenador;
import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;
    public Entrenador crearEntrenador(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }
    public Entrenador recuperarEntrenadorPorId(Long id){
        return entrenadorRepository.findById(id).orElse(null);
    }

    public Entrenador capturarPokemon(Long entrenadorId, Pokemon pokemon){
        Entrenador entrenador = entrenadorRepository.findById(entrenadorId).orElse(null);
        if (entrenador!=null){
            entrenador.capturarPokemon(pokemon);
            return entrenadorRepository.save(entrenador);
        }
        return null;
    }

    public void pelear(Long entrenadorId1, Long entrenadorId2) {
        Entrenador entrenador1 = entrenadorRepository.findById(entrenadorId1).orElse(null);
        Entrenador entrenador2 = entrenadorRepository.findById(entrenadorId2).orElse(null);

        if (entrenador1 == null || entrenador2 == null) {
            System.out.println("No se pudo encontrar al entrenador");
        }

        entrenador1.pelear(entrenador2);

        entrenadorRepository.save(entrenador1);
        entrenadorRepository.save(entrenador2);
    }

    public List<Entrenador> buscarEntrenadorPorNombre(String nombre) {
        return entrenadorRepository.findByNombreIgnoreCase(nombre);
    }
}
