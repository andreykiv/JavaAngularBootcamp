import javax.swing.JOptionPane;

/* Crea una aplicación que nos calcule el factorial de un número pedido por teclado, lo
realizara mediante un método al que le pasamos el número como parámetro. Para calcular
el factorial, se multiplica los números anteriores hasta llegar a uno. Por ejemplo, si
introducimos un 5, realizara esta operación 5*4*3*2*1=120.*/

public class Actividad4App {
	//declaramos el metodo
	public static double factorial(double param) {
		int result = 1;
		//iteramos por cada valor de i asignado al input del user
		for(double i = param; i >= 1; i--) {
			//donde se hace la magia
			result*=i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			String userInput = JOptionPane.showInputDialog("Introduce el número factorial del que quieres calcular");
			//transformamos el input al double
			double parsedInput = Double.parseDouble(userInput);
			//invocamos el metodo declarado previamente
			System.out.println(factorial(parsedInput));
		}catch(NumberFormatException e) {
			//si el input del user no es number lo mostramos
			System.out.println("Tiene que ser un número, intenta de nuevo");
		}
		
	}

}
