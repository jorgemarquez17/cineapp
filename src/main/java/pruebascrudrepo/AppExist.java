package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.duoc.app.repository.NoticiasRepository;

public class AppExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int idNoticia =1;
		System.out.println("Existe la noticia ?"+ repo.existsById(2));
		context.close();

	}

}
