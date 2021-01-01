package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//obtener noticias por paginacion
		//Page<Noticia> page =repo.findAll(PageRequest.of(2, 5));
		
		//obtener noticias por paginacion y ordenamiento
				Page<Noticia> page =repo.findAll(PageRequest.of(0, 10, Sort.by("titulo")));
		
		for(Noticia noti : page) {
			System.out.println("Noticias por paginacion: "+ noti);
		}
		
		
		context.close();

	}

}
