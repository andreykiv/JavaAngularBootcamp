package actividad2.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Departamento.
 */
@Entity
@Table(name="departamentos")//en caso que la tabla sea diferente
public class Departamento {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	//atributos
	private Long id;
	
	/** The nombre. */
	private String nombre;
	
	/** The presupuesto. */
	private int presupuesto;
	
    /** The empleado. */
    @OneToMany
    @JoinColumn(name="dni")
	private List<Empleado> empleado;
    
    /**
     * Instantiates a new departamento.
     */
    //constructors
	public Departamento() {
	
	}
	
	/**
	 * Instantiates a new departamento.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param presupuesto the presupuesto
	 * @param empleado the empleado
	 */
	public Departamento(Long id, String nombre, int presupuesto, List<Empleado> empleado) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.empleado = empleado;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the presupuesto.
	 *
	 * @return the presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}

	/**
	 * Sets the presupuesto.
	 *
	 * @param presupuesto the new presupuesto
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * Gets the empleado.
	 *
	 * @return the empleado
	 */
	public List<Empleado> getEmpleado() {
		return empleado;
	}
	
	/**
	 * Sets the empleado.
	 *
	 * @param empleado the new empleado
	 */
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Empleado")
	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", empleado="
				+ empleado + "]";
	}
	
}
