package M7FrontalAJAX.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")//en caso que la tabla sea diferente
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	Long id;
	String name;
	String detail;
	@Column(name = "created_at")//no hace falta si se llama igual
	Timestamp createdAt = fecha();
	@Column(name = "updated_at")//no hace falta si se llama igual
	Timestamp updatedAt = fecha();
	
	
	//CONSTRUCTORS
	public Products() {
		super();
	}
	public Products(Long id, String name, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.createdAt = fecha();
		this.updatedAt = fecha();
	}
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	//asignamos createdAt directamente a la fecha del servidor
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = fecha();
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	//asignamos updatedAt directamente a la fecha del servidor
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = fecha();
	}
	
	//METODO QUE MUESTRA FECHA ACTUAL 
	public static Timestamp fecha() {
//		Date date = new Date();
//		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
//		System.out.println(" - " + hourdateFormat.format(date));
//		return date;
		java.util.Date date = new Date();
		Timestamp param = new java.sql.Timestamp(date.getTime());
		System.out.println(param);
		return param;
	}
	
	
	
	@Override
	public String toString() {
		return "products [id=" + id + ", name=" + name + ", detail=" + detail + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
