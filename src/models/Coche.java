package models;

public class Coche {
	//ATRIBUTOS
	protected String matricula;
	protected String marca;
	protected String color;
	protected String marcaRuedasDelanteras;
	protected double diametroRuedasDelanteras;
	protected String marcaRuedasTraseras;
	protected double diametroRuedasTraseras;

	
	//CONSTRUCTORES
	//default
	public Coche() {
		this.matricula = "";
		this.marca = "";
		this.color = "";
	}
	//con tres parametros
	public Coche(String matricula, String marca, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	//con todos los parametros (7)
	public Coche(String matricula, String marca, String color, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String 	marcaRuedasTraseras, double diametroRuedasTraseras) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	
	//GETTERS Y SETTERS
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarcaRuedasDelanteras() {
		return marcaRuedasDelanteras;
	}
	public void setMarcaRuedasDelanteras(String marcaRuedasDelanteras) {
		this.marcaRuedasDelanteras = marcaRuedasDelanteras;
	}
	public double getDiametroRuedasDelanteras() {
		return diametroRuedasDelanteras;
	}
	public void setDiametroRuedasDelanteras(double diametroRuedasDelanteras) {
		this.diametroRuedasDelanteras = diametroRuedasDelanteras;
	}
	public String getMarcaRuedasTraseras() {
		return marcaRuedasTraseras;
	}
	public void setMarcaRuedasTraseras(String marcaRuedasTraseras) {
		this.marcaRuedasTraseras = marcaRuedasTraseras;
	}
	public double getDiametroRuedasTraseras() {
		return diametroRuedasTraseras;
	}
	public void setDiametroRuedasTraseras(double diametroRuedasTraseras) {
		this.diametroRuedasTraseras = diametroRuedasTraseras;
	}
	
	
}
