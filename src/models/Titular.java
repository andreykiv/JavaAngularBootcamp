package models;

/**
 * @author: Myroslav Andreykiv
 **/
//subclase de Persona
public class Titular extends Persona{
	//ATRIBUTOS
	private boolean seguroCoche;
	private boolean garajePropio;
	
	//CONSTRUCTORES
	//por defecto
	public Titular() {
		this.seguroCoche = false;
		this.garajePropio = false;
	}
	//con todos los parametros (6)
	public Titular(String nombre, String apellido, String fechaNacimiento, Licencia licencia, boolean seguroCoche, boolean garajePropio) {
		super(nombre, apellido, fechaNacimiento, licencia);
		this.seguroCoche = seguroCoche;
		this.garajePropio = garajePropio;
	}
	
	//GETTERS Y SETTERS
	public boolean isSeguroCoche() {
		return seguroCoche;
	}
	public void setSeguroCoche(boolean seguroCoche) {
		this.seguroCoche = seguroCoche;
	}
	public boolean isGarajePropio() {
		return garajePropio;
	}
	public void setGarajePropio(boolean garajePropio) {
		this.garajePropio = garajePropio;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Titular [seguroCoche=" + seguroCoche + ", garajePropio=" + garajePropio + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", licencia=" + licencia + "]";
	}
	
	
	
	
}
