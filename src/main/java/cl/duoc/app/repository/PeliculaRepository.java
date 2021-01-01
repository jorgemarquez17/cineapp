package cl.duoc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.app.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

	
}
