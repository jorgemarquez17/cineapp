package cl.duoc.app.service;


import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import cl.duoc.app.model.Banner;

@Service
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
		banner1.setTitulo("Proximamente Kong La Isla Calavera");
		banner1.setArchivo("slide1.jpg");
		
		Banner banner2 = new Banner();
		banner2.setId(2);
		banner2.setTitulo("Estreno La bella y la bestia");
		banner2.setArchivo("slide2.jpg");
		
		Banner banner3 = new Banner();
		banner3.setId(3);
		banner3.setTitulo("Este mes no te pierdas Rapidos y Furiosos 8");
		banner3.setArchivo("slide3.jpg");
		
		Banner banner4 = new Banner();
		banner4.setId(4);
		banner4.setTitulo("Estreno en Agosto - Jefe en Pañales");
		banner4.setArchivo("slide4.jpg");
		banner4.setEstatus("Inactivo");
			
		// Ejercicio: Agregar los objetos Banner a la lista
		
		lista.add(banner1);
		lista.add(banner2);
		lista.add(banner3);
		lista.add(banner4);		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		lista.add(banner);
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	public List<Banner> buscarTodos() {
		
		// Ejercicio: Implementar metodo
		return lista;
		
	}

}
