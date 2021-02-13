package models;

public class Employee extends Empleado {
	//CONSTANTES
	private final double DEDUCCION = 0.85;
	//tipos de empleado
	protected final String[] TIPOSEMPLEADOS_DEF = {"junior", "mid", "senior"};
	//ATRIBUTOS
	//salario mensual + bonificaciones/deducciones
	protected double salarioMensualReal;
	
	//CONSTRUCTORES
	
	//por defecto
	public Employee() {
		this.salarioMensualReal = this.salarioMensual * DEDUCCION;
	}
	
	//constructor pasando salario como parametro
	public Employee(double salario) {
		super(salario);
		//ajustamos el SalarioMensualReal segun el tipo de empleado
		this.salarioMensualReal = this.salarioMensual * DEDUCCION;
		//mostramos el aviso si el salario no es el adecuado para manager
	}

	//METODOS

	//GETTERS Y SETTERS
	public double getSalarioMensualReal() {
		return salarioMensualReal;
	}
}
