package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Empleado;

// TODO: Auto-generated Javadoc
/**
 * The Interface IEmpleadoService.
 */
public interface IEmpleadoService {

	/**
	 * Listar empleados.
	 *
	 * @return the list
	 */
	//Metodos del CRUD
	public List<Empleado> listarEmpleados(); //Listar All 
	
	/**
	 * Guardar empleado.
	 *
	 * @param Empleado the empleado
	 * @return the empleado
	 */
	public Empleado guardarEmpleado(Empleado Empleado);	//Guarda un Empleado CREATE
	
	/**
	 * Empleado XID.
	 *
	 * @param id the id
	 * @return the empleado
	 */
	public Empleado EmpleadoXID(Long id); //Leer datos de un Empleado READ
	
	/**
	 * Listar empleado nombre.
	 *
	 * @param nombre the nombre
	 * @return the list
	 */
	public List<Empleado> listarEmpleadoNombre(String nombre);//Listar Empleados por campo nombre
	
	/**
	 * Listar empleado trabajo.
	 *
	 * @param trabajo the trabajo
	 * @return the list
	 */
	public List<Empleado> listarEmpleadoTrabajo(String trabajo);//Listar Empleados por campo trabajo
	
	/**
	 * Actualizar empleado.
	 *
	 * @param Empleado the empleado
	 * @return the empleado
	 */
	public Empleado actualizarEmpleado(Empleado Empleado); //Actualiza datos del Empleado UPDATE
	
	/**
	 * Eliminar empleado.
	 *
	 * @param id the id
	 */
	public void eliminarEmpleado(Long id);// Elimina el Empleado DELETE
	
	
}
