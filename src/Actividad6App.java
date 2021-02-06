import javax.swing.JOptionPane;

/* Crea una aplicación que nos cuente el número de cifras de un número entero positivo
(hay que controlarlo) pedido por teclado. Crea un método que realice esta acción, pasando
el número por parámetro, devolverá el número de cifras.*/

public class Actividad6App {
	
	public static int cuantasCif(int param) {
		//pasamos int to string para saber length y con el metodo length otra vez a int
		int lengthParam = Integer.toString(param).length();
		return lengthParam;
	}
	
	public static void main(String[] args) {
		try {
			
			String input = JOptionPane.showInputDialog("Introduce un número: ");
			int parsedInput = Integer.parseInt(input);
			
			System.out.println("El número introducido tiene " + cuantasCif(parsedInput) + " cifras.");
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
		}
	}
}
