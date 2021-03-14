package actividad.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class reserva.
 */
@Entity
@Table(name="reserva")//en caso que la tabala sea diferente
public class Reserva {

	/** The id. */
	//Atributos de entidad 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	/** The cajero. */
	@ManyToOne
    @JoinColumn(name = "investigador_dni")
	Investigadores investigador;
	
	/** The producto. */
	@ManyToOne
    @JoinColumn(name = "equipo_numserie")
	Equipos equipo;
	
	Timestamp comienzo;
	Timestamp fin;
	
	//CONSTRUCTORES
	public Reserva() {
		super();
	}

	public Reserva(int id, Investigadores investigador, Equipos equipo, Timestamp comienzo, Timestamp fin) {
		super();
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investigadores getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigadores investigador) {
		this.investigador = investigador;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Timestamp getComienzo() {
		return comienzo;
	}

	public void setComienzo(Timestamp comienzo) {
		this.comienzo = comienzo;
	}

	public Timestamp getFin() {
		return fin;
	}

	public void setFin(Timestamp fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}
}
