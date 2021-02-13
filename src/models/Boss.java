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
	
	//constructor pasando dos parametros
	public Boss(double salarioMensual) {
		super(salarioMensual);
		//ajustamos el SalarioMensualReal segun el tipo de empleado
		this.salarioMensualReal = this.salarioMensual * BONIFICACION;
		//mostramos el aviso si el salario no es el adecuado para manager
		esAdecuado();
	}
	
	//METODOS
	//validamos si el salario resultante está entre los dados rangos 
	public void esAdecuado() {
		if(this.salarioMensualReal < 8000) {
			System.out.println("El salario del Boss es inferior a 8000€, tienes que incrementarlo. ");
		}
	}

	//GETTERS Y SETTERS
	public double getSalarioFinal() {
		return salarioMensualReal;
	}
}
