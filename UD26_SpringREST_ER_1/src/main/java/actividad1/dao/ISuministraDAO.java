package actividad1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad1.dto.Suministra;


/**
 * @author Myroslav Andreykiv
 *
 */
public interface ISuministraDAO extends JpaRepository<Suministra, Integer>{
	
}
