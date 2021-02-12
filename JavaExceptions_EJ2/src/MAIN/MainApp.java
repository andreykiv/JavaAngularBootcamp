package MAIN;

/**
*@author: Myroslav Andreykiv
**/
import customException.MyException;

public class MainApp {

	public static void main(String[] args) {
		try {
			//mostramos la línea de código
			System.out.println("Muestro un mensaje por la pantalla");
			//creamos un objeto de la clase MyException
			MyException newException = new MyException("Excepción capturada con mensaje: Esto es un objeto Exception");
			System.out.println(newException.getMensajeExplicativo());
			//lanzamos la excepcion para mostrar la en el catch
			throw new MyException("Termina el programa");
		} catch (MyException e) {
			System.out.println(e.getMensajeExplicativo());
		}

	}

}
