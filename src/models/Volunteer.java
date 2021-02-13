package models;

public class Volunteer extends Empleado{
	//CONSTANTES
	private final double DEDUCCION = 0;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioMensualReal;
	
	//CONSTRUCTORES
	
	//por defecto
	public Volunteer() {
		this.salarioMensualReal = this.salarioMensual * DEDUCCION;
	}

	//GETTERS Y SETTERS
	public double getSalarioFinal() {
		return salarioMensualReal;
	}
}
