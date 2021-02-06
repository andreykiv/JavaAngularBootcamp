import java.util.Random;

import javax.swing.JOptionPane;

/* Crea un array de números de un tamaño pasado por teclado, el array contendrá
números aleatorios entre 1 y 300 y mostrará aquellos números que acaben en un dígito que
nosotros le indiquemos por teclado (debes controlar que se introduce un numero correcto),
estos deben guardarse en un nuevo array.
Por ejemplo, en un array de 10 posiciones le indiquemos mostrar los números acabados en 5,
podría salir 155, 25, etc.*/

public class Actividad12App {

	public static void main(String[] args) {
		try {
			
			String lengthArr = JOptionPane.showInputDialog("Introduce el tamaño del array que deseas crear");
			int parsedLengthArr = Integer.parseInt(lengthArr);
			
			String endWith;
			int parsedEndWith;
			//controlamos que se introduzca un numero correcto
			do {
				endWith = JOptionPane.showInputDialog("Introduce el dígito con el que quieres que acaben los números (tiene que ser menor que 300)");
				parsedEndWith = Integer.parseInt(endWith);
			} while(parsedEndWith > 300);
	
			//creamos arr con length obtenido del user
			int [] myArr = new int[parsedLengthArr];
			
			//creamos objeto Random
			Random rnd = new Random();
			
			for(int i = 0; i < myArr.length; i++ ) {
				do {
					//num aleatorios de 1 al 300
					int random = (int) (rnd.nextDouble() * 300 + 1);
					//convertimos a string el random para poder compararlo con lo que nos da el user
					String randomStr = Integer.toString(random);
					//si el string acaba con el string introducido por el user, el valor es válido
					if(randomStr.endsWith(endWith)) {
						//añadimos al arr si pasa la condicion
						myArr[i] = random;
					}
					//hacer mientras valor del index es igual a lo que tenemos por defecto al crear la arr (0)
				} while(myArr[i] == 0);
				
			}
			
			//utilizamos forEach para mostrar todos los valores de la array
			for(int num : myArr) {
				System.out.print(num + " ");
			}
			
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
		}
	}

}
