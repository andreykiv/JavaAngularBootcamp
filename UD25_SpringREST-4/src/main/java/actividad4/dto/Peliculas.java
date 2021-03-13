package actividad4.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Peliculas.
 */
@Entity
@Table(name="peliculas")//en caso que la tabla sea diferente
public class Peliculas {
	

	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db (NO SE PONE EN EL CASO QUE LA PRIMARY KEY NO ES AUTOINCREMENTAL)
	private Long id;
	
	/** The nombre. */
	private String nombre;
	
	/** The calificaionedad. */
	private int calificacionedad;
	
//	@ManyToOne
//	@JoinColumn(name = "salas")
//	private Salas salas;
    
    //CONSTRUCTORS
	public Peliculas() {
		super();
	}

	public Peliculas(Long id, String nombre, int calificacionedad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calificacionedad = calificacionedad;
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionedad() {
		return calificacionedad;
	}

	public void setCalificacionedad(int calificacionedad) {
		this.calificacionedad = calificacionedad;
	}
	

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", calificacionEdad=" + calificacionedad  + "]";
	}
	
}
