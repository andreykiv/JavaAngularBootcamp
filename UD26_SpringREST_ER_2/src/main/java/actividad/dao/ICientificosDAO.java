package actividad.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Cientificos;
/**
 * @author Myroslav Andreykiv
 *
 */
public interface ICientificosDAO extends JpaRepository<Cientificos, String>{
	
}
