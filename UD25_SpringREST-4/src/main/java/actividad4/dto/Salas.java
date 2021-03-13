package actividad4.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Salas.
 */
@Entity
@Table(name="salas")//en caso que la tabla sea diferente
public class Salas {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	//atributos
	private Long id;
	
	/** The nombre. */
	private String nombre;
	
    /** The peliculas. */
    @OneToMany
    @JoinColumn(name="id")
	private List<Peliculas> peliculas;
    
    
    //CONSTRUCTORES
	public Salas() {
		super();
	}


	public Salas(Long id, String nombre, List<Peliculas> peliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peliculas = peliculas;
	}

	//GETTERS Y SETTERS
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


	public List<Peliculas> getPeliculas() {
		return peliculas;
	}

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Peliculas")
	public void setPeliculas(List<Peliculas> peliculas) {
		this.peliculas = peliculas;
	}
	
	//TO STRING

	@Override
	public String toString() {
		return "Salas [id=" + id + ", nombre=" + nombre + ", peliculas=" + peliculas + "]";
	}
	
	
}
