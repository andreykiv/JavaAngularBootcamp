import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		Random rnd = new Random();
		int longitud = 6;
		
		String pass = "";
		for(int i = 0; i < longitud; i++) {
			pass+= (int) (rnd.nextDouble() * 10);
		}

		System.out.println(pass);

	}

}
