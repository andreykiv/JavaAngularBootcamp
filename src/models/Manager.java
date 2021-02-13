package models;

import java.text.DecimalFormat;
//clase hija de Empleado
public class Manager extends Empleado {
	//CONSTANTES
	private final double BONIFICACION = 1.1;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioMensualReal;
	
	//CONSTRUCTORES
	
	//por defecto
	public Manager() {
		this.salarioMensualReal = this.salarioMensual * BONIFICACION;
	}

	//GETTERS Y SETTERS
	public double getSalarioFinal() {
		return salarioMensualReal;
	}
		
}
