package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.deleteAllInBatch();
		
		context.close();
	}

}
