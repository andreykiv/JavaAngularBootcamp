package models.dto;

public class Proyecto {
	//atributos
	private String idProyecto;
	private String nombreProyecto;
	private Integer horas;
	

	//GETTERS Y SETTERS
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
}
