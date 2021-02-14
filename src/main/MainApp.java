package main;

import display.Screen;
import models.Coche;

/*Volem fer un software per un taller de vehicles, que en aquest moment té motos i cotxes. Els cotxes sempre tindran quatre rodes i les motos dues.*/

/**
 * @author: Myroslav Andreykiv
 **/
//Ens demanen crear un metode Main que realitzi els següents passos:
public class MainApp {

	public static void main(String[] args) {
		// Crear coche amb les dades anteriors
		Coche miCoche = Screen.getInfoCoche();
	}
}
