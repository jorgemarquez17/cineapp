package cl.duoc.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.app.model.Pelicula;
import cl.duoc.app.repository.PeliculaRepository;

@Service
public class PeliculasServiceJPA implements IPeliculaService{
	
	@Autowired
	private PeliculaRepository peliculasRepo;

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarGenero() {
		// TODO Auto-generated method stub
		List<String> generos = new LinkedList<String>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		return generos;
	}

}
