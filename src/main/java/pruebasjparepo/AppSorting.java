package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//obtener todas las entidades ordenadas por un campo
		//List<Noticia> lista = repo.findAll(Sort.by("titulo").descending());
		
		//obtener todas las entidades ordenadas por 2 campos
		List<Noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
		
		for(Noticia n : lista) {
			System.out.println("Noticias ordenadas por el titulo: "+ n);
		}
		context.close();

	}

}
