package main;

import display.Screen;
import models.Bike;
import models.Coche;
import models.Licencia;
import models.Titular;
import models.Truck;
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
			//creamos licencia
			Licencia licenciaTitular = new Licencia("123456ID", "B", "Sebastian Vettel", "22/03/2024");
			//has de crear l'usuari (tipus Titular) amb totes les dades ja emplenades.
			//pasamos la licencia creada como uno de los atributos
			Titular newTitular = new Titular("Sebastian", "Vettel", "09/12/1982", licenciaTitular, true, true);
			
			Screen.empiezaPrograma(newTitular);
		} catch(InputMismatchException e) {
			System.out.println("Valor introducido no es un valor numerico, intenta de nuevo");
		}
	}
}
