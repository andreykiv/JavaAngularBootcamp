package employee;

import models.Employee;
//subclase de la clase Employee
public class Senior extends Employee{
	//CONSTANTE
	private final double REDUCCION_DEF = 0.90;
	//ATRIBUTOS
	private double salarioBrutoMensual;
	private double salarioNetoMensual;
	private double salarioNetoAnual;
	private double salarioBrutoAnual;

	//CONSTRUCTORES
	//por defecto
	public Senior() {
		this.salarioBrutoMensual = 0;
	}
	//con parametro de sueldo
	public Senior(double salario) {
		super(salario);
		this.salarioBrutoMensual = this.salarioMensualReal * REDUCCION_DEF;
		//asignamos el salarioNeto haciendo la retención
		this.salarioNetoMensual = this.salarioBrutoMensual * 0.76;
		//calculamos salarios anuales
		this.salarioBrutoAnual = this.salarioBrutoMensual * 12;
		this.salarioNetoAnual = this.salarioNetoMensual * 12;
		//mostramos el aviso si el salario no es el adecuado para manager
		esAdecuado();
	}
	
	//METODOS
	//comprobamos que el salario es adecuado
	public void esAdecuado() {
		if(this.salarioBrutoMensual > 4000) {
			System.out.println("El salario del Senior es superior a 4000€, tienes que reducirlo.");
		} else if( this.salarioBrutoMensual < 1800) {
			System.out.println("El salario del Senior es inferior a 2700€, tienes que aumentarlo.");
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
		return "Senior [REDUCCION_DEF=" + REDUCCION_DEF + ", salarioBrutoMensual=" + salarioBrutoMensual
				+ ", salarioNetoMensual=" + salarioNetoMensual + ", salarioNetoAnual=" + salarioNetoAnual
				+ ", salarioBrutoAnual=" + salarioBrutoAnual + "]";
	}
	
	
	
}
