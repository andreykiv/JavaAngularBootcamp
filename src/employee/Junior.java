package employee;

import models.Employee;
//subclase de la clase Employee
public class Junior extends Employee {
	//CONSTANTE
	private final double REDUCCION_DEF = 0.85;
	
	private double reduccion;
	private double salarioMensualFinal;
	//CONSTRUCTORES
	//por defecto
	public Junior() {
		this.reduccion = REDUCCION_DEF;
		this.salarioMensualFinal = 0;
	}
	//con parametro de sueldo
	public Junior(double salario) {
		super(salario);
		this.salarioMensualFinal = this.salarioMensualReal * REDUCCION_DEF;
		//mostramos aviso si el salario no está entre el rango adecuado
		esAdecuado();
	}
	
	//METODOS
	//comprobamos que el salario es adecuado
	public void esAdecuado() {
		if(this.salarioMensualFinal > 1600) {
			System.out.println("El salario del Junior es superior a 1600€, tienes que reducirlo.");
		} else if( this.salarioMensualFinal < 900) {
			System.out.println("El salario del Junior es inferior a 900€, tienes que aumentarlo.");
		}
	}
	

	//GETTERS Y SETTERS
	public double getReduccion() {
		return reduccion;
	}

	public void setReduccion(double reduccion) {
		this.reduccion = reduccion;
	}

	public double getSalarioMensualFinal() {
		return salarioMensualFinal;
	}

	public void setSalarioMensualFinal(double salarioMensualFinal) {
		this.salarioMensualFinal = salarioMensualFinal;
	}
	
	
}

