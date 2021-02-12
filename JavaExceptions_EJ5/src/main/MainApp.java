/*Ahora, crea una clase clase ejecutable:
• Crea un array de Passwords con el tamaño que tu le indiques por teclado.
• Crea un bucle que cree un objeto para cada posición del array.
• Indica también por teclado la longitud de los Passwords (antes de bucle).
• Crea otro array de booleanos donde se almacene si el password del array
de Password es o no fuerte (usa el bucle anterior).
Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior). Usa
este simple formato:
contraseña1 valor_booleano1
contraseña2 valor_bololeano2*/

package main;

import models.Password;

public class MainApp {

	public static void main(String[] args) {
		//Crea un array de Passwords con el tamaño que tu le indiques por teclado.
		Password [] arrPasswords = new Password[10];
		//Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte
		boolean [] esFuerte = new boolean[arrPasswords.length];
		//Indica también por teclado la longitud de los Passwords (antes de bucle).
		int longitudPasswords = 15;
		//Crea un bucle que cree un objeto para cada posición del array
		for(int i = 0; i < arrPasswords.length; i++ ) {
			arrPasswords[i] = new Password(longitudPasswords);
			//(usa el bucle anterior)
			esFuerte[i] = arrPasswords[i].esFuerte();
			//Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior). Usa este simple formato:
			System.out.println(arrPasswords[i].getContraseña() + " " + esFuerte[i]);
		}
	}
}
