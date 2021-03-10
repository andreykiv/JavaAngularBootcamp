package com.crud.h2.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class Empleado.
 */
@Entity
@Table(name="empleados")//en caso que la tabala sea diferente
public class Empleado {

	/** The id. */
	//Atributos de entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	/** The nombre. */
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	
	/** The trabajo. */
	private String trabajo;
	
	/** The salario. */
	private Integer salario;
	
	//Constructores
	
	/**
	 * Instantiates a new empleado.
	 */
	public Empleado() {
	}

	/**
	 * Instantiates a new empleado.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param trabajo the trabajo
	 */
	public Empleado(Long id, String nombre, String trabajo) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		this.salario = asignarSalario(trabajo);
	}
	
	//GETTERS Y SETTERS

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the trabajo.
	 *
	 * @return the trabajo
	 */
	public String getTrabajo() {
		return trabajo;
	}

	/**
	 * Sets the trabajo.
	 *
	 * @param trabajo the new trabajo
	 */
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	/**
	 * Gets the salario.
	 *
	 * @return the asignarSalario(trabajo)
	 */
	public Integer getSalario() {
		return asignarSalario(trabajo);
	}
	
	/**
	 * Sets the salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	//metodo impresión de datos por consola
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}
	
	//METODOS
	
	public int asignarSalario(String trabajo) {
		switch(trabajo) {
		case "Software Developer":
			salario = 2500;
			break;
		case "Accountant":
			salario = 2000;
			break;
		case "CEO":
			salario = 4000;
			break;
		case "Customer Service Agent":
			salario = 1500;
			break;
		case "Business developer":
			salario = 2100;
			break;
		default:
			salario = 900;
		}
		return salario;
	}
	
}
