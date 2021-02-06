import javax.swing.JOptionPane;

/*Crea una aplicación que nos pida un número por teclado y con un método se lo pasamos
por parámetro para que nos indique si es o no un número primo, debe devolver true si es
primo sino false.
Un número primo es aquel solo puede dividirse entre 1 y si mismo. Por ejemplo: 25 no es
primo, ya que 25 es divisible entre 5, sin embargo, 17 si es primo.*/

public class Actividad3App {
	//definimos el metodo
	public static boolean isPrime(double param) {
		boolean isPrime = true;
		//bucle para ver si hay un numero entre 2 y param que se puede usar para dividir sin resto.
		if(param == 1 || param == 0 || param < 0) {
			isPrime = false;
		} else {
			for(int i = 2; i < param; i++) {
				if(param % i == 0) {
					isPrime = false;
				} 
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		String prime = JOptionPane.showInputDialog("Introduce un número: ");
		double parsedPrime = Double.parseDouble(prime);	
		//valorar si isPrime es true o false y mostrar segun el caso
		if(isPrime(parsedPrime)) {
			System.out.println("El número introducido es primo");
		} else {
			System.out.println("El número introducido no es primo");
		}
	}

}
