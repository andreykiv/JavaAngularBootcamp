package models;

//clase hija de Empleado
public class Manager extends Empleado {
	//CONSTANTES
	private final double BONIFICACION = 1.1;
	
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	private double salarioMensualReal;
	
	//CONSTRUCTORES
	//por defecto asignando el salarioMensualReal al resultado de salarioMensual * Bonificacion
	public Manager() {
		this.salarioMensualReal = 0;
	}
	//constructor pasando dos parametros
	public Manager(double salarioMensual) {
		super(salarioMensual);
		//ajustamos el SalarioMensualReal segun el tipo de empleado
		this.salarioMensualReal = this.salarioMensual * BONIFICACION;
		//mostramos el aviso si el salario no es el adecuado para manager
		esAdecuado();
	}
	
	//METODOS
	//validamos si el salario resultante está entre los dados rangos 
	public void esAdecuado() {
		if(this.salarioMensualReal < 3000) {
			System.out.println("El salario del Manager es inferior a 3000€, tienes que incrementarlo. ");
		} else if( this.salarioMensualReal > 5000) {
			System.out.println("El salario del Manager es superio a 5000€, tienes que reducirlo. ");
		}
	}
	
	//GETTERS Y SETTERS

	public double getSalarioMensualReal() {
		return salarioMensualReal;
	}
	public void setSalarioMensualReal(double salarioMensualReal) {
		this.salarioMensualReal = salarioMensualReal;
	}
	
		
}
