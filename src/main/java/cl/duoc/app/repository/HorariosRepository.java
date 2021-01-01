package cl.duoc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

	
}
