import java.util.Random;

import javax.swing.JOptionPane;

/*Crea un array de números de un tamaño pasado por teclado, el array contendrá
números aleatorios primos entre los números deseados, por último nos indicar cual es el
mayor de todos.
Haz un método para comprobar que el número aleatorio es primo, puedes hacer todos lo
métodos que necesites.*/

public class Actividad10App {
	
	public static boolean isPrime(int num) {
		boolean isPrime = true;
		//comprobamos si hay un numero entre 2 y num que se puede usar para dividir sin resto.
		if(num == 1 || num == 0 || num < 0) {
			isPrime = false;
		} else {
			for(int i = 2; i < num; i++) {
				if(num% i == 0) {
					isPrime = false;
				} 
			}
		}
		return isPrime;
	}
	
	public static int randomNum(int startAt, int endAt) {
		int primeNum = 0;
		//random num
		Random rnd = new Random();
		int cantidadNumsRango = endAt - startAt;
		
		boolean primeFound = false;
		//hasta que no encontramos el prime invocamos el bucle
		while(primeFound != true) {
			//nextDouble para que podamos tener valores enteros del rango que nos interesa
			int random = (int) (rnd.nextDouble() * cantidadNumsRango + startAt);
			
			if(isPrime(random)) {
				primeFound = true;
				primeNum = random;
			}
		}
		return primeNum;
		
	}
	
	public static void newArr(int arrLength, int startAt, int endAt) {
		//definimos el arr con el length que nos pasa el user
		int [] myArr = new int[arrLength];
		//populamos la arr con random values invocando el metodo randomNum
		for(int i = 0; i < myArr.length; i++) {
			myArr[i] = randomNum(startAt, endAt);
		}
		
		int maxVal = 0;
		//para mostrar el max num comparamos con el anterior guardado en maxVal
		for(int i = 0; i < myArr.length; i++) {
			if(myArr[i] > maxVal) {
				maxVal = myArr[i];
			}
		}
		System.out.println("El mayor número de array de primos es " + maxVal);
	}
	
	public static void main(String[] args) {
		try {
			String lengthArr = JOptionPane.showInputDialog("Introduce el tamaño del array que deseas crear");
			int parsedLengthArr = Integer.parseInt(lengthArr);
			
			String startAt = JOptionPane.showInputDialog("Introduce el primer número del rango de números aleatorios a calcuar");
			int parsedStartAt = Integer.parseInt(startAt);
			
			String endAt = JOptionPane.showInputDialog("Introduce el último número del rango de números aleatorios a calcuar");
			int parsedEndAt = Integer.parseInt(endAt);
			
			newArr(parsedLengthArr, parsedStartAt, parsedEndAt);
			
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
		}

	}

}
