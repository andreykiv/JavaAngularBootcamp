package models;

/**
 * @author: Myroslav Andreykiv
 **/
//Clase que no tiene ninguna relacion padre-hijo (atributo de Persona)
public class Licencia {
	//ATRIBUTOS
	private String id;
	private String tipo;
	private String nombreCompleto;
	private String fechaCaducidad;
	
	//CONSTRUCTORES
	//por defecto
	public Licencia() {
		this.id= "";
		this.tipo= "";
		this.nombreCompleto="";
		this.fechaCaducidad="";
	}
	
	//con todos los atributos
	public Licencia(String id, String tipo, String nombreCompleto, String fechaCaducidad) {
		this.id= id;
		this.tipo= tipo;
		this.nombreCompleto=nombreCompleto;
		this.fechaCaducidad=fechaCaducidad;
	}
	//GETTERS Y SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
}
