package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Iterable<Noticia> it = repo.findAll();
		for(Noticia noti : it) {
			System.out.println("Listado de noticias: "+noti);
		}
		context.close();

	}

}
