package cl.duoc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.app.model.Detalle;

@Repository
public interface DetallesRepository extends JpaRepository<Detalle, Integer> {

}
