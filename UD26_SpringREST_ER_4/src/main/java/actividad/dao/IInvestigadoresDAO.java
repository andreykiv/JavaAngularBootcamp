package actividad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad.dto.Investigadores;

/**
 * @author Myroslav Andreykiv
 *
 */

public interface IInvestigadoresDAO extends JpaRepository<Investigadores, String>{

}
