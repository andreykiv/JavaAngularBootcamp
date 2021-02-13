package actividad3;


/**
 * @author: Myroslav Andreykiv
 **/

public class Libro {
	//ATRIBUTOS
	protected String iSBN;
	protected String titulo;
	protected String autor;
	protected int numeroPaginas;
	
	//CONSTRUCTORES
	public Libro() {
		this.iSBN = "";
		this.titulo = "";
		this.autor = "";
		this.numeroPaginas = 0;
	}
	
	public Libro(String iSBN, String titulo, String autor, int numeroPaginas) {
		this.iSBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}

	//generamos GETTERS y SETTERS
	public String getISBN() {
		return iSBN;
	}
	public void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	//Crear el método toString() para mostrar la información relativa al libro con elsiguiente formato: “El libro con ISBN creado por el autor tiene páginas”
	@Override
	public String toString() {
		return " El Libro con ISBN " + iSBN + ", creado por el autor " + autor +" tiene " + numeroPaginas + " páginas";
				
	}
	
	
}
