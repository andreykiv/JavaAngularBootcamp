package actividad5;

import java.util.Random;

/*
 * @author: Myroslav Andreykiv
 */

public abstract class Persona {
	//clase random
	Random rnd = new Random();
	//ATRIBUTOS
	protected String nombre;
	protected int edad;
	protected char sexo;
	//CONSTANTE NOMBRES
	final protected String[] arrayNombres = {"Juan", "José", "Ana", "Maria", "Lorena", "Pablo"};
	
	//METODOS DECLARADOS PERO NO INICIALIZADOS
	public abstract boolean esAusente();
	public abstract int declaraEdad();
	
	//METODO DECLARADO
	//escogemos el nombre del array de nombres declarado previamente
	public void declaraNombre() {
		int myRnd = rnd.nextInt(6);
		this.nombre = arrayNombres[myRnd];
	}
	//declaramos el sexo utilizando el random boolean
	public void declaraSexo() {
		boolean myBool = rnd.nextBoolean();
		if(myBool) {
			this.sexo = 'H';
		} else {
			this.sexo = 'M';
		}
	}
	
	//CONSTRUCTORES
	//constructor por defecto
	public Persona() {
		declaraNombre();
		this.edad = declaraEdad();
		declaraSexo();
	}
	//constructor con todos los parametros
	public Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	//SETTERS Y GETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
}
