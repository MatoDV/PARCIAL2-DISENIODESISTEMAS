package ar.edu.davinci.parcial.Repository;

import ar.edu.davinci.parcial.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
    List<Pokemon> findByPoderBetween(int minPoder, int maxPoder);
}
