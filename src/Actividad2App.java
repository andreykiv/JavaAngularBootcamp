import javax.swing.JOptionPane;

/*2) Crea una aplicación que nos genere una cantidad de números enteros aleatorios que
nosotros le pasaremos por teclado. Crea un método donde pasamos como parámetros entre
que números queremos que los genere, podemos pedirlas por teclado antes de generar los
números. Este método devolverá un número entero aleatorio. Muestra estos números por
pantalla.*/

public class Actividad2App {

	//creamos un método donde pasamos como parametros el rango de numeros aleatorios
	public static int rangoNumAleatorios(int startAt, int endAt) {
		int valorEntero = (int) Math.floor(Math.random()*(endAt-startAt+1)+startAt); 
		//devolovemos el numero aleatorio del rango proporcionado
		return valorEntero;
	}
	
	public static void main(String[] args) {
		//pedir al user la cantidad de num aleatorios a generar
		String cuantosNum = JOptionPane.showInputDialog("Introduce la cantidad de números aleatorios a generar");
		int parsedStr = Integer.parseInt(cuantosNum);
		
		String initNum = JOptionPane.showInputDialog("Introduce el numero inicial del rango");
		int parsedInitNum = Integer.parseInt(initNum);
		String endNum = JOptionPane.showInputDialog("Introduce el numero final del rango");
		int parsedEndNum = Integer.parseInt(endNum);
		
		//definimos arr de length igual al numero que obtenemos del user
		int myArr[] = new int[parsedStr];
		// asignamos el valor random generado en el metodo rangoNumAleatorios al index de myArr
		for(int i = 0; i < myArr.length; i++) {
			myArr[i] = rangoNumAleatorios(parsedInitNum, parsedEndNum);
		}
		//mostramos cada valor del arr utilizando el index
		for(int i = 0; i< myArr.length; i++) {
			System.out.print(myArr[i] + " ");
		}
	}

}
