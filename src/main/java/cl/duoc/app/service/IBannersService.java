package cl.duoc.app.service;

import java.util.List;
import cl.duoc.app.model.Banner;

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
