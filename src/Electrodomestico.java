/*Crearemos una clase llamada Electrodomestico con las siguientes características:
• Sus atributos son precio base, color, consumo energético (letras entre A y F) ypeso.
Indica que se podrán heredar.
• Por defecto, el color sera blanco, el consumo energético sera F, el precioBase es de
100 € y el peso de 5 kg. Usa constantes para ello.
• Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si el nombre
esta en mayúsculas o en minúsculas.
• Los constructores que se implementaran serán
o Un constructor por defecto.
o Un constructor con el precio y peso. El resto por defecto.
o Un constructor con todos los atributos.*/

public class Electrodomestico {
	//definimos los atributos
	private double precio;
	private String color;
	private char consumoEnergetico;
	private double peso;
	
	//definimos constantes
	final static double DEFAULT_PRECIO = 100;
	final static String DEFAULT_COLOR = "blanco";
	final static char DEFAULT_CONSUMO = 'F';
	final static double DEFAULT_PESO = 5;
	final static String[] DEFAULT_COLORS = {"negro", "blanco", "rojo", "azul", "gris"};
	
	//Un constructor con el precio y peso. El resto por defecto. Asignamos valores que se heredan al crear objeto asignandolos a las constantes creadas previamente
	public Electrodomestico() {
		this.precio = DEFAULT_PRECIO;
		this.color = DEFAULT_COLOR;
		this.consumoEnergetico = DEFAULT_CONSUMO;
		this.peso = DEFAULT_PESO;
	}

	//Un constructor con el precio y peso. El resto por defecto.
	public Electrodomestico(double precio, double peso) {
		this.precio = precio;
		this.peso = peso;
		this.color = DEFAULT_COLOR;
		this.consumoEnergetico = DEFAULT_CONSUMO;
	}
	
	//Un constructor con todos los atributos
	public Electrodomestico(double precio, String color, char consumoEnergetico, double peso) {
		this.precio = precio;
		//asignamos el color que nos pasa el user si existe entre los colores disponibles, sinó lo asignamos al DEFAULT
		for(int i = 0; i<DEFAULT_COLORS.length; i++) {
			if(color.equals(DEFAULT_COLORS[i])) {
				this.color = color;
			}
		}
		if(this.color == null) {
			this.color = DEFAULT_COLOR;
		}
		
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
	}	
	
	//GETTERS Y SETTERS
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
