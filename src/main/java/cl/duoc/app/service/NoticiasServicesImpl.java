package cl.duoc.app.service;

import org.springframework.stereotype.Service;

import cl.duoc.app.model.Noticia;

@Service
public class NoticiasServicesImpl implements INoticiasService {
	
	public  NoticiasServicesImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServicesImpl");
	}

	@Override
	public void guardar(Noticia noticia) {
		// TODO Auto-generated method stub
		
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
		
	}

}
