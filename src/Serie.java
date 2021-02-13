/*Crearemos una clase llamada Serie con las siguientes características:
• Sus atributos son titulo, numero de temporadas, entregado, genero y creador.
• Por defecto, el numero de temporadas es de 3 temporadas y entregado false.
El resto de atributos serán valores por defecto según el tipo del atributo.
Los constructores que se implementaran serán:
✓ Un constructor por defecto.
✓ Un constructor con el titulo y creador. El resto por defecto.
✓ Un constructor con todos los atributos, excepto de entregado.

/*
 * 
 * @author: Myroslav Andreykiv
 */

public class Serie {
	
	//atributos
	protected String titulo;
	protected int numeroTemporadas;
	protected boolean entregado;
	protected String genero;
	protected String creador;
	

	//Un constructor por defecto
	public Serie() {
		this.titulo = "";
		this.numeroTemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	}
	
	//Un constructor con el titulo y creador. El resto por defecto.
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.numeroTemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = creador;
	}
	//constructor con todos los atributos, excepto de entregado
	public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	}

	//generamos metodos getters y setters de todos los atributos excepto de entregado.
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	
	//sobreescribimos los metodos toString
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
	}
	
	


	
	
	
	
}
