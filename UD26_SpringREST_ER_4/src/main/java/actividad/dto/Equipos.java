package actividad.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


// TODO: Auto-generated Javadoc
/**
 * The Class Equipos.
 */
@Entity
@Table(name="equipos")//en caso que la tabala sea diferente
public class Equipos {

	/** The numserie. */
	//Atributos de entidad estudiante
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private String numserie;
	
	/** The nombre. */
	private String nombre;
	
	/** The facultad. */
	@ManyToOne
    @JoinColumn(name = "facultad")
	Facultad facultad;
	
	/** The reserva. */
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reserva;

	/**
	 * Instantiates a new equipos.
	 */
	public Equipos() {
		super();
	}

	/**
	 * Instantiates a new equipos.
	 *
	 * @param numserie the numserie
	 * @param nombre the nombre
	 * @param facultad the facultad
	 * @param reserva the reserva
	 */
	public Equipos(String numserie, String nombre, Facultad facultad, List<Reserva> reserva) {
		super();
		this.numserie = numserie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	/**
	 * Gets the numserie.
	 *
	 * @return the numserie
	 */
	public String getNumserie() {
		return numserie;
	}

	/**
	 * Sets the numserie.
	 *
	 * @param numserie the new numserie
	 */
	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the facultad.
	 *
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * Sets the facultad.
	 *
	 * @param facultad the new facultad
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	/**
	 * Gets the reserva.
	 *
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * Sets the reserva.
	 *
	 * @param reserva the new reserva
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Equipos [numserie=" + numserie + ", nombre=" + nombre + ", facultad=" + facultad
				+ "]";
	}
	
}
