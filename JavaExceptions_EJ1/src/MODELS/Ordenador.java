package MODELS;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ordenador {
	//definimos clase Random
	Random rnd = new Random();
	
	//CONSTANTE
	private final int randomDEFAULT = rnd.nextInt(500);
	
	//ATRIBUTOS
	private int numRandom;
	
	//CONSTRUCTORES
	
	//default
	public Ordenador(){
		this.numRandom = randomDEFAULT;
		adivinaLo(this.numRandom);
	}
	
	public int introducirNum() {
		//obtenemos num del usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Adivina un número entre 0 y 500");
		int numIntroducido = sc.nextInt();
		//devolvemos numIntroducido
		return numIntroducido;
	}
	
	public void adivinaLo(int randomNum) {
		int numIntentos = 0;
		boolean adivinado = false;
		do {
			try {
				int numIntroducido = introducirNum();
				
				if(numIntroducido == randomNum) {
					System.out.println("Has adivinado el numero! Enhorabuena!");
					System.out.println("Número intentos: "+ numIntentos);
					adivinado = true;
				} else if(numIntroducido > randomNum){
					System.out.println("El número introducido es mayor, intenta de nuevo");
					numIntentos++;
				} else {
					System.out.println("El número introducido es menor, intenta de nuevo");
					numIntentos++;
				}
			} catch(InputMismatchException e) {
				System.out.println("El carácter introducido no es un número");
				numIntentos++;
			}
		} while(adivinado != true);
	}

}
