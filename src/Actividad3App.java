import javax.swing.JOptionPane;

/*Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir
(recuerda usar JOptionPane).*/
public class Actividad3App {

	public static void main(String[] args) {
		String myName = JOptionPane.showInputDialog("Introduce tu nombre");
		
		System.out.println("Bienvenido " + myName);

	}

}
