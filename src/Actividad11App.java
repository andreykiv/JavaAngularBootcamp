import java.util.Random;

import javax.swing.JOptionPane;

/*Crea dos arrays de números con la dimensión pasada por teclado.
Uno de ellos estará rellenado con números aleatorios y el otro apuntara al array anterior,
reasigna los valores del segundo array con valores aleatorios.
Después, crea un método que tenga como parámetros, los dos arrays y devuelva uno nuevo
con la multiplicación de la posición 0 del array1 con el del array2 y así sucesivamente.
Por último, muestra el contenido de cada array.*/

public class Actividad11App {
	
	public static void multipArr(int[] arrA, int[] arrB) {
		int [] finalArr = new int[arrA.length];
		//asignamos valores a finalArr multiplicando los valores de arrA y arrB;
		for(int i = 0; i < finalArr.length; i++) {
			finalArr[i] = arrA[i] * arrB[i];
		}
		//mostramos valores de cada arr:
		System.out.print("Contenido arrA: ");
		for(int i = 0; i < arrA.length; i++) {
			System.out.print(arrA[i] +" ");
		}
		
		System.out.println(" ");
		System.out.print("Contenido arrB: ");
		for(int i = 0; i < arrB.length; i++) {
			System.out.print(arrB[i] +" ");
		}
		
		System.out.println(" ");
		System.out.print("Contenido finalArr: ");
		for(int i = 0; i < finalArr.length; i++) {
			System.out.print(finalArr[i] +" ");
		}

	}
	
	public static void main(String[] args) {
		String arrLengths = JOptionPane.showInputDialog("Introduce la dimensión de los arrays");
		int parsedLengthArr = Integer.parseInt(arrLengths);
		
		//num aleatorios
		Random rnd = new Random();
		
		int [] arrA = new int[parsedLengthArr];
		//asignamos random values a arrA
		for(int i = 0; i < arrA.length; i++ ) {
			int random = (int) (rnd.nextDouble() * 10 + 1);
			arrA[i] = random;
		}
		//clonamos la array, de esta forma son independientes, utilizan zonas de memoria distintas;
		int [] arrB = arrA.clone();
		
		for(int i = 0; i< arrB.length; i++) {
			int random = (int) (rnd.nextDouble() * 10 + 1);
			arrB[i] = random;
		}
		
		//invocamos el metodo creado anteriormente pasando arrays como parametro
		multipArr(arrA, arrB);
		
	}

}
