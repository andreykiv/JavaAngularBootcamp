package models;

/**
 * @author: Myroslav Andreykiv
 **/

//subclase de Persona
public class Conductor extends Persona{
	//ATRIBUTOS (los mismos que en la clase Persona)
	
	//CONSTRUCTORES
	//por defecto
	public Conductor() {
	}
	//con todos los parametros de la persona;
	public Conductor(String nombre, String apellido, String fechaNacimiento, Licencia licencia) {
		super(nombre, apellido, fechaNacimiento, licencia);
	}
	
	//TOSTRING propio
	@Override
	public String toString() {
		return "Conductor [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + "]";
	}
	
}
