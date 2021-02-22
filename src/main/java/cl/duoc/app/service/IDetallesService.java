package cl.duoc.app.service;

import cl.duoc.app.model.Detalle;


public interface IDetallesService {

	void insertar(Detalle detalle);
	void eliminar(int idDetalle);
}
