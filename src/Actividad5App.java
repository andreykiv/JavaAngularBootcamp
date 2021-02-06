import javax.swing.JOptionPane;

/*Crea una aplicación que nos convierta un número en base decimal a binario. Esto lo
realizara un método al que le pasaremos el numero como parámetro, devolverá un String
con el numero convertido a binario. Para convertir un numero decimal a binario, debemos
dividir entre 2 el numero y el resultado de esa división se divide entre 2 de nuevo hasta que
no se pueda dividir mas, el resto que obtengamos de cada división formara el numero
binario, de abajo a arriba.*/

public class Actividad5App {

	public static String aBinario(int param) {
		//usamos StringBuilder para poder añadir caracteres al inicio de una string
		StringBuilder binarioStr = new StringBuilder("");
		int result = param;
		
		do {
			if(result % 2 == 0) {
				//indicamos que 0 o 1 se tienen que insertar en el inicio de la string (0, "")
				binarioStr.insert(0, "0");
			}else {
				binarioStr.insert(0, "1");
			}
			result = result/2;
		} while(result > 0);
		//convertimos StringBuilder a String ya que el metodo tiene que devolver una String
		String returnStr = binarioStr.toString();
		return returnStr;
	}
	
	public static void main(String[] args) {
		try {
			
			String input = JOptionPane.showInputDialog("Introduce un número a convertir a binario");
			int parsedInput = Integer.parseInt(input);
			System.out.println("El numero introducido a binario es: " + aBinario(parsedInput));
			
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
			
		}
	}
}
