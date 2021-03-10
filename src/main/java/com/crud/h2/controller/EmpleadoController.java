package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Empleado;
import com.crud.h2.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	//listar Empleados por campo nombre
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name="nombre") String nombre) {
	    return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}
	
	//listar Empleados por campo trabajo
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoTrabajo(@PathVariable(name="trabajo") String trabajo) {
	    return empleadoServiceImpl.listarEmpleadoTrabajo(trabajo);
	}
	
	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado Empleado) {
		
		return empleadoServiceImpl.guardarEmpleado(Empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado Empleado_xid= new Empleado();
		
		Empleado_xid=empleadoServiceImpl.EmpleadoXID(id);
		
		System.out.println("Empleado XID: "+Empleado_xid);
		
		return Empleado_xid;
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoServiceImpl.EmpleadoXID(id);
		
		empleado_seleccionado.setNombre(Empleado.getNombre());
		empleado_seleccionado.setTrabajo(Empleado.getTrabajo());
		empleado_seleccionado.setSalario(Empleado.getSalario());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
	
	
}
