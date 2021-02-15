package models;

import java.util.ArrayList;

/**
 * @author: Myroslav Andreykiv
 **/

//subclase de Vehiculo
public class Coche extends Vehiculo{
	//ATRIBUTOS
	private String marcaRuedasDelanteras;
	private double diametroRuedasDelanteras;
	private String marcaRuedasTraseras;
	private double diametroRuedasTraseras;
	
	//CONSTRUCTORES
	//default
	public Coche() {
		this.marcaRuedasDelanteras = "";
		this.diametroRuedasDelanteras = 0;
		this.marcaRuedasTraseras = "";
		this.diametroRuedasTraseras = 0;
	}
	//con tres parametros
	public Coche(String matricula, String marca, String color) {
		super(matricula, marca, color);
		this.marcaRuedasDelanteras = "";
		this.diametroRuedasDelanteras = 0;
		this.marcaRuedasTraseras = "";
		this.diametroRuedasTraseras = 0;
	}
	
	//con los (7) parametros 
	public Coche(String matricula, String marca, String color, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String marcaRuedasTraseras, double diametroRuedasTraseras) {
		super(matricula, marca, color);
		this.marcaRuedasDelanteras = marcaRuedasDelanteras;
		this.diametroRuedasDelanteras = diametroRuedasDelanteras;
		this.marcaRuedasTraseras = marcaRuedasTraseras;
		this.diametroRuedasTraseras = diametroRuedasTraseras;
	}
	//con los 9 parametros (milestone 3)
	public Coche(String matricula, String marca, String color, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String marcaRuedasTraseras, double diametroRuedasTraseras, Titular titular, ArrayList personas) {
		super(matricula, marca, color, titular, personas);
		this.marcaRuedasDelanteras = marcaRuedasDelanteras;
		this.diametroRuedasDelanteras = diametroRuedasDelanteras;
		this.marcaRuedasTraseras = marcaRuedasTraseras;
		this.diametroRuedasTraseras = diametroRuedasTraseras;
	}

	//GETTERS Y SETTERS
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

	
	//TOSTRING
	@Override
	public String toString() {
		return "Coche [marcaRuedasDelanteras=" + marcaRuedasDelanteras + ", diametroRuedasDelanteras="
				+ diametroRuedasDelanteras + ", marcaRuedasTraseras=" + marcaRuedasTraseras
				+ ", diametroRuedasTraseras=" + diametroRuedasTraseras + ", matricula=" + matricula + ", marca=" + marca
				+ ", color=" + color + ", titular=" + titular + ", personas=" + personas + "]";
	}

}
