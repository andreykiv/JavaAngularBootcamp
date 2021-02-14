package display;

import java.util.Scanner;

import models.Coche;

//funciones con el scanner
public class Screen {
	static Scanner sc = new Scanner(System.in);
	//Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
	public static Coche getInfoCoche() {
		
		System.out.println("Introduce la matricula del coche: ");
		String matricula = sc.nextLine();
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca del coche: ");
		String marca = sc.nextLine();
		
		System.out.println("Introduce el color del coche: ");
		String color = sc.nextLine();
		
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.nextLine();
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//Crear el cotxe amb les dades anteriors.
		Coche miCoche = new Coche(matricula, marca, color, marcaRuedasTraseras, diametroRuedasTraseras, marcaRuedasDelanteras, diametroRuedasDelanteras);
		return miCoche;
	}
	//comprobamos que la matricula esté compuesta por 4 numeros y 2 o 3 letras
	public static void comprobarMatricula(String matricula) {
		boolean correcto = false;
		//regex que incluya 4 primeros numeros y 2 o 3 letras
		String regexCondition = "[0-9]{4}[A-Za-z]{2,3}";
		do {
			if(matricula.matches(regexCondition)) {
				correcto = true;
			} else {
				System.out.println("Matricula errónea. Tiene que ser compuesta por 4 digitos y 2 o 3 letras, intenta de nuevo: ");
				matricula = sc.nextLine();
			}
		} while(correcto != true);
	}
	
	public static void comprobarDiametro(double diametro) {
		boolean correcto = false;
		do {//comprobamos si se cumplen las condiciones
			if(diametro < 0.4 || diametro > 4) {
				System.out.println("Diametro ruedas tiene que ser inferior a 4 y superior a 0.4. Intenta de nuevo: ");
				diametro = sc.nextDouble();
			} else {
				correcto = true;
			}
		} while (correcto != true);

	}
}
