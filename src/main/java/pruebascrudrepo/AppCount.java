package pruebascrudrepo;

import org.apache.naming.ContextAccessController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		long num = repo.count();
		System.out.println("Se encontraron : "+ num +" registros.");
		
		context.close();

	}

}
