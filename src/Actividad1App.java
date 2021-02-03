/*Declara 2 variables numéricas (con el valor que desees), e indica cual es mayor de los
dos. Si son iguales indicarlo también. Ves cambiando los valores para comprobar que
funciona.*/

public class Actividad1App {
	
	public static void main(String[] args) {
		int a = 11;
		int b = 11;
		
		if(a > b) {
			System.out.println("El valor " + a + " es mayor que el valor " + b);
		} else if (a < b) {
			System.out.println("El valor " + a + " es menor que el valor " + b);
		} else {
			System.out.println("El valor " + a + " y el valor " + b + " son iguales");
		}
	}

}
