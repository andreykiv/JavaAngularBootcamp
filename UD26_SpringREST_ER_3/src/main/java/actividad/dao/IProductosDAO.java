package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Productos;

/**
 * @author Myroslav Andreykiv
 *
 */
public interface IProductosDAO extends JpaRepository<Productos, Integer>{
	
}
