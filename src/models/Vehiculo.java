package models;

import java.util.ArrayList;

/**
 * @author: Myroslav Andreykiv
 **/


public abstract class Vehiculo {
	//ATRIBUTOS
	//Modifica la clase vehicle, afegeix dos camps, un camp tipus Titular per assignar-li un titular al vehicle i una llista de Persones (que seran els conductors, el titular pot ser conductor).
		protected String matricula;
		protected String marca;
		protected String color;
		protected Titular titular;
		protected ArrayList personas;

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
		
		//con cinco paramteros (milestone 3)
		public Vehiculo(String matricula, String marca, String color, Titular titular, ArrayList personas) {
			this.matricula = matricula;
			this.marca = marca;
			this.color = color;
			this.titular = titular;
			this.personas = personas;
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
		public Titular getTitular() {
			return titular;
		}
		public void setTitular(Titular titular) {
			this.titular = titular;
		}
		public ArrayList getPersonas() {
			return personas;
		}
		public void setPersonas(ArrayList personas) {
			this.personas = personas;
		}

}
