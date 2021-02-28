package main;

import java.awt.EventQueue;

import views.Calculadora;

public class MainApp {

	public static void main(String[] args) {
		//para mostrar componentes 
	      EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	new Calculadora();
	            }
	        });
	}
}
