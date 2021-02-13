package models;

public class Empleado {
	//ATRIBUTOS
	protected double salarioMensual;
	
	//CONSTRUCTORES
	//por defecto
	public Empleado() {
		this.salarioMensual = 0;
	}
	
	//GETTERS Y SETTERS
	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(int salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Empleado [salarioMensual=" + salarioMensual + "]";
	}
	
}




