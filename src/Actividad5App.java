import javax.swing.JOptionPane;

/*Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es, también
debemos indicarlo.
*/
public class Actividad5App {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Introduce un número");
		int parsedInput = Integer.parseInt(input);
		
		if(parsedInput % 2 ==0) {
			System.out.println("El valor introducido es divisible por 2");
		} else {
			System.out.println("El valor introducido no es divisible por 2");
		}
	}

}
