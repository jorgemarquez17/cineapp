package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context1.xml");
		
		context.close();
		

	}

}
