package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Detalle;
import cl.duoc.app.repository.DetallesRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		DetallesRepository repo = context.getBean("detallesRepository",DetallesRepository.class);
		
		List<Detalle> list =null;
		list=repo.findAll();
		for(Detalle deta: list) {
			System.out.println(" Listado de detalle "+ deta);
		}
		
		context.close();

	}

}
