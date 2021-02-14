package models;

public abstract class Vehiculo {
	//ATRIBUTOS
		protected String matricula;
		protected String marca;
		protected String color;

		//CONSTRUCTORES
		//default
		public Vehiculo() {
			this.matricula = "";
			this.marca = "";
			this.color = "";
		}
		//con tres parametros
		public Vehiculo(String matricula, String marca, String color) {
			this.matricula = matricula;
			this.marca = marca;
			this.color = color;
		}
		
		//GETTERS Y SETTERS
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}

}
