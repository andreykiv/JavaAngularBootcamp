package actividad2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad2.dto.Empleado;
import actividad2.dao.IEmpleadoDAO;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	//Utilizamos los metodos de la interface IEmpleadoDAO, es como si instaciaramos.
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	@Override
	public List<Empleado> listarEmpleados() {

		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {

		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoXDNI(String dni) {

		return iEmpleadoDAO.findById(dni).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {

		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String dni) {
		iEmpleadoDAO.deleteById(dni);
	}
}
