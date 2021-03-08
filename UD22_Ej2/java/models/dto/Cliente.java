package models.dto;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import models.conexion.Conexion;

public class Cliente {
	private Integer idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer dni;
	private String fecha = Conexion.fechaFormateada();
	
	//GETTERS Y SETTERS DE CLIENTE
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
