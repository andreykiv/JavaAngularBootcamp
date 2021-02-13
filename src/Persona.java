/*Haz una clase llamada Persona que siga las siguientes condiciones:
• Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. No
queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el
más adecuado, también su tipo. Si quieres añadir algún atributo puedes hacerlo.
• Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0
números, cadena vacía para String, etc.). Sexo sera hombre por defecto, usa una
constante para ello.
• Se implantaran varios constructores:
o Un constructor por defecto.
o Un constructor con el nombre, edad y sexo, el resto por defecto.
o Un constructor con todos los atributos como parámetro.
*/
public class Persona {
	//definimos una constante para el sexo "H";
	private static final String DEFAULTSEX = "H";
	
	private String nombre;
	
	private int edad;
	
	private String DNI;
	
	private String sexo;
	
	private int peso;
	
	private int altura;

	//contstructor por defecto
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.DNI = "123456789";
		this.sexo = DEFAULTSEX;
		this.peso = 0;
		this.altura = 0;
	}
	
	//constructor con el nombre, edad y sexo con el resto por defecto
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.DNI = "123456789";
		this.peso = 0;
		this.altura = 0;
	}
	
	//Un constructor con todos los atributos como parámetro.
	public Persona(String nombre, int edad, String sexo, int peso, int altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = "123456789";
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
}
