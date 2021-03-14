package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Equipos;

/**
 * @author Myroslav Andreykiv
 *
 */
public interface IEquiposDAO extends JpaRepository<Equipos, String>{
	
}
