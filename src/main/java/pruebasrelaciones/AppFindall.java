package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Pelicula;
import cl.duoc.app.repository.PeliculaRepository;

public class AppFindall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		//Recuperar todas las entidades de tipo pelicula
		PeliculaRepository repo = context.getBean("peliculaRepository", PeliculaRepository.class);
		List<Pelicula> list =repo.findAll();
		
		for(Pelicula peli : list)
		{
			System.out.println("Listado de peliculas: "+peli);
		}
		
		context.close();

	}

}
