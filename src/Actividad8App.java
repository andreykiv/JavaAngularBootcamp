import java.util.Scanner;

/*Crea un array de 10 posiciones de números con valores pedidos por teclado. Muestra por
consola el indice y el valor al que corresponde. Haz dos métodos, uno para rellenar valores y
otro para mostrar*/

public class Actividad8App {

	public static int[] rellenarValores() {
		int [] myArr = new int[10];
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < myArr.length; i++) {
			System.out.println("Introduce un número");
			int integer = input.nextInt();
			//asignamos el valor del index al input obtenido del user
			myArr[i] =  integer;
		}
		//cerramos el scanner para que no nos muestre el aviso 
		input.close();
		//retornamos el array
		return myArr;
	}
	
	public static void mostrarValores(int[] myArr) {
		for(int i = 0; i < myArr.length; i++) {
			System.out.println("Valor index "+i+ ": "+ myArr[i]);
		}
	}
	
	public static void main(String[] args) {
		//invocamos el metodo mostrarValores pasando como parametro el array retornado del metodo rellenarValores
		mostrarValores(rellenarValores());
	}

}
