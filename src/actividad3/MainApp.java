package actividad3;


/**
 * @author: Myroslav Andreykiv
 **/
public class MainApp {
	
	public static void masPaginas(Libro libroA, Libro libroB) {
		if(libroA.getNumeroPaginas() > libroB.getNumeroPaginas()) {
			System.out.println(libroA.getTitulo() + " tiene más páginas que " + libroB.getTitulo());
		} else if(libroA.getNumeroPaginas() < libroB.getNumeroPaginas()) {
			System.out.println(libroB.getTitulo() + " tiene más páginas que " + libroA.getTitulo());
		} else {
			System.out.println("Los libros tienen la misma cantidad de páginas");
		}
	}
	
	//En el fichero main, crear 2 objetos Libro (los valores que se quieran) y mostrarlos por pantalla.
	public static void main(String[] args) {
		Libro stormLightArchive = new Libro("9780765391674", "Stormlight Archive", "Brandon Sanderson", 1230);
		Libro dune = new Libro("9788497596824", "Dune", "Frank Herbert", 500);
		
		System.out.println(stormLightArchive.toString());
		System.out.println(dune.toString());
		//comparamos las paginas de cada libro y lo mostramos por la pantalla
		masPaginas(stormLightArchive, dune);
	}

}
