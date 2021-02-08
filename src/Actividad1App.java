/*Crea una aplicación que calcule la nota media de los
alumnos pertenecientes al curso de programación Una vez
calculada la nota media se guardara esta información en un
diccionario de datos que almacene la nota media de cada
alumno Todos estos datos se han de proporcionar por
pantalla*/

import java.text.DecimalFormat;
import java.util.Hashtable; 
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Actividad1App {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		int cantidadNotas = 0;
		int cantidadAlumnos = 0;
	
		System.out.println("Indica la cantidad de notas que quieres introducir");
		cantidadNotas = myScanner.nextInt();
		
		System.out.println("Indica la cantidad de alumnos del curso");
		cantidadAlumnos = myScanner.nextInt();
		
		//creamos diccionario donde vamos a guardar el nombre junto con la nota media de cada alumno
		Hashtable<String, Double> alumnoNotaMedia = new Hashtable<String, Double>();
		
		//importamos decimalFormat para obtener dos ultimos digitos despues de la coma
		DecimalFormat df = new DecimalFormat("#.##");
		//bucle para cada alumno
		for(int i = 0; i < cantidadAlumnos; i++) { 
			double sumaNotas = 0.00;
			String nombreAlumno = JOptionPane.showInputDialog("Introduce el nombre del alumno"); 
			for(int z = 0; z < cantidadNotas; z++) {
				String notaStr = JOptionPane.showInputDialog("Introduce la nota " + (z+1) + " del alumno: " + nombreAlumno); 
				double parsedNotaStr = Double.parseDouble(notaStr);
				sumaNotas+=parsedNotaStr;
			}
			// para mostrar dos decimales despues de la coma
			double notaMedia =  Double.valueOf(df.format(sumaNotas/cantidadNotas));
			//añadimos al diccionario creado anteriormente clave y valor 
			alumnoNotaMedia.put(nombreAlumno, notaMedia);
		}
		//cerramos Scanner para que no nos muestre el aviso
		myScanner.close();
		 //mostramos toda la info por la pantalla
		 for(String key : alumnoNotaMedia.keySet()) {
			 System.out.println("La nota media de " + key + " es de "+ alumnoNotaMedia.get(key));
		 }
	}
}
