package models;

public class Employee extends Empleado {
	//CONSTANTES
	private final double DEDUCCION = 0.85;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioMensualReal;
	
	//CONSTRUCTORES
	
	//por defecto
	public Employee() {
		this.salarioMensualReal = this.salarioMensual * DEDUCCION;
	}

	//GETTERS Y SETTERS
	public double getSalarioFinal() {
		return salarioMensualReal;
	}
}
