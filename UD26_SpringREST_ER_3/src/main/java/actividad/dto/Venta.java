package actividad.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class Venta.
 */
@Entity
@Table(name="venta")//en caso que la tabala sea diferente
public class Venta {

	/** The id. */
	//Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	/** The cajero. */
	@ManyToOne
    @JoinColumn(name = "cajero_id")
	Cajeros cajero;
	
	/** The producto. */
	@ManyToOne
    @JoinColumn(name = "producto_id")
	Productos producto;
 
    /** The maquina registradora. */
    @ManyToOne
    @JoinColumn(name = "maquinas_registradoras_id")
    MaquinasRegistradoras maquinaRegistradora;

	/**
	 * Instantiates a new venta.
	 */
	public Venta() {
		super();
	}

	/**
	 * Instantiates a new venta.
	 *
	 * @param id the id
	 * @param cajero the cajero
	 * @param producto the producto
	 * @param maquinaRegistradora the maquina registradora
	 */
	public Venta(int id, Cajeros cajero, Productos producto, MaquinasRegistradoras maquinaRegistradora) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinaRegistradora = maquinaRegistradora;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the cajero.
	 *
	 * @return the cajero
	 */
	public Cajeros getCajero() {
		return cajero;
	}

	/**
	 * Sets the cajero.
	 *
	 * @param cajero the new cajero
	 */
	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public Productos getProducto() {
		return producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	/**
	 * Gets the maquina registradora.
	 *
	 * @return the maquina registradora
	 */
	public MaquinasRegistradoras getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	/**
	 * Sets the maquina registradora.
	 *
	 * @param maquinaRegistradora the new maquina registradora
	 */
	public void setMaquinaRegistradora(MaquinasRegistradoras maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", producto=" + producto + ", maquinaRegistradora="
				+ maquinaRegistradora + "]";
	}
	
}
