package cl.duoc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.app.model.Detalle;
import cl.duoc.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {
	
	@Autowired
	private DetallesRepository detallesRepo;

	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
		
	}

	
}
