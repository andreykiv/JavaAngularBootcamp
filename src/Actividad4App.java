import javax.swing.JOptionPane;

/*Haz una aplicación que calcule el área de un circulo (pi*R2). El radio se pedirá por teclado
(recuerda pasar de String a double con Double.parseDouble). Usa la constante PI y el
método pow de Math.*/

public class Actividad4App {

	public static void main(String[] args) {
		//input del user
		String radio = JOptionPane.showInputDialog("Introduce la radio del circulo");
		//convertimos el input a double
		double radioDouble = Double.parseDouble(radio);
		//multiplicamos valor estatico PI por el input del user al cuadrado
		System.out.println("El área del cirulo es " + (Math.PI * Math.pow(radioDouble, 2)));
		
	}

}
