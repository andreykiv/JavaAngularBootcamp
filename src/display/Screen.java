package display;



/**
 * @author: Myroslav Andreykiv
 **/

import java.util.Scanner;

import models.Bike;
import models.Coche;

//funciones con el scanner
public class Screen {
	static Scanner sc = new Scanner(System.in);
	
	//Preguntar a l’usuari si vol crear un cotxe o una moto.
	public static int queOpcion() {
		//creamos un int para devolver al Main para saber que objeto creamos
		int queOpcion = 0;
		System.out.println("Indica que es lo que quieres crear: "
				+ "\n1. Coche "
				+ "\n2. Moto");
		int opcion = sc.nextInt();
		if(opcion == 1) {
			queOpcion = 1;
		} else if(opcion == 2) {
			queOpcion = 2;
		} else {
			System.out.println("Elige una de las opciones permitidas");
		}
		return queOpcion;
	}
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
		
		//Crear el cotxe amb les dades anteriors.
		Coche miCoche = new Coche(matricula, marca, color);
		
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.nextLine();
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		//comprobamos el diametro
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//asignamos las caracteristicas del coche 
		miCoche.setMarcaRuedasTraseras(marcaRuedasTraseras);
		miCoche.setMarcaRuedasDelanteras(marcaRuedasDelanteras);
		miCoche.setDiametroRuedasTraseras(diametroRuedasTraseras);
		miCoche.setDiametroRuedasDelanteras(diametroRuedasDelanteras);
	
		return miCoche;
	}
	
	public static Bike getInfoBike() {
		System.out.println("Introduce la matricula de la moto: ");
		String matricula = sc.nextLine();
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca de la moto: ");
		String marca = sc.nextLine();
		
		System.out.println("Introduce el color de la moto: ");
		String color = sc.nextLine();
		
		//Crear el cotxe amb les dades anteriors.
		Bike miBike = new Bike(matricula, marca, color);
		
		System.out.println("Introduce la marca de la rueda trasera: ");
		String marcaRuedasTraseras = sc.nextLine();
		
		System.out.println("Introduce la marca de las rueda delantera: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las rueda trasera: ");
		double diametroRuedasTraseras = sc.nextDouble();
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las rueda delantera: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		//asignamos las caracteristicas de la moto
		
		miBike.setDiametroRuedaDelantera(diametroRuedasDelanteras);
		miBike.setDiametroRuedaTrasera(diametroRuedasDelanteras);
		miBike.setMarcaRuedaDelantera(marca);
		miBike.setMarcaRuedaTrasera(marca);
		
		return miBike;
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
				System.out.println("Tiene que ser compuesta por 4 digitos y 2 o 3 letras: ");
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
