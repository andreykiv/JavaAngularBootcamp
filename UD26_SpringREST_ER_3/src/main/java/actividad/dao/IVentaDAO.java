package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Venta;


/**
 * @author Myroslav Andreykiv
 *
 */
public interface IVentaDAO extends JpaRepository<Venta, Integer>{
	
}
