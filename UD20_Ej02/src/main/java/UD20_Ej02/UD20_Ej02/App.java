package UD20_Ej02.UD20_Ej02;

import java.awt.EventQueue;

import views.AplicacionGrafica;

public class App 
{
    public static void main( String[] args ) {
		//para controlar componentes swing 
	      EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	new AplicacionGrafica();
	            }
	        });
    }
}
