import java.util.Scanner;

/*Lee un número por teclado que pida el precio de un producto (puede tener decimales) y
calcule el precio final con IVA. El IVA sera una constante que sera del 21%
*/

public class Actividad6App {
	
	final static double IVA = 1.21;
	
	public static void main(String[] args) {
		//creamos el objeto de la clase Scanner
		Scanner myObj = new Scanner(System.in);
		//mostramos por la consola que queremos del user
		System.out.println("Introduce el precio de un producto sin IVA");
		//guardamos el valor introducido por el user
		double userInput = myObj.nextDouble();
		//mostramos el precio final del producto multiplicado por el IVA
		System.out.println("El precio del producto con IVA es de " + (IVA * userInput));
	}

}
