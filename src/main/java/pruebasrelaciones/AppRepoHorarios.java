package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.model.Horario;
import cl.duoc.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
		
		List<Horario> list = repo.findAll();
		
		for(Horario h :list)
			System.out.println("Listado de Horarios: "+h);
		
		
		context.close();

	}

}
