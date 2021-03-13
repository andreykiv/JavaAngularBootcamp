package actividad2.service;

import java.util.List;

import actividad2.dto.Empleado;

public interface IEmpleadoService {
	//Metodos del CRUD
	public List<Empleado> listarEmpleados(); //Listar All 

	public Empleado guardarEmpleado(Empleado empleado);	//Guarda un Empleado CREATE

	public Empleado empleadoXDNI(String dni); //Leer datos de un Empleado READ

	public Empleado actualizarEmpleado(Empleado empleado); //Actualiza datos del Empleado UPDATE

	public void eliminarEmpleado(String dni);// Elimina el Empleado DELETE
}
