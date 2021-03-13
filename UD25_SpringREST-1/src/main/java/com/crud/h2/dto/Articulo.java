package com.crud.h2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class Articulo.
 */
@Entity
@Table(name="articulos")//en caso que la tabla sea diferente

public class Articulo {
	
	/** The codigo. */
	//Atributos de entidad Articulo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	/** The nombre. */
	private String nombre;
	
	/** The precio. */
	private int precio;

	/** The fabricante. */
	@ManyToOne
	@JoinColumn(name="fabricante")
	private Fabricante fabricante;

	//Constructores
	/**
	 * Instantiates a new articulo.
	 */
	public Articulo() {

	}

	/**
	 * Instantiates a new articulo.
	 *
	 * @param codigo the codigo
	 * @param nombre the nombre
	 * @param precio the precio
	 * @param fabricante the fabricante
	 */
	public Articulo(Long id, String nombre, int precio, Fabricante fabricante) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fabricante = fabricante;
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
	public void setCodigo(Long id) {
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
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}



	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}



	/**
	 * Gets the fabricante.
	 *
	 * @return the fabricante
	 */
	public Fabricante getFabricante() {
		return fabricante;
	}



	/**
	 * Sets the fabricante.
	 *
	 * @param fabricante the new fabricante
	 */
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Articulo [id=" + id+ ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante
				+ "]";
	}

}
