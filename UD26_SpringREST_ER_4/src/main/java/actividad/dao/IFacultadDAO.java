package actividad.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Facultad;
/**
 * @author Myroslav Andreykiv
 *
 */
public interface IFacultadDAO extends JpaRepository<Facultad, Integer>{
	
}
