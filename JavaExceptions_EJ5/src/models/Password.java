/*Haz una clase llamada Password que siga las siguientes condiciones:
• Que tenga los atributos longitud y contraseña . Por defecto, la longitud sera de 8.
• Los constructores serán los siguiente:
✓ Un constructor por defecto.
✓ Un constructor con la longitud que nosotros le pasemos. Generara una
contraseña aleatoria con esa longitud.
Los métodos que implementa serán:
• esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe
tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
• generarPassword(): genera la contraseña del objeto con la longitud que
tenga.
• Método get para contraseña y longitud.
• Método set para longitud.*/

package models;

import java.util.Random;

/***
 * @author: Myroslav Andreykiv
 **/

public class Password {
	//definimos clase random
	Random rnd = new Random();
	//ATRIBUTOS
	private int longitud;
	private String contraseña;
	
	//CONSTANTES
	private final int DEFAULT_LONGITUD = 8;
	
	//CONSTRUCTORES
	//constructor por defecto
	public Password() {
		this.longitud = DEFAULT_LONGITUD;
		this.contraseña ="";
	}
	//constructor con dos parametros
	public Password(int longitud) {
		this.longitud = longitud;
		this.contraseña = contraseña;
		generarPassword();
	}
	
	//METODOS
	//se genera el password segun la longitud que pasa el usuario
	public void generarPassword(){
		//definimos la variable password que vamos a popular con el bucle
		String password = "";
		
		do {
			//escogemos tres rangos dentro de valores de ascii
			//48-57 - numeros de 0 a 9
			int randomNum = rnd.nextInt(9)+48;
			//65-90 letras A-Z
			int randomLetraMayu = rnd.nextInt(25)+65;
			//97-122 letras a-z minusculas
			int randomLetraMin = rnd.nextInt(25)+97;
			//creamos un array con las 3 posiciones de num aleatorios anteriores
			int [] numAleatorios = {randomNum, randomLetraMayu, randomLetraMin};
			//escogemos una posicion random del array
			int randomIndx = rnd.nextInt(3);
			//asignamos el int a la posicion random del array;
			int randomAscii = numAleatorios[randomIndx];
			//obtenemos el valor de ascii haciendo uso del casting y lo pasamos a string
			String getChar = String.valueOf((char) randomAscii);
			//añadimos a la variable de tipo String definida previamente
			password+=getChar;
		} while (password.length() != longitud);

		//asignamos el valor de la contraseña a password generado
		this.contraseña = password;
	}
	
	// comprobamos si es fuerte el password
	public boolean esFuerte() {
		//para ser fuerte tiene que tener mas de 2 mayusculas, mas de 1 minuscula y mas de 5 numeros
		int numMayusculas = 0;
		int numMinusculas = 0;
		int valoresNumericos = 0;
		
		boolean esFuerte = false;
		//pasamos el string al array de chars
		char [] myChars = this.contraseña.toCharArray(); 
		//comprobamos si cada char pertenece a un rango o a otro
		for(char ch : myChars) {
			if(ch >= 65 && ch <= 90) {
				numMayusculas++;
			} else if(ch >= 97 && ch <= 122) {
				numMinusculas++;
			} else {
				valoresNumericos++;
			}
		}
		//comprobamos si pasa la condicion para ser fuerte
		if(numMayusculas > 2 && numMinusculas > 1 && valoresNumericos > 5) {
			esFuerte = true;
		}
		//devolvemos valor true o false
		return esFuerte;
	}
	
	//GETTERS Y SETTERS
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contraseña;
	}

	
	
}
