package models;

//clase hija de Empleado
public class Manager extends Empleado {
	//CONSTANTES
	private final double BONIFICACION = 1.1;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioBrutoMensual;
	private double salarioNetoAnual;
	private double salarioNetoMensual;
	private double salarioBrutoAnual;
	
	//CONSTRUCTORES
	//por defecto asignando el salarioMensualReal al resultado de salarioMensual * Bonificacion
	public Manager() {
		this.salarioBrutoMensual = 0;
	}
	//constructor pasando dos parametros
	public Manager(double salarioMensual) {
		super(salarioMensual);
		//ajustamos el SalarioMensualReal segun el tipo de empleado
		this.salarioBrutoMensual = this.salarioMensual * BONIFICACION;
		//asignamos el salarioNeto haciendo la retención
		this.salarioNetoMensual = this.salarioBrutoMensual * 0.74;
		//calculamos salarios anuales
		this.salarioBrutoAnual = this.salarioBrutoMensual * 12;
		this.salarioNetoAnual = this.salarioNetoMensual * 12;
		//mostramos el aviso si el salario no es el adecuado para manager
		esAdecuado();
	}
	
	//METODOS
	//validamos si el salario resultante está entre los dados rangos 
	public void esAdecuado() {
		if(this.salarioBrutoMensual < 3000) {
			System.out.println("El salario del Manager es inferior a 3000€, tienes que incrementarlo. ");
		} else if( this.salarioBrutoMensual > 5000) {
			System.out.println("El salario del Manager es superio a 5000€, tienes que reducirlo. ");
		}
	}
	
	
	//GETTERS Y SETTERS
	public double getSalarioBrutoMensual() {
		return salarioBrutoMensual;
	}
	public void setSalarioBrutoMensual(double salarioBrutoMensual) {
		this.salarioBrutoMensual = salarioBrutoMensual;
	}
	public double getSalarioNetoAnual() {
		return salarioNetoAnual;
	}
	public void setSalarioNetoAnual(double salarioNetoAnual) {
		this.salarioNetoAnual = salarioNetoAnual;
	}
	public double getSalarioNetoMensual() {
		return salarioNetoMensual;
	}
	public void setSalarioNetoMensual(double salarioNetoMensual) {
		this.salarioNetoMensual = salarioNetoMensual;
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
		return "Manager [BONIFICACION=" + BONIFICACION + ", salarioBrutoMensual=" + salarioBrutoMensual
				+ ", salarioNetoAnual=" + salarioNetoAnual + ", salarioNetoMensual=" + salarioNetoMensual
				+ ", salarioBrutoAnual=" + salarioBrutoAnual + "]";
	}
	
	

	
		
}
