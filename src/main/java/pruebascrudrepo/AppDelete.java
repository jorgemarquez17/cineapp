package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int idNoticia= 2;
		if(repo.existsById(idNoticia)) {
			repo.deleteById(idNoticia);
		}
		
		
		context.close();
	}

}
