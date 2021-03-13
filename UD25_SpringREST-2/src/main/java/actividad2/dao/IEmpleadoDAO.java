package actividad2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import actividad2.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, String>{

}
