/*Escribe un programa , utilizando para ello el paradigma de POO, que lance y
capture una excepción customizada. Crea para ello una package diferente que
puedas reutilizar para el resto de tus proyectos.*/

package customException;

public class MyException extends Exception{
	//recogemos el codigo
	private String mensajeExplicativo;
	
	//constructor por defecto
	public MyException() {
		this.mensajeExplicativo = "";
	}
	
	//constructor con el parametro codigoExcepcion
	public MyException(String mensajeExplicativo) {
		this.mensajeExplicativo = mensajeExplicativo;
	}
	
	//SETTERS Y GETTERS
	public String getMensajeExplicativo() {
		return mensajeExplicativo;
	}

	public void setMensajeExplicativo(String mensajeExplicativo) {
		this.mensajeExplicativo = mensajeExplicativo;
	}
}
