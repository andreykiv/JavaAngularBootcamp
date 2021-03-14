package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Proyecto;

/**
 * @author Myroslav Andreykiv
 *
 */
public interface IProyectoDAO extends JpaRepository<Proyecto, String>{
	
}
