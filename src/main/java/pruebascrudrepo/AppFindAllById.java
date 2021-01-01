package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(3);
		
		Iterable<Noticia> it = repo.findAllById(ids);
		for(Noticia noti : it) {
			System.out.println("Valores de la peliculas rescatadas"+ noti);
		}
		
		context.close();

	}

}
