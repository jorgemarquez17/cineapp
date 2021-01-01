package cl.duoc.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	List<Noticia> findByTitulo(String titulo);
	List<Noticia> findByEstatus(String estatus);
	List<Noticia> findByFecha(Date fecha);
	
	//where estatus =? and fecha=?
	List<Noticia> findByEstatusAndFecha(String estatus,Date fecha);
	
	//where estatus =? or fecha=?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
	//where fecha between ?  and ?
	List<Noticia> findByFechaBetween(Date fecha1,Date fecha2);
	
}
