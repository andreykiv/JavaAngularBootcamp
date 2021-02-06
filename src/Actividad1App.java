import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/*) Crea una aplicación que nos calcule el área de un circulo, cuadrado o triangulo. Pediremos
que figura queremos calcular su área y según lo introducido pedirá los valores necesarios
para calcular el área. Crea un método por cada figura para calcular cada área, este devolverá
un número real. Muestra el resultado por pantalla.
Aquí te mostramos que necesita cada figura:
•
•
•
Circulo: (radio^2)*PI
Triangulo: (base * altura) / 2
Cuadrado: lado * lado
*/

public class Actividad1App {
	//metodo área circulo
	public static double circulo(double radio) {
		//Circulo: (radio^2)*PI
		double result = Math.pow(radio, 2) * Math.PI;
		return result;
	}
	
	public static double triangulo(double base, double altura) {
		//Triangulo: (base * altura) / 2
		double result = (base * altura) / 2;
		return result;
	}
	public static double cuadrado(double lado) {
		//Cuadrado: lado * lado
		double result = lado * lado;
		return result;
	}

	public static void main(String[] args) {
		//importamos classe DecimalFormat para mostrar dos decimales de output
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		String queFigura = JOptionPane.showInputDialog("Introduce la figura (cirulo, triangulo o cuadrado)");
		//transformamos el input del user a lowercase antes de valorar cada caso
		switch(queFigura.toLowerCase()) {
			case "circulo":
				try {
					String radio = JOptionPane.showInputDialog("Introduce la radio del circulo");
					double parsedRadio = Double.parseDouble(radio);
					JOptionPane.showMessageDialog(null, "El área del circulo es: " + df2.format(circulo(parsedRadio)));
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
				}break;
				
			case "triangulo":
				try {
					String base = JOptionPane.showInputDialog("Introduce la base del triangulo");
					double parsedBase = Double.parseDouble(base);
					String altura = JOptionPane.showInputDialog("Introduce la altura del triangulo");
					double parsedAltura = Double.parseDouble(altura);
					
					JOptionPane.showMessageDialog(null, "El área del triangulo es: " + df2.format(triangulo(parsedBase, parsedAltura)));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
				} break;
			case "cuadrado":
				try {
					String lado = JOptionPane.showInputDialog("Introduce el lado del cuadrado");
					double parsedLado = Double.parseDouble(lado);
					
					JOptionPane.showMessageDialog(null, "El área del cuadrado es: " + df2.format(cuadrado(parsedLado)));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Tiene que ser un número, intenta de nuevo");
				} break;
				
			default:
				JOptionPane.showMessageDialog(null, "Introduce el nombre de la figura (circulo, triangulo o cuadrado)");	
		}
	}
}
