package actividad.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Cajeros;
/**
 * @author Myroslav Andreykiv
 *
 */
public interface ICajerosDAO extends JpaRepository<Cajeros, Integer>{
	
}
