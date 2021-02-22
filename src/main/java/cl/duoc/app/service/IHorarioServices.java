package cl.duoc.app.service;

import java.util.Date;
import java.util.List;
import cl.duoc.app.model.Horario;

public interface IHorarioServices {

	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
}
