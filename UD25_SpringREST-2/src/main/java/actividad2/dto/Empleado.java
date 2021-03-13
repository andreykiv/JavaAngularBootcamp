package actividad2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Empleado.
 */
@Entity
@Table(name="empleados")//en caso que la tabla sea diferente
public class Empleado {
	
	/** The dni. */
	//atributos
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db (NO SE PONE EN EL CASO QUE LA PRIMARY KEY NO ES AUTOINCREMENTAL)
	private String dni;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The departamento. */
	@ManyToOne
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	/**
	 * Instantiates a new empleado.
	 */
	public Empleado() {
		super();
	}

	/**
	 * Instantiates a new empleado.
	 *
	 * @param dni the dni
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param departamento the departamento
	 */
	public Empleado(String dni, String nombre, String apellidos, Departamento departamento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the departamento.
	 *
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * Sets the departamento.
	 *
	 * @param departamento the new departamento
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", departamento="
				+ departamento + "]";
	}

}
