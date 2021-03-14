package actividad1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad1.dto.Proveedor;


/**
 * @author Myroslav Andreykiv
 *
 */
public interface IProveedorDAO extends JpaRepository<Proveedor, String>{
	
}
