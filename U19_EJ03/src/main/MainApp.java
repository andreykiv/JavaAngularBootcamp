package main;

import java.awt.EventQueue;

import view.AplicacionGrafica;

public class MainApp {

	public static void main(String[] args) {
		//para controlar componentes swing 
	      EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	new AplicacionGrafica();
	            }
	        });
	}

}
