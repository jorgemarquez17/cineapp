package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Noticia;
import cl.duoc.app.repository.NoticiasRepository;

public class AppKeywordOr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> lista = null;
		try {
			lista = repo.findByEstatusOrFecha("Inactiva", format.parse("2017-09-08"));
			//lista = repo.findByEstatusAndFecha("Activa", format.parse("2017-09-08"));
			//lista = repo.findByFecha(format.parse("2020-10-11"));
			//lista = repo.findByEstatus("Activa");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Noticia noti : lista) {
			System.out.println("La noticias encontradas son: "+noti);
		}
		
		context.close();
	}

}
