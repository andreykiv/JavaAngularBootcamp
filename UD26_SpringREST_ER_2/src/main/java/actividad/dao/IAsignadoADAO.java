package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.AsignadoA;


/**
 * @author Myroslav Andreykiv
 *
 */
public interface IAsignadoADAO extends JpaRepository<AsignadoA, Integer>{
	
}
