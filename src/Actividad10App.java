import java.util.Scanner;

import javax.swing.JOptionPane;

/*Realiza una aplicación que nos pida un número de ventas a introducir, después nos
pedirá tantas ventas por teclado como número de ventas se hayan indicado. Al final
mostrara la suma de todas las ventas. Piensa que es lo que se repite y lo que no.*/
public class Actividad10App {

	public static void main(String[] args) {
		//obtenemos el número de ventas que desea realizar el user
		String numVentas = JOptionPane.showInputDialog("Introduce el número de ventas que deseas realizar:");
		//convertimos el string a number
		int parsedVentas = Integer.parseInt(numVentas);
		//mostramos cuantas ventas ha de introducir el user
		System.out.println("Has de introducir " + parsedVentas + " ventas.");
		
		Scanner myObj = new Scanner(System.in);
		//creamos la variable ventasTotales
		int ventasTotales = 0;
		
		//creamos un bucle hasta que la i iguale el número introducido por el user 
		for(int i = 1; i <= parsedVentas; i++) {
			System.out.println("Venta " + i + " :");
			//obtenemos el valor de la venta introducido por el user y lo sumamos a ventasTotales
			ventasTotales += myObj.nextInt();
		}
		System.out.println("La suma de todas las ventas introducidas es de: " + ventasTotales);
	}
}
