package pruebasrelaciones;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Pelicula;
import cl.duoc.app.repository.PeliculaRepository;

public class AppGetHorariosPelicula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		
		PeliculaRepository repo = context.getBean("peliculaRepository", PeliculaRepository.class);
		Optional <Pelicula> optional =repo.findById(7);
		
		System.out.println("numero de horarios registratdo para la pelicula es: "+optional.get().getHorarios().size());
		
		context.close();
	}

}
