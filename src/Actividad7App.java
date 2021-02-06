import javax.swing.JOptionPane;
import java.text.DecimalFormat;
/*Crea un aplicación que nos convierta una cantidad de euros introducida por teclado a otra
moneda, estas pueden ser a dolares, yenes o libras. El método tendrá como parámetros, la
cantidad de euros y la moneda a pasar que sera una cadena, este no devolverá ningún valor,
mostrara un mensaje indicando el cambio (void).
El cambio de divisas son:
#0.86 libras es un 1 €
#1.28611 $ es un 1 €
#129.852 yenes es un 1 €*/

public class Actividad7App {

	public static void cambioDivisas(int euros, String nomMoneda) {
		//usamos esta clase para mostrar los ultimos dos digitos 
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		double resultado = 0;
		double libra = 0.86;
		double usad = 1.28611;
		double yen = 129.852;
		
		if(nomMoneda.equals("libras")) {
			resultado = euros * libra;
		} else if(nomMoneda.equals("usad")) {
			resultado = euros * usad;
		} else if(nomMoneda.equals("yenes")) {
			resultado = euros * yen;
		} else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intenta de nuevo");
		}
		
		JOptionPane.showMessageDialog(null, "A cambio recibirás " + df2.format(resultado) + " " + nomMoneda);
	}
	
	public static void main(String[] args) {
		String nomMoneda = JOptionPane.showInputDialog("Indica a que moneda deseas convertir los euros (libras, USAD, o yenes): ").toLowerCase();
		
		String cantidad = JOptionPane.showInputDialog("Indica la cantidad de euros a convetir: ");
		int parsedCantidad = Integer.parseInt(cantidad);
		//pasamos los parametros al metodo
		cambioDivisas(parsedCantidad, nomMoneda);
	}

}
