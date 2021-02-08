import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*Combina los métodos generados en las actividades 2 y 3
creando una aplicación que gestione ventas y control de stock en
una misma interfaz. Utiliza para ello las estructuras de datos que
creas conveniente.*/


public class Actividad4App {
	
	static Scanner scan = new Scanner(System.in);
	
	//declaramos un metodo que recoje que es lo quiere hacer el user
	public static int queOpcion() {
		System.out.println("Selecciona que quieres hacer: "
				+ "\n1. Listar todos los productos "
				+ "\n2. Consultar detalles de un producto "
				+ "\n3. Añadir nuevo producto "
				+ "\n4. Modificar un producto (IVA, precio o cantidad) "
				+ "\n5. Vender un producto");
		
		int option = scan.nextInt();
		return option;
	}
	
	//generamos un stock aleatorio
	public static Hashtable stock() {
		//stock del producto
		Hashtable<String, ArrayList> stock = new Hashtable<String, ArrayList>();

		//random num
		Random rnd = new Random();

		//populamos el Hashtable (stock) con 10 claves(nombreArticulo): valor[precio, cantidad, IVA] 
		for(int i = 0; i < 10; i++) {
			ArrayList descriptionProduct = new ArrayList<>();
			for(int z = 0; z < 1; z++) {
				int precioRandom = (int) (rnd.nextDouble() * 100);
				int cantidadRandom = (int) (rnd.nextDouble() * 100);
				boolean IVA = rnd.nextBoolean();
				double tipoIVA = 0.00;
				if(IVA) {
					tipoIVA = 1.21;
				} else {
					tipoIVA = 1.04;
				}
				descriptionProduct.add(precioRandom);
				descriptionProduct.add(cantidadRandom);
				descriptionProduct.add(tipoIVA);
			}
			//populamos el stock con la descripcion de cada articulo y el nombre del articulo
			stock.put("articulo" + i, descriptionProduct);
		}	
		
		return stock;
	}
	
	public static void operacionStock(Hashtable<String, ArrayList> stock, int opcion) {
		//segun la opcion elegida del user realizamos una accion u otra
		switch(opcion) {
		case 1:
			System.out.println("ARTICULO : DESCRIPCIÓN(precio, cantidad, IVA)");
			//iteramos por cada clave : valor del hashtable y lo mostramos al user
			 for (String key : stock.keySet()) {
				    System.out.println(key + ": " + stock.get(key));
			 }
			break;
		case 2:		
			String producto = JOptionPane.showInputDialog("Introduce el nombre del producto que deseas consultar").toLowerCase();
			//si clave existe en el hashtable mostrar su valor
			if(stock.containsKey(producto)) {
				System.out.println("Nombre producto: " + producto);
				System.out.println("Precio unitario: " + stock.get(producto).get(0) + "€");
				System.out.println("Cantidad del producto: " + stock.get(producto).get(1) +" unidades");
				System.out.println("IVA del producto: " + stock.get(producto).get(2) +"%");
			} else {
				//si no existe mostrar que no existe
				System.out.println("Producto introducido no existe en el stock");
			}
			break;
		case 3:
			String nombreNuevoProducto = JOptionPane.showInputDialog("Introduce el nombre del producto que deseas añadir").toLowerCase();
			
			String cantidadNuevoProducto = JOptionPane.showInputDialog("Indica la cantidad del producto");
			int parsedCantidadProducto = Integer.parseInt(cantidadNuevoProducto);

			String precioNuevoProducto = JOptionPane.showInputDialog("Indica el precio unitario del producto (€)");
			int parsedPrecioProducto = Integer.parseInt(precioNuevoProducto);
			
			System.out.println("Elige el tipo de IVA del articulo: \n1. 21% \n2. 4%");
			int tipoIVA = scan.nextInt();
			double tipoIVAnuevoProducto = 0;
			if(tipoIVA == 1) {
				tipoIVAnuevoProducto = 1.21;
			} else if(tipoIVA == 2){
				tipoIVAnuevoProducto = 1.04;
			}
			//creamos nueva arraylist que vamos a pasar como valor
			ArrayList nuevoProductoDesc = new ArrayList<>();
			
			nuevoProductoDesc.add(parsedPrecioProducto);
			nuevoProductoDesc.add(parsedCantidadProducto);
			nuevoProductoDesc.add(tipoIVAnuevoProducto);
			// añadimos nueva clave:valor al stock
			stock.put(nombreNuevoProducto, nuevoProductoDesc);
			
			break;
		case 4:
			String productoAmodificar= JOptionPane.showInputDialog("Introduce el nombre del producto que deseas modificar").toLowerCase();
			//no continuar si no existe la clave 
			if(!stock.containsKey(productoAmodificar)) {
				System.out.println("Producto introducido no existe en el stock");
				break;
			}
			
			System.out.println("Elige que quieres modificar: \n1. Precio \n2. Cantidad \n3. IVA");
			int opcionAmodificar = scan.nextInt();
			//creamos una arraylist para pasarla como valor al Hashtable stock
			ArrayList infoModificada = new ArrayList<>();
			
			if(opcionAmodificar == 1) {
				String precioModificado = JOptionPane.showInputDialog("Indica el nuevo precio unitario del producto (€)");
				double parsedprecioModificado = Double.parseDouble(precioModificado);
				//definimos los nuevos valores dejando los valores existentes excepto el que hemos modificado
				infoModificada.add(parsedprecioModificado);
				infoModificada.add(stock.get(productoAmodificar).get(1));
				infoModificada.add(stock.get(productoAmodificar).get(2));
				
			} else if(opcionAmodificar == 2) {
				String cantidadModificada = JOptionPane.showInputDialog("Indica la nueva cantidad del producto (uds.)");
				double parsedcantidadModificada = Double.parseDouble(cantidadModificada);
				
				infoModificada.add(stock.get(productoAmodificar).get(0));
				infoModificada.add(parsedcantidadModificada);
				infoModificada.add(stock.get(productoAmodificar).get(2));
				
			} else if(opcionAmodificar == 3) {
				System.out.println("Elige el tipo de IVA del articulo: \n1. 21% \n2. 4%");
				int IVAmodificado = scan.nextInt();
				double tipoIVAmodificado = 0;
				if(IVAmodificado == 1) {
					tipoIVAmodificado = 1.21;
				} else if(IVAmodificado == 2){
					tipoIVAmodificado = 1.04;
				}
				
				infoModificada.add(stock.get(productoAmodificar).get(0));
				infoModificada.add(stock.get(productoAmodificar).get(1));
				infoModificada.add(tipoIVAmodificado);
				
			} else {
				System.out.println("Tienes que elegir la opción disponible, intenta de nuevo");
				System.exit(1);
			}

			//sobreesribimos la clave:valor existente en el stock 
			stock.put(productoAmodificar, infoModificada);
			System.out.println("Información modificada satisfactoriamente");
			break;
		case 5:
			//si vendemos un producto la cantidad de este producto tiene que disminuir en el stock
			String venderProducto = JOptionPane.showInputDialog("Introduce el nombre del producto que deseas vender").toLowerCase();
			ArrayList nuevaCantidadProducto = new ArrayList<>();
			//no continuar si no existe la clave 
			if(!stock.containsKey(venderProducto)) {
				System.out.println("Producto introducido no existe en el stock");
				break;
			}
			//mostramos la cantidad disponible en el stock en este momento al user
			int totalCantidadDisponible = (int) stock.get(venderProducto).get(1);
			System.out.println("Cantidad en el stock disponible:" + stock.get(venderProducto).get(1));
			
			String cantidadAvender = JOptionPane.showInputDialog("Indica la cantidad del producto a vender");
			int parsedCantidadAvender = Integer.parseInt(cantidadAvender);
			//si la cantidad a introducida a vender es mayor a la cantidad existente mostrar el aviso y salir
			if(parsedCantidadAvender > totalCantidadDisponible) {
				System.out.println("La cantidad introducida es mayor a la disponible en el stock, tienes que reiniciar el programa");
				System.exit(1);
			}
			int cantidadDespuesDeLaVenta = totalCantidadDisponible - parsedCantidadAvender;
			
			
			nuevaCantidadProducto.add(stock.get(venderProducto).get(0));
			nuevaCantidadProducto.add(cantidadDespuesDeLaVenta);
			nuevaCantidadProducto.add(stock.get(venderProducto).get(2));
			//asignamos nueva cantidad al producto que hemos vendido, dejando IVA y precio tal como estaban
			stock.put(venderProducto, nuevaCantidadProducto);
			System.out.println("Cantidad vendida");
		}
	}

	public static void main(String[] args) {
		//trabajamos con una referencia para que no se genere nuevo stock al llamar la función mas abajo
		Hashtable newStock = stock();
		
		int siContinuar = 1;
		//salir del bucle si el user no elige opción 1
		do {
			operacionStock(newStock, queOpcion());
			System.out.println("\n1. Continuar con el programa \n2. Salir del programa");
			siContinuar = scan.nextInt();
		} while(siContinuar == 1);
	}

}
