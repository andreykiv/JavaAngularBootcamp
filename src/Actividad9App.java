/*Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3. Utiliza el bucle
que desees.*/
public class Actividad9App {

	public static void main(String[] args) {
		System.out.println("Los números divisibles entre 2 y 3 són los siguientes:");
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0 && i % 3== 0) {
				System.out.print(i + " ");
			}
		}
	}
}
