package main;

import display.Screen;
import models.Bike;
import models.Coche;
import models.Vehiculo;

import java.util.InputMismatchException;
/*Volem fer un software per un taller de vehicles, que en aquest moment té motos i cotxes. Els cotxes sempre tindran quatre rodes i les motos dues.*/

/**
 * @author: Myroslav Andreykiv
 **/
//Ens demanen crear un metode Main que realitzi els següents passos:
public class MainApp {

	public static void main(String[] args) {
		// Crear coche amb les dades anteriors
		try {
			if(Screen.queOpcion() == 1) {
				Coche newCoche= Screen.getInfoCoche();
			} else if(Screen.queOpcion() == 2) {
				Bike newBike = Screen.getInfoBike();
			}
		} catch(InputMismatchException e) {
			System.out.println("Valor introducido no es un valor numerico, intenta de nuevo");
		}
		
		
	}
}
