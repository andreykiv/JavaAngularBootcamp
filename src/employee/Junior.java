package employee;

import models.Employee;
//subclase de la clase Employee
public class Junior extends Employee {
	//CONSTANTE
	private final double REDUCCION_DEF = 0.85;
	
	

	//ATRIBUTOS
	private double reduccion;
	private double salarioBrutoMensual;
	private double salarioNetoMensual;
	private double salarioNetoAnual;
	private double salarioBrutoAnual;
	//CONSTRUCTORES
	//por defecto
	public Junior() {
		this.reduccion = REDUCCION_DEF;
		this.salarioBrutoMensual = 0;
	}
	//con parametro de sueldo
	public Junior(double salario) {
		super(salario);
		this.salarioBrutoMensual = this.salarioMensualReal * REDUCCION_DEF;
		//asignamos el salarioNeto haciendo la retención
		this.salarioNetoMensual = this.salarioBrutoMensual * 0.98;
		//calculamos salarios anuales
		this.salarioBrutoAnual = this.salarioBrutoMensual * 12;
		this.salarioNetoAnual = this.salarioNetoMensual * 12;
		//mostramos aviso si el salario no está entre el rango adecuado
		esAdecuado();
	}
	
	//METODOS
	//comprobamos que el salario es adecuado
	public void esAdecuado() {
		if(this.salarioBrutoMensual > 1600) {
			System.out.println("El salario del Junior es superior a 1600€, tienes que reducirlo.");
		} else if( this.salarioBrutoMensual < 900) {
			System.out.println("El salario del Junior es inferior a 900€, tienes que aumentarlo.");
		}
	}
	
	//GETTERS Y SETTERS
	public double getSalarioBrutoMensual() {
		return salarioBrutoMensual;
	}
	public void setSalarioBrutoMensual(double salarioBrutoMensual) {
		this.salarioBrutoMensual = salarioBrutoMensual;
	}
	public double getSalarioNetoMensual() {
		return salarioNetoMensual;
	}
	public void setSalarioNetoMensual(double salarioNetoMensual) {
		this.salarioNetoMensual = salarioNetoMensual;
	}
	public double getSalarioNetoAnual() {
		return salarioNetoAnual;
	}
	public void setSalarioNetoAnual(double salarioNetoAnual) {
		this.salarioNetoAnual = salarioNetoAnual;
	}
	public double getSalarioBrutoAnual() {
		return salarioBrutoAnual;
	}
	public void setSalarioBrutoAnual(double salarioBrutoAnual) {
		this.salarioBrutoAnual = salarioBrutoAnual;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Junior [REDUCCION_DEF=" + REDUCCION_DEF + ", reduccion=" + reduccion + ", salarioBrutoMensual="
				+ salarioBrutoMensual + ", salarioNetoMensual=" + salarioNetoMensual + ", salarioNetoAnual="
				+ salarioNetoAnual + ", salarioBrutoAnual=" + salarioBrutoAnual + "]";
	}
	
	
	
	
}

