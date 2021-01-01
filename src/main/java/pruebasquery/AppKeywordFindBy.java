package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppKeywordFindBy {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> lista = null;
		try {
			lista = repo.findByFecha(format.parse("2020-10-11"));
			//lista = repo.findByEstatus("Activa");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Entro al catch");
			e.printStackTrace();
		}
		for(Noticia noti : lista) {
			System.out.println("Entro al for: ");
			System.out.println("La noticias encontradas son: "+noti);
		}
		
		context.close();

	}

}
