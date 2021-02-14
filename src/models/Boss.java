package models;
//clase hija de Empleado
public class Boss extends Empleado{
	//CONSTANTES
	private final double BONIFICACION = 1.5;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioBrutoMensual;
	private double salarioNetoMensual;
	private double salarioBrutoAnual;
	private double salarioNetoAnual;
	
	//CONSTRUCTORES
	
	//por defecto
	public Boss() {
		this.salarioBrutoMensual = this.salarioMensual * BONIFICACION;
		this.salarioNetoMensual = this.salarioBrutoMensual * 0.68;
	}
	
	//constructor pasando dos parametros
	public Boss(double salarioMensual) {
		super(salarioMensual);
		//ajustamos el SalarioMensualReal segun el tipo de empleado
		this.salarioBrutoMensual = this.salarioMensual * BONIFICACION;
		//asignamos el salarioNeto haciendo la retención
		this.salarioNetoMensual = this.salarioBrutoMensual * 0.68;
		//calculamos salarios anuales
		this.salarioBrutoAnual = this.salarioBrutoMensual * 12;
		this.salarioNetoAnual = this.salarioNetoMensual * 12;
		//mostramos el aviso si el salario no es el adecuado para manager
		esAdecuado();
	}
	
	//METODOS
	//validamos si el salario resultante está entre los dados rangos 
	public void esAdecuado() {
		if(this.salarioBrutoMensual < 8000) {
			System.out.println("El salario del Boss es inferior a 8000€, tienes que incrementarlo. ");
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

	public double getSalarioBrutoAnual() {
		return salarioBrutoAnual;
	}

	public void setSalarioBrutoAnual(double salarioBrutoAnual) {
		this.salarioBrutoAnual = salarioBrutoAnual;
	}

	public double getSalarioNetoAnual() {
		return salarioNetoAnual;
	}

	public void setSalarioNetoAnual(double salarioNetoAnual) {
		this.salarioNetoAnual = salarioNetoAnual;
	}

	@Override
	public String toString() {
		return "Boss [BONIFICACION=" + BONIFICACION + ", salarioBrutoMensual=" + salarioBrutoMensual
				+ ", salarioNetoMensual=" + salarioNetoMensual + ", salarioBrutoAnual=" + salarioBrutoAnual
				+ ", salarioNetoAnual=" + salarioNetoAnual + "]";
	}
	
	
	
}
