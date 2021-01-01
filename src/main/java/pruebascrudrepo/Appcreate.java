package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class Appcreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Noticia noticia = new Noticia();
		noticia.setTitulo("Joker");
		noticia.setDetalle("La Pelicula mas esperada llega en diciembre de este año");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		
		repo.save(noticia);
		
		context.close();

	}

}
