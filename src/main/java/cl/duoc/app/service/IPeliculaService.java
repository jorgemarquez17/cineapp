package cl.duoc.app.service;

import java.util.List;

import cl.duoc.app.model.Pelicula;

public interface IPeliculaService {
	
	void insertar(Pelicula pelicula);	
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGenero();
	
	

}
