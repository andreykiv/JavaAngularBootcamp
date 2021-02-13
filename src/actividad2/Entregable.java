/*Como vemos, en principio, las clases anteriores no son padre-hija, pero
si tienen en común, por eso vamos a hacer una interfaz llamada
Entregable con los siguientes métodos:
• entregar(): cambia el atributo prestado a true.
• devolver(): cambia el atributo prestado a false.
• isEntregado(): devuelve el estado del atributo prestado.
• Método compareTo (Object a), compara las horas estimadas en los
videojuegos y en las series el numero de temporadas. Como
parámetro que tenga un objeto, no es necesario que implementes la
interfaz Comparable. Recuerda el uso de los casting de objetos.*/

package actividad2;

public interface Entregable {
	
	//entregar(): cambia el atributo prestado a true.
	public void entregar();
	//devolver(): cambia el atributo prestado a false.
	public void devolver();
	//isEntregado(): devuelve el estado del atributo prestado.
	public boolean isEntregado(); 
	//Método compareTo (Object a)
	public void compareTo(Object a);
	
}
