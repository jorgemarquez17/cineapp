package cl.duoc.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
	
	
}
