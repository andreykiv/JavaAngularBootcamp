package actividad3.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Almmacenes.
 */
@Entity
@Table(name="almacenes")//en caso que la tabla sea diferente
public class Almacenes {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	//atributos
	private Long id;
	
	/** The lugar. */
	private String lugar;
	
	/** The capacidad. */
	private int capacidad;
	
    /** The cajas. */
    @OneToMany
    @JoinColumn(name="numreferencia")
	private List<Cajas> cajas;
    
    
    //COSNTRUCTORES
	public Almacenes() {
		super();
	}

	public Almacenes(Long id, String lugar, int capacidad, List<Cajas> cajas) {
		super();
		this.id = id;
		this.lugar = lugar;
		this.capacidad = capacidad;
		this.cajas = cajas;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Cajas> getCajas() {
		return cajas;
	}
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Cajas")
	public void setCajas(List<Cajas> cajas) {
		this.cajas = cajas;
	}

	@Override
	public String toString() {
		return "Almacenes [id=" + id + ", lugar=" + lugar + ", capacidad=" + capacidad
				+ "]";
	}
}
