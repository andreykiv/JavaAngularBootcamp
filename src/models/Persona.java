package models;

/**
 * @author: Myroslav Andreykiv
 **/
//superclase
public abstract class Persona {
	//ATRIBUTOS
	protected String nombre;
	protected String apellido;
	protected String fechaNacimiento;
	protected Licencia licencia;
	
	//CONSTRUCTORES
	//por defecto
	public Persona() {
		this.nombre = "";
		this.apellido = "";
		this.fechaNacimiento = "";
		//invocamos constructor por defecto de la licencia
		this.licencia = new Licencia();
	}
	//con cuatro atributos
	public Persona(String nombre, String apellido, String fechaNacimiento, Licencia licencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia;
	}
	
	//GETTERS Y SETTERS
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Licencia getLicencia() {
		return licencia;
	}
	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + "]";
	}
	
	
}
