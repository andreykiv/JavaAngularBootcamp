import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*Crea una base de datos de 10 artículos para controlar el
stock de productos de una tienda por medio de un diccionario
de datos articulo precio El usuario podrá añadir, por medio
de interfaz visual artículos nuevos y cantidades de estos El
usario podrá consultar la información almacenada en el
diccionario referente a un articulo concreto e incluso listar toda
la información en la terminal del programa*/

public class Actividad3App {
	
	static Scanner scan = new Scanner(System.in);
	
	//declaramos un metodo que recoje que es lo quiere hacer el user
	public static int queOpcion() {
		System.out.println("Selecciona una de las siguientes opciones: "
				+ "\n1. Listar todos los productos "
				+ "\n2. Consultar la cantidad de un producto "
				+ "\n3. Añadir nuevo producto "
				+ "\n4. Modificar la cantidad del producto");
		int option = scan.nextInt();
		return option;
	}
	//declaramos el metodo que coge las variables stock y opcion como parametros
	public static void operacionStock(Hashtable<String, Integer> stock, int opcion) {
		//segun la opcion elegida del user realizamos una accion u otra
		switch(opcion) {
		case 1:
			System.out.println("ARTICULO : CANTIDAD");
			//iteramos por cada clave : valor del hashtable y lo mostramos al user
			 for (String key : stock.keySet()) {
				    System.out.println(key + ": " + stock.get(key));
			 }
			break;
		case 2:		
			String producto = JOptionPane.showInputDialog("Introduce el nombre del producto que deseas consultar").toLowerCase();
			//si clave existe en el hashtable mostrar su valor
			if(stock.containsKey(producto)) {
				System.out.println("Cantidad de " + producto + ": " + stock.get(producto)); 
			} else {
				//si no existe mostrar que no existe
				System.out.println("Producto introducido no existe en el stock");
			}
			break;
		case 3:
			String nuevoProducto = JOptionPane.showInputDialog("Introduce el nombre del producto que deseas añadir").toLowerCase();
			String cantidadProducto = JOptionPane.showInputDialog("Indica la cantidad del nuevo producto");
			int parsedCantidadProducto = Integer.parseInt(cantidadProducto);
			//guardamos nueva clave: valor en hashtable
			stock.put(nuevoProducto, parsedCantidadProducto);
			break;
		case 4:
			String productoAmodificar= JOptionPane.showInputDialog("Introduce el nombre del producto para modificar su cantidad").toLowerCase();
			//no continuar si no existe la clave 
			if(!stock.containsKey(productoAmodificar)) {
				System.out.println("Producto introducido no existe en el stock");
				break;
			}
			
			String cantidadProductoAmod = JOptionPane.showInputDialog("Indica la cantidad del nuevo producto");
			int parsedCantProductoAmod = Integer.parseInt(cantidadProductoAmod);
			//si la clave existe se modifica su valor añadiendo otro valor con la misma clave
			stock.put(productoAmodificar, parsedCantProductoAmod);
			System.out.println("Cantidad del producto modificada");
			break;
		}
	}
	
	public static void main(String[] args) {
			//creamos hashtable con siguiente formato: {articulo: cantidad, articulo: cantidad}
			Hashtable<String, Integer> stock = new Hashtable<String, Integer>();
			
			//stock inicial
			stock.put("clavo", 123);
			stock.put("martillo", 5);
			stock.put("destornillador", 7);
			stock.put("llave", 2);
			stock.put("broca", 25);
			stock.put("escuadra", 11);
			stock.put("calibre", 15);
			stock.put("tenaza", 7);
			stock.put("nivel", 25);
			stock.put("alicates", 17);
			
			int siContinuar = 1;
			//salir del bucle si el user no elige opción 1
			do {
				operacionStock(stock, queOpcion());
				System.out.println("\n1.Continuar con el programa \n2.Salir del programa");
				siContinuar = scan.nextInt();
			} while(siContinuar == 1);
	}
}
