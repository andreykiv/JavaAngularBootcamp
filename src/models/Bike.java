package models;

import java.util.ArrayList;

//subclase de Vehiculo
public class Bike extends Vehiculo {
	//ATRIBUTOS
	private String marcaRuedaDelantera;
	private double diametroRuedaDelantera;
	private String marcaRuedaTrasera;
	private double diametroRuedaTrasera;
	//CONSTRUCTORES
	//default
	public Bike() {
		this.marcaRuedaDelantera = "";
		this.diametroRuedaDelantera = 0;
		this.marcaRuedaTrasera = "";
		this.diametroRuedaTrasera = 0;
	}
	//con tres parametros
	public Bike(String matricula, String marca, String color) {
		super(matricula, marca, color);
		this.marcaRuedaDelantera = "";
		this.diametroRuedaDelantera = 0;
		this.marcaRuedaTrasera = "";
		this.diametroRuedaTrasera = 0;
	}
	//con los 7 parametros 
	public Bike(String matricula, String marca, String color, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String marcaRuedasTraseras, double diametroRuedasTraseras) {
		super(matricula, marca, color);
		this.marcaRuedaDelantera = marcaRuedasDelanteras;
		this.diametroRuedaDelantera = diametroRuedasDelanteras;
		this.marcaRuedaTrasera = marcaRuedasTraseras;
		this.diametroRuedaTrasera = diametroRuedasTraseras;
	}
	
	//con los 9 parametros 7 anteriores + titular y arraylist de personas
	public Bike(String matricula, String marca, String color, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String marcaRuedasTraseras, double diametroRuedasTraseras, Titular titular, ArrayList personas) {
		super(matricula, marca, color, titular, personas);
		this.marcaRuedaDelantera = marcaRuedasDelanteras;
		this.diametroRuedaDelantera = diametroRuedasDelanteras;
		this.marcaRuedaTrasera = marcaRuedasTraseras;
		this.diametroRuedaTrasera = diametroRuedasTraseras;
	}
	

	//GETTERS Y SETTERS
	public String getMarcaRuedaDelantera() {
		return marcaRuedaDelantera;
	}
	public void setMarcaRuedaDelantera(String marcaRuedaDelantera) {
		this.marcaRuedaDelantera = marcaRuedaDelantera;
	}
	public double getDiametroRuedaDelantera() {
		return diametroRuedaDelantera;
	}
	public void setDiametroRuedaDelantera(double diametroRuedaDelantera) {
		this.diametroRuedaDelantera = diametroRuedaDelantera;
	}
	public String getMarcaRuedaTrasera() {
		return marcaRuedaTrasera;
	}
	public void setMarcaRuedaTrasera(String marcaRuedaTrasera) {
		this.marcaRuedaTrasera = marcaRuedaTrasera;
	}
	public double getDiametroRuedaTrasera() {
		return diametroRuedaTrasera;
	}
	public void setDiametroRuedaTrasera(double diametroRuedaTrasera) {
		this.diametroRuedaTrasera = diametroRuedaTrasera;
	}

	
	
	//TOSTRING
	@Override
	public String toString() {
		return "Bike [marcaRuedaDelantera=" + marcaRuedaDelantera + ", diametroRuedaDelantera=" + diametroRuedaDelantera
				+ ", marcaRuedaTrasera=" + marcaRuedaTrasera + ", diametroRuedaTrasera=" + diametroRuedaTrasera
				+ ", matricula=" + matricula + ", marca=" + marca + ", color=" + color + ", titular=" + titular
				+ ", personas=" + personas + "]";
	}

}
