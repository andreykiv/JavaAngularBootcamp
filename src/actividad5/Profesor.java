package actividad5;

/*
 * @author: Myroslav Andreykiv
 */

public class Profesor extends Persona {
	
	//atributos profesor
	private String queMateria;
	
	//constante materia posibles
	final private String[] MATERIAS = {"matemáticas", "filosofia", "física"};
	
	//METODOS
	//comprobamos si el profe es ausente
	public boolean esAusente() {
		boolean ausente = false;
		//20% de probabilidad de estar ausente
		int myInt = (int) (Math.random() * 10 + 1);
		if(myInt <= 2) {
			ausente = true;
		}
		return ausente;
	}
	
	//asignamos la edad del profesor entre margenes razonables
	public int declaraEdad() {
		//la edad de profesor puede ser entre 25 y 65 años.
		int myRnd = rnd.nextInt(40)+25;
		return myRnd;
	}
	
	//asignamos una materia random que imparte el profe
	public void obtenerMateria() {
		int randomIndex = (int) (Math.random() * 3);
		this.queMateria = MATERIAS[randomIndex];
	}
	
	//constructor por defecto
	public Profesor() {
		super();
		obtenerMateria();
	}
	//constructor con el parametro queMateria
	public Profesor(String queMateria) {
		super();
		this.queMateria = queMateria;
	}
	
	//constructor con todos los parametros
	public Profesor(String nombre, int edad, char sexo, String queMateria) {
		super(nombre, edad, sexo);
		this.queMateria = queMateria;
	}
	
	//GETTERS Y SETTERS
	public String getQueMateria() {
		return queMateria;
	}
	public void setQueMateria(String queMateria) {
		this.queMateria = queMateria;
	}
	
	
	
	
	
}
