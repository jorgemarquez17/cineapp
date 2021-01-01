package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		Optional<Noticia> optional = repo.findById(1);
		
		if(optional.isPresent()) {
			Noticia noticia = optional.get();
			System.out.println("valor de la variable noticia "+ noticia);
			noticia.setEstatus("Activa");
			repo.save(noticia);
		}
		context.close();
		

	}

}
