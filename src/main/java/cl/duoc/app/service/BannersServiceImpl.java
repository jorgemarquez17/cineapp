package cl.duoc.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import cl.duoc.app.model.Banner;

public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		// Ejercicio: Crear una nueva lista enlazada
		lista = new LinkedList<Banner>();	
		
		// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)
		Banner banner1 = new Banner();
		banner1.setId(1);
		banner1.setTitulo("titulo1");
		banner1.setArchivo("");
		
		Banner banner2 = new Banner();
		banner2.setId(1);
		banner2.setTitulo("titulo2");
		banner2.setArchivo("");
		
		Banner banner3 = new Banner();
		banner3.setId(1);
		banner3.setTitulo("titulo3");
		banner3.setArchivo("");
		
		Banner banner4 = new Banner();
		banner4.setId(1);
		banner4.setTitulo("titulo4");
		banner4.setArchivo("");
			
		// Ejercicio: Agregar los objetos Banner a la lista
		
		lista.add(banner1);
		lista.add(banner2);
		lista.add(banner3);
		lista.add(banner4);
		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {
		
		// Ejercicio: Implementar metodo
		return null;
		
	}

}
