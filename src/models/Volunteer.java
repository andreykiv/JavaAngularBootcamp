package models;

public class Volunteer extends Empleado{
	//CONSTANTES

	
	//ATRIBUTOS
	private double ayudasGobierno;
	private double sueldo;
	
	//CONSTRUCTORES
	
	//por defecto
	public Volunteer() {
		this.sueldo = 0;
		this.ayudasGobierno = 0;
	}
	
	public Volunteer(double sueldo) {
		super();
		this.sueldo = sueldo;
		esAdecuado();
	}
	
	//comprobamos que el el campo del sueldo es el adecuado
	public void esAdecuado() {
		if(this.sueldo != 0) {
			System.out.println("El voluntario no puede cobrar un sueldo");
			this.sueldo = 0;
		}
	}
	//GETTERS Y SETTERS

	public double getAyudasGobierno() {
		return ayudasGobierno;
	}

	public void setAyudasGobierno(double ayudasGobierno) {
		this.ayudasGobierno = ayudasGobierno;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
