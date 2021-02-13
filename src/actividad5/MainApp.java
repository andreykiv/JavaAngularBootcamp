package actividad5;

/*
 * @author: Myroslav Andreykiv
 */

public class MainApp {

	public static void main(String[] args) {
		//instanciamos clases Alumno y Profesor con datos aleatorios
		Alumno miAlumno = new Alumno();
		Profesor miProfe = new Profesor();
		//instanciamos clase miAula con Profesor y Alumno como parametros
		Aula miAula = new Aula(miProfe, miAlumno);
		//mostramos por pantalla el resultado (random);
		System.out.println(miAula);
	}
}
