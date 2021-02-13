package actividad5;

/*
 * @author: Myroslav Andreykiv
 */

public class Alumno extends Persona{
	//atributos alumno
	private int calificacion;
	
	
	//METODOS
	//comprobar si el alumno ha faltado a la clase
	public boolean esAusente() {
		boolean ausente = false;
		//50% de probabilidad de estar ausente
		int myInt = (int) (Math.random() * 10 + 1);
		if(myInt <= 5) {
			ausente = true;
		}
		return ausente;
	}
	
	//asignamos la edad del alumno entre margenes razonables
	public int declaraEdad() {
		//la edad de alumno puede ser entre 16 y 46 años.
		int myRnd = rnd.nextInt(30)+16;
		return myRnd;
	}
	
	//obtenemos la nota del alumno
	public void obtenerNota() {
		int randomNota = (int) (Math.random() * 10 + 1);
		this.calificacion = randomNota;
	}

	//CONSTRUCTORES
	//constructor por defecto
	public Alumno() {
		//asignamos una nota random al crear un alumno
		obtenerNota();
	}
	//constructor con un parametro
	public Alumno(int calificacion) {
		this.calificacion = calificacion;
	}
	//constructor con todos los parametros
	public Alumno(String nombre, int edad, char sexo, int calificacion) {
		super(nombre, edad, sexo);
		this.calificacion = calificacion;
	}
	
	//GETTERS Y SETTERS
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
}
