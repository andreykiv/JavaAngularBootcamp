package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Reserva;


/**
 * @author Myroslav Andreykiv
 *
 */
public interface IReservaDAO extends JpaRepository<Reserva, Integer>{
	
}
