import javax.swing.JOptionPane;

/*Crea un array de números donde le indicamos por teclado el tamaño del array,
rellenaremos el array con números aleatorios entre 0 y 9. Al final muestra por pantalla el
valor de cada posición y la suma de todos los valores.
Tareas a realizar: Haz un método para rellenar el array(que tenga como parámetros los
números entre los que tenga que generar) y otro para mostrar el contenido y la suma del
array.
*/

public class Actividad9App {
	
	public static int[] rellenarArr(int startAt, int endAt) {
		
		String numArr = JOptionPane.showInputDialog("Introduce el tamaño del Array que deseas crear");
		int parsedNumArr = Integer.parseInt(numArr);
		int [] myArr = new int[parsedNumArr];
		
		for(int i = 0; i < myArr.length; i++) {
			myArr[i] = (int) (Math.random() * endAt);
		}
		return myArr;
	}
	
	public static void mostrarArr(int [] myArr) {
		int suma = 0;
		for(int i = 0; i < myArr.length; i++) {
			System.out.println(i + ": " + myArr[i]);
			suma+=myArr[i];
		}
		System.out.println("La suma total de los números del array es de " + suma);
	}
	
	public static void main(String[] args) {
		mostrarArr(rellenarArr(0,10));
	}

}
