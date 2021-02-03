import javax.swing.JOptionPane;

/*11) Crea una aplicación que nos pida un día de la semana y que nos diga si es un día laboral
o no. Usa un switch para ello*/

public class Actividad11App {
	
	public static void main(String[] args) {
	
		String dia = JOptionPane.showInputDialog("Introduce un día de la semana: ");
		//convertimos el input a lowercase
		String diaToLowerCase = dia.toLowerCase();
		
		switch(diaToLowerCase) {
			case "lunes":
				System.out.println("Es un día laboral");
				break;
			case "martes":
				System.out.println("Es un día laboral");
				break;
			case "miércoles":
				System.out.println("Es un día laboral");
				break;
			case "jueves":
				System.out.println("Es un día laboral");
				break;
			case "viernes":
				System.out.println("Es un día laboral");
				break;
			case "sábado":
				System.out.println("No es un día laboral");
				break;
			case "domingo":
				System.out.println("No es un día laboral");
				break;
			default:
				System.out.println("No has introducido un dia correcto.");
		}
	}

}
