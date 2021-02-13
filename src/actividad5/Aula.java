package actividad5;

/*
 * @author: Myroslav Andreykiv
 */

import java.util.Random;

/*El aula debe tener un identificador numérico, el número máximo de estudiantes y
para que esta destinada (matemáticas, filosofía o física). Piensa que más atributos
necesita.*/

public class Aula {
	//clase random
	Random rnd = new Random();
	//CONSTANTES
	//constantes aula de materias posibles
	private final String[] AULA_DE_ARRAY = {"matemáticas", "filosofia", "física"};
	
	//ATRIBUTOS
	private int identificadorNum;
	private int capacidad;
	private String aulaDe;
	private boolean seDaClase;
	
	//METODOS
	public void queAula() {
		int myRnd = rnd.nextInt(2);
		this.aulaDe = AULA_DE_ARRAY[myRnd];
	}
	//asignamos una capacidad random al aula con el limite de 40 alumnos
	public void queCapacidad() {
		int myRnd = rnd.nextInt(40)+6;
		this.capacidad = myRnd;
	}
	//el identificador de aula seria de 100 hasta 125
	public void queIdentificador() {
		int myRnd = rnd.nextInt(100)+25;
		this.identificadorNum = myRnd;
	}
	
	public Alumno[] generamosAlumnos(Alumno alumno) {
		Alumno[] alumnos = new Alumno[capacidad];
		//generamos una array de alumnos que sea igual al tamaño de la capacidad de aula
		for(int i = 0; i < capacidad; i++) {
			alumnos[i] = new Alumno();
		}
		//devolvemos un array de alumnos
		return alumnos;
	}
	
	//para comprobar si hay profesor y si lo que imparte y el tipo de aula coinciden
	public boolean siHayProfe(Profesor profesor) {
		boolean hayClase = false;
		//comprobamos que el profesor esté presente
		if(!profesor.esAusente()) {
			//comprobamos que el profesor imparte la misma signatura de la clase
			if(profesor.getQueMateria().equals(this.aulaDe)) {
				System.out.println("Clase disponible: " + this.aulaDe + " ");
				System.out.println("Nombre del profesor: " + profesor.getNombre());
				System.out.println("Profesor imparte: " + profesor.getQueMateria());
				System.out.println("Número aula: " + getIdentificadorNum());
				hayClase = true;
			} else {
				System.out.println("No se da clase! no hay aulas!");
				System.out.println("Clase disponible: " + this.aulaDe);
				System.out.println("Profesor imparte: " + profesor.getQueMateria());
			}
		} else {
			System.out.println("EL profe está ausente");
		}
		return hayClase;
	}
	
	//CONSTRUCTORES
	//por defecto
	public Aula() {
		this.identificadorNum = 0;
		this.capacidad = 0;
		this.aulaDe = "";
		this.seDaClase = true;
	}
	//con Objeto Profesor como parametro
	public Aula(Profesor profesor, Alumno alumno) {
		this.identificadorNum = 0;
		queCapacidad();
		queAula();
		queIdentificador();
		//ejecutamos el metodo definido previamente que nos devuelve true o false
		if(siHayProfe(profesor)) {
			Alumno misAlumnos[] = generamosAlumnos(alumno);
			
			//recorremos la array para obtener la info que nos interesa
			int asistenciaClase = 0;
			for(Alumno miAlumno : misAlumnos) {
				if(miAlumno.esAusente()) {
					asistenciaClase++;
				};
			}
			int alumnasAprobadas = 0;
			int alumnosAprobados = 0;
			//si se cumple la condicion que la asistencia es mayor a 50%;
			if(this.capacidad * 0.5 < asistenciaClase) {
				for(Alumno miAlumno: misAlumnos) {
					//alumnos que han asistido y el sexo es H (valor de char en ascii)
					if(!miAlumno.esAusente() && miAlumno.getSexo() == 72) {
						if(miAlumno.getCalificacion() > 5) {
							alumnosAprobados++;
						}
					//alumnos que han asistido y el sexo es M (valor de char en ascii)
					} else if(!miAlumno.esAusente() && miAlumno.getSexo() == 77) {
						if(miAlumno.getCalificacion() > 5) {
							alumnasAprobadas++;
						}
					}
				}
				System.out.println("Hay clase!!!");
				System.out.println("Total alumnos que han venido a clase: " + asistenciaClase);
				System.out.println("Capacidad clase: " + getCapacidad());
				System.out.println("Numero total de Alumnas Aprobadas: " + alumnasAprobadas);
				System.out.println("Numero total de Alumnos Aprobadas: " + alumnosAprobados);
			} else {
				System.out.println("No hay clase porque la asistencia de los alumnos es menor a 50%");
				System.out.println("Capacidad clase: " + getCapacidad());
				System.out.println("Total alumnos que han asistido: " + asistenciaClase);
			}
			
		}
	}
	
	//GETTERS Y SETTERS
	
	public int getIdentificadorNum() {
		return identificadorNum;
	}
	public void setIdentificadorNum(int identificadorNum) {
		this.identificadorNum = identificadorNum;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getAulaDe() {
		return aulaDe;
	}
	public void setAulaDe(String aulaDe) {
		this.aulaDe = aulaDe;
	}
	public boolean isSeDaClase() {
		return seDaClase;
	}
	public void setSeDaClase(boolean seDaClase) {
		this.seDaClase = seDaClase;
	}
}
