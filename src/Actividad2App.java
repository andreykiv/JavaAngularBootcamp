import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*Crea una aplicación que gestione el flujo de ventas de una caja de supermercado. 
El programa guardara la cantidades del carrito de compra dentro de una lista Mostrará por pantalla la siguiente 
informacion:
IVA aplicado 21 o 4
precio total bruto y precio mas IVA
Numero de artículos comprados
Cantidad pagada
Cambio a devolver al cliente*/

public class Actividad2App {
	
	static Scanner scan = new Scanner(System.in);
	
	public static double añadirPrecio() {
		System.out.println("Introduce el precio del articulo (€): ");
		double precioArticulo = scan.nextDouble();
		return precioArticulo;
	}
	
	public static double añadirIVA() {
		final double IVAgeneral = 1.21;
		final double IVAsuperReducido = 1.04;
		
		System.out.println("Elige el tipo de IVA del articulo: \n1. 21% \n2. 4%");
		int tipoIVA = scan.nextInt();
		
		double IVAarticulo = 0.00;
		
		if(tipoIVA == 1) {
			IVAarticulo = IVAgeneral;
		} else if(tipoIVA == 2) {
			IVAarticulo = IVAsuperReducido;
		} else {
			JOptionPane.showMessageDialog(null, "Tienes que elegir entre las dos opciones, intenta de nuevo");	
			System.exit(1);
		}
		return IVAarticulo;
	}

	public static void main(String[] args) {
		
		// [{ precio: double, IVA: double}, {}, {}] ---esctructura de la collection 
		
		//creamos lista donde vamos a guardar cada articulo
		ArrayList<Hashtable<String, Double>> listaArticulos = new ArrayList<>();
		Hashtable<String, Double> articulo = new Hashtable<>();
		
		DecimalFormat df = new DecimalFormat("#.##");
		try {
			//habrá un articulo	como mínimo 	
			articulo.put("precio", añadirPrecio());
			articulo.put("IVA", añadirIVA());
			
			listaArticulos.add(articulo);
				
			System.out.println("Elige una de las siguientes opciones: \n 1. Añadir mas productos \n 2. Imprimir factura");
			int siContinuar = scan.nextInt();
		
			do {
				//creamos hash donde pasamos precio e iva
				Hashtable<String, Double> otroArticulo = new Hashtable<>();
				//insertamos clave valor
				otroArticulo.put("precio", añadirPrecio());
				otroArticulo.put("IVA", añadirIVA());
				//añadimos el hashtable al arraylist
				listaArticulos.add(otroArticulo);
				System.out.println("Elige una de las siguientes opciones: \n 1. Añadir mas productos \n 2. Imprimir factura");
				siContinuar = scan.nextInt();
			} while(siContinuar == 1);
			
			System.out.println("Introduce la cantidad pagada por el cliente");
			double candidadPagada= scan.nextDouble();
			
			System.out.println("Factura simplificada: ");
			System.out.println("Número articulos comprados: " + listaArticulos.size());
			
			System.out.println("IVA Aplicado en cada articulo: ");
			
			//definimos la cantidad total de la compra para calcular el cambio a devolver
			double totalCompra = 0.00;
			double precioMasIVA = 0.00;
			double precioTotalBruto = 0.00;
		
			//recorremos cada hash dentro del arraylist
			for(Hashtable item: listaArticulos) {
				System.out.println("Producto: "+ item.get("precio")+"€" +" IVA: " + item.get("IVA"));
				//aplicamos el cast para obtener double y sumarlo a totalCompra
				totalCompra += (double) item.get("precio");
				precioTotalBruto += ((double) item.get("precio") / (double) item.get("IVA"));
				precioMasIVA += (double) item.get("precio");
			}
			
			System.out.println("Precio total bruto: " + df.format(precioTotalBruto) + "€");
			System.out.println("Precio mas IVA: " + precioMasIVA + "€");
			System.out.println("Cantidad pagada: " + candidadPagada + "€");
			System.out.println("Cambio a devolver al cliente: " + (candidadPagada - totalCompra) + "€");
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
		}
	}
}
