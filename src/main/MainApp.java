package main;

import display.Screen;
import models.Bike;
import models.Coche;
import models.Conductor;
import models.Licencia;
import models.Titular;
import models.Truck;
import models.Vehiculo;

import java.util.ArrayList;
import java.util.InputMismatchException;
/*Volem fer un software per un taller de vehicles, que en aquest moment té motos i cotxes. Els cotxes sempre tindran quatre rodes i les motos dues.*/
import java.util.Scanner;

/**
 * @author: Myroslav Andreykiv
 **/
//Ens demanen crear un metode Main que realitzi els següents passos:
public class MainApp {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// Crear coche amb les dades anteriors
		try {
			//creamos un array donde pasaremos los Vehiculos y Pesonas creadas
			ArrayList personasYVehiculos = new ArrayList<>();
	
			boolean exit = false;
			
			do {//dos menus separats, un per crear usuaris i un altre per crear vehicles
				System.out.println("Elige entre las opciones disponibles: "
						+ "\n1. Crear Vehiculo "
						+ "\n2. Crear Persona "
						+ "\n3. Salir");
				
				int option = sc.nextInt();
				if(option == 1) {
					personasYVehiculos.add(Screen.crearVehiculo());
				} else if(option == 2) {
					personasYVehiculos.add(Screen.crearPersona());
				} else if(option == 3) {
					exit = true;
				}
				
				//mostramos cantidad de personas y vehiculos que se crean
				for(Object a : personasYVehiculos) {
					if(a instanceof Bike) {
						System.out.println(a.toString());
					}
					if(a instanceof Coche) {
						System.out.println(a.toString());
					}
					if(a instanceof Truck) {
						System.out.println(a.toString());
					}
					if(a instanceof Titular) {
						System.out.println(a.toString());
					}
					if(a instanceof Conductor) {
						System.out.println(a.toString());
					}
				}
				
			} while(exit != true);
			
			System.out.println("Programa terminado");
			
		} catch(InputMismatchException e) {
			System.out.println("Valor introducido no es un valor numerico, intenta de nuevo");
		}
	}
}
