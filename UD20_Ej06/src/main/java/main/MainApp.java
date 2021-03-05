package main;

import java.awt.EventQueue;

import views.AplicacionGrafica;

/**
 * @author Myroslav Andreykiv
 *
 */


//Intenta escribir una aplicación gráfica que permita calcular el índice de masa
//corporal. Os recuerdo que este índice se calcula dividiendo el peso de una persona en
//kilos por el cuadrado de su altura en metros.


public class MainApp {

	public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	new AplicacionGrafica();
	            }
	        });
	}
}
