import javax.swing.JOptionPane;

/* Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá mas
la contraseña y mostrara un mensaje diciendo “Enhorabuena”. Piensa bien en la condición
de salida (3 intentos y si acierta sale, aunque le queden intentos).*/
public class Actividad12App {

	public static void main(String[] args) {	
		String pass = "mypass";
		int intentos = 0;
		boolean acierto = false;
		
		do {
			String input = JOptionPane.showInputDialog("Introduce la contraseña: ");
			if(pass.equals(input)) {
				acierto = true;
			}
			++intentos;
		} while (intentos <= 2 && acierto == false);
		
		if(acierto) {
			System.out.println("Enhorabuena! Contraseña correcta");
		} else {
			System.out.println("No hay mas intentos. Intenta más tarde.");
		}
			
			
	}

}
