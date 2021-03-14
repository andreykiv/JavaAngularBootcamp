package actividad.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")//en caso que la tabala sea diferente
public class Cientificos {

	//Atributos de entidad curso
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private String dni;
	private String nomapels;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<AsignadoA> asignadoA;

	public Cientificos() {
		super();
	}

	public Cientificos(String dni, String nomapels, List<AsignadoA> asignadoA) {
		super();
		this.dni = dni;
		this.nomapels = nomapels;
		this.asignadoA = asignadoA;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(List<AsignadoA> asignadoA) {
		this.asignadoA = asignadoA;
	}

	@Override
	public String toString() {
		return "Cientificos [dni=" + dni + ", nomapels=" + nomapels + "]";
	}
}
