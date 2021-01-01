package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Optional<Noticia> noticia =repo.findById(2);
		System.out.println("valor de objeto noticia: "+noticia.get());
		context.close();

	}

}
