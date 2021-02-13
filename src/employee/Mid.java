package employee;

import models.Employee;
//subclase de la clase Employee
public class Mid extends Employee {
	//CONSTANTE
		private final double REDUCCION_DEF = 0.90;
		
		private double reduccion;
		private double salarioMensualFinal;
		//CONSTRUCTORES
		//por defecto
		public Mid() {
			this.reduccion = REDUCCION_DEF;
			this.salarioMensualFinal = 0;
		}
		//con parametro de sueldo
		public Mid(double salario) {
			super(salario);
			this.salarioMensualFinal = this.salarioMensualReal * REDUCCION_DEF;
			//mostramos aviso si el salario no está entre el rango adecuado
			esAdecuado();
		}
		
		//METODOS
		//comprobamos que el salario es adecuado
		public void esAdecuado() {
			if(this.salarioMensualFinal > 2500) {
				System.out.println("El salario del Mid es superior a 2500€, tienes que reducirlo.");
			} else if( this.salarioMensualFinal < 1800) {
				System.out.println("El salario del Mid es inferior a 1800€, tienes que aumentarlo.");
			}
		}
		
		//GETTERS Y SETTERS
		public double getReduccion() {
			return reduccion;
		}

		public void setReduccion(double reduccion) {
			this.reduccion = reduccion;
		}

		public double getSalarioMensualFinal() {
			return salarioMensualFinal;
		}

		public void setSalarioMensualFinal(double salarioMensualFinal) {
			this.salarioMensualFinal = salarioMensualFinal;
		}
}
