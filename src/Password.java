
/*Haz una clase llamada Password que siga las siguientes condiciones:
• Que tenga los atributos longitud y contraseña . Por defecto, la longitud será de 8.
• Los constructores serán los siguiente:
- Un constructor por defecto.
- Un constructor con la longitud que nosotros le pasemos. Generara una
contraseña aleatoria con esa longitud.*/
import java.util.Random;

public class Password {
	Random rnd = new Random();
	
	private int longitud;
	private String contraseña;
	
	//definimos constructor por defecto con atributo longitud igual a 8;
	public Password() {
		this.longitud = 8;
		this.contraseña = "";
	}
	//constructor con parametro longitud que usamos para devolver una contraseña
	public Password(int longitud) {
		this.longitud = longitud;
		String pass = "";
		for(int i = 0; i < longitud; i++) {
			pass+= rnd.nextInt(10);
		}
		//asignamos la contraseña al pass obtenido
		this.contraseña = pass;
	}
}
