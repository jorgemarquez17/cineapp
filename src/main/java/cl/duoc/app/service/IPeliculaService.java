package cl.duoc.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.duoc.app.model.Pelicula;

public interface IPeliculaService {
	
	void insertar(Pelicula pelicula);	
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGenero();
	void eliminar(int idPelicula);
	Page<Pelicula> buscarTodas(Pageable page);
	
	

}
