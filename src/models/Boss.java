package models;
//clase hija de Empleado
public class Boss extends Empleado{
	//CONSTANTES
	private final double BONIFICACION = 1.5;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioMensualReal;
	
	//CONSTRUCTORES
	
	//por defecto
	public Boss() {
		this.salarioMensualReal = this.salarioMensual * BONIFICACION;
	}

	//GETTERS Y SETTERS
	public double getSalarioFinal() {
		return salarioMensualReal;
	}
}
