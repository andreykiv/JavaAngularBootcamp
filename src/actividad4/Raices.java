package actividad4;
/**
 * @author: Myroslav Andreykiv
 **/

/*Vamos a realizar una clase llamada Raices, donde representaremos los valores de
una ecuación de 2º grado.*/
public class Raices {
	
	//Tendremos los 3 coeficientes como atributos, llamémosles a, b y c.
	protected double a;
	protected double b;
	protected double c;
	
	//Hay que insertar estos 3 valores para construir el objeto
	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//Las operaciones que se podrán hacer son las siguientes:
	
	//obtenerRaices(): imprime las 2 posibles soluciones
	public void obtenerRaices() {
		double raiz1 = (b - Math.sqrt(Math.pow(b, 2) - (4*a*c)))/2*a;
		double raiz2 = (b + Math.sqrt(Math.pow(b, 2) - (4*a*c)))/2*a;
		
		if(getDiscriminante() > 0) {
			System.out.println(raiz1);
			System.out.println(raiz2);
		}
		
	}
	
	//obtenerRaiz(): e única raíz, que será cuando solo tenga una solución posible
	public void obtenerRaiz() {
		
		if(getDiscriminante() == 0) {
			System.out.println("Unica solución: " + 1);
		}
		
	}
	//devuelve el valor del discriminante (double), el discriminante tiene la siguiente formula, (b^2)-4*a*c
	public double getDiscriminante() {
		double discriminante = Math.pow(b, 2) - (4*a*c);
		return discriminante;
	}
	
	//tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para que esto ocurra, el discriminante debe ser mayor o igual que 0.
	public boolean tieneRaices() {
		boolean tiene = false;
		
		if(Math.pow(b, 2) > (4*a*c)) {
			//asignamos valorAretornar a la única solucion
			tiene = true;
		} 
		return tiene;
	}
	
//	tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para que esto ocurra, el discriminante debe ser igual que 0.
	public boolean tieneRaiz(){
		boolean tiene = true;
		
		if(getDiscriminante() == 0) {
			//asignamos valorAretornar a la única solucion
			tiene = false;
		} 
		return tiene;
	}
	
	//calcular(): mostrara por consola las posibles soluciones que tiene nuestra ecuación, en caso de no existir solución, mostrarlo también.
	public void calcular() {
		
		if(getDiscriminante() < 0) {
			System.out.println("No hay solución");
		} else if(getDiscriminante() > 0) {
			obtenerRaices();
		} else {
			obtenerRaiz();
		}
	}
}
