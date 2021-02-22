package cl.duoc.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.app.model.Horario;
import cl.duoc.app.repository.HorariosRepository; 


@Service
public class HorarioServiceJPA implements IHorarioServices{
	
	@Autowired
	private HorariosRepository horariosRepo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {

		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
		
		
	}

	

}
