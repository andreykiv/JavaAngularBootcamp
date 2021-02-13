package models;

//clase padre
public class Empleado {
	
	//ATRIBUTOS
	protected double salarioMensual;
	
	//CONSTRUCTORES
	//por defecto
	public Empleado() {
		this.salarioMensual = 0;
	}
	//Constructor con salarioMensual y tipo de empleado como parametros
	public Empleado(double salario) {
		//al pasar el input del tipoEmpleado comprobamos si está entre los disponibles y asignamos si existe
		this.salarioMensual = salario; 
	}
	
	//GETTERS Y SETTERS
	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Empleado [salarioMensual=" + salarioMensual + "]";
	}
}



