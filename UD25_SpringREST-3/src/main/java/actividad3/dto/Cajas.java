package actividad3.dto;

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
@Table(name="cajas")//en caso que la tabla sea diferente
public class Cajas {
	

	//atributos
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db (NO SE PONE EN EL CASO QUE LA PRIMARY KEY NO ES AUTOINCREMENTAL)
	private String numreferencia;
	
	/** The contenido. */
	private String contenido;
	
	/** The valor. */
	private int valor;
	
    @ManyToOne
    @JoinColumn(name="almacen")
	private Almacenes almacen;
    
    //CONSTRUCTORES
	public Cajas() {
		
	}

	public Cajas(String numreferencia, String contenido, int valor, Almacenes almacen) {
		super();
		this.numreferencia = numreferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public String getNumReferencia() {
		return numreferencia;
	}

	public void setNumReferencia(String numreferencia) {
		this.numreferencia = numreferencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacenes getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacenes almacen) {
		this.almacen = almacen;
	}

	@Override
	public String toString() {
		return "Cajas [numreferencia=" + numreferencia + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}
	
}
