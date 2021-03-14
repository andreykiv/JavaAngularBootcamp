package actividad1.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import actividad1.dto.*;
/**
 * @author Myroslav Andreykiv
 *
 */
public interface IPiezaDAO extends JpaRepository<Pieza, Integer>{
	
}
