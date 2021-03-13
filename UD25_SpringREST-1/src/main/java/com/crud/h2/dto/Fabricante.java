package com.crud.h2.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



// TODO: Auto-generated Javadoc
/**
 * The Class Fabricante.
 */
@Entity
@Table(name="fabricantes")//en caso que la tabla sea diferente
public class Fabricante  {
 
	/** The codigo. */
	//Atributos de entidad fabricante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	/** The nombre. */
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	
    /** The articulo. */
    @OneToMany
    @JoinColumn(name="id")
    private List<Articulo> articulo;
	
	//Constructores
	
	/**
	 * Instantiates a new fabricante.
	 */
	public Fabricante() {
	
	}

	/**
	 * Instantiates a new fabricante.
	 *
	 * @param codigo the codigo
	 * @param nombre the nombre
	 */
	public Fabricante(Long id, String nombre) {
		//super();
		this.id = id;
		this.nombre = nombre;
	}
	//GETTERS Y SETTERS
	
	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
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
	 * Gets the articulo.
	 *
	 * @return the articulo
	 */
	
	//lo que hace es para el bucle de referenciarse uno a otro, hace falta implementarlo en una de las dos entidades relacionadas.
	@JsonIgnore
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "Articulo")
	public List<Articulo> getArticulo() {
		return articulo;
	}

	/**
	 * Sets the articulo.
	 *
	 * @param articulo the new articulo
	 */
	public void setArticulo(List<Articulo> articulo) {
		this.articulo = articulo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + "]";
	}
}
