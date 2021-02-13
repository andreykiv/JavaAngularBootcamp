/*Crearemos una clase Videojuego con las siguientes características:
• Sus atributos son titulo, horas estimadas, entregado, genero y compañia.
• Por defecto, las horas estimadas serán de 10 horas y entregado false. El resto
de atributos serán valores por defecto según el tipo del atributo.
Los constructores que se implementaran serán:
✓ Un constructor por defecto.
✓ Un constructor con el titulo y horas estimadas. El resto por defecto.
✓ Un constructor con todos los atributos, excepto de entregado.
Los métodos que se implementara serán:
• Métodos get de todos los atributos, excepto de entregado.
• Métodos set de todos los atributos, excepto de entregado.
• Sobrescribe los métodos toString*/

/*
 * 
 * @author: Myroslav Andreykiv
 */

package actividad2;

public class Videojuego implements Entregable {
	
	//ATRIBUTOS
	protected String titulo;
	protected int horasEstimadas;
	protected boolean entregado;
	protected String genero;
	protected String compañia;
	
	//CONSTRUCTORES
	
	//Un constructor por defecto
	public Videojuego() {
		this.titulo = "";
		this.horasEstimadas = 10;
		this.entregado = false;
		this.genero = "";
		this.compañia = "";
	}
	
	//Un constructor con el titulo y horas estimadas. El resto por defecto.
	public Videojuego(String titulo, int horasEstimadas) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = "";
		this.compañia = "";
	}

	//Un constructor con todos los atributos, excepto de entregado.
	public Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = genero;
		this.compañia = compañia;
	}
	
	//Implementamos los metodos del Entregable (nuevo atributo? prestado)
	
	//cambia el valor del prestado a true
	public void entregar() {
		this.entregado = true;
	}
	//cambia el valor del prestado a false
	public void devolver() {
		this.entregado = false;
	}
	
	//devuelve el estado del atributo prestado
	public boolean isEntregado() {
		return entregado;
	}
	//Método compareTo (Object a) 
	public void compareTo(Object a) {
		System.out.println("Horas Videojuego: " + horasEstimadas);
		//hacemos uso del casting de los objetos
		if(a instanceof Serie) {
			System.out.println("Temporadas serie: " + ((Serie) a).getNumeroTemporadas());	
		}
	}
	
	//SETTERS Y GETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	//SOBREESCRIBIMOS EL METODO toString

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compañia=" + compañia + "]";
	}
}
