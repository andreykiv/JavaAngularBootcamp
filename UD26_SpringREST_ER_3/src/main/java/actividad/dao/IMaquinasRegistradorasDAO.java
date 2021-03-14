package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.MaquinasRegistradoras;

/**
 * @author Myroslav Andreykiv
 *
 */

public interface IMaquinasRegistradorasDAO extends JpaRepository<MaquinasRegistradoras, Integer>{

}
