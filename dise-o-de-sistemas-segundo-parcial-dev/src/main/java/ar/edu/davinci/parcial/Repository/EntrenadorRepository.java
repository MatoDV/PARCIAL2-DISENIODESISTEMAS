package ar.edu.davinci.parcial.Repository;

import ar.edu.davinci.parcial.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador,Long> {
    List<Entrenador> findByNombreIgnoreCase(String nombre);
}
