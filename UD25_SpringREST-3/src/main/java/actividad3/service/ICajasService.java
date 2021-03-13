package actividad3.service;

import java.util.List;

import actividad3.dto.Cajas;

public interface ICajasService {
	//Metodos del CRUD
	public List<Cajas> listarCajas(); //Listar All 

	public Cajas guardarCajas(Cajas cajas);	//Guarda un cajas CREATE

	public Cajas cajasXReferencia(String numreferencia); //Leer datos de un cajas READ

	public Cajas actualizarCajas(Cajas cajas); //Actualiza datos del Cajas UPDATE

	public void eliminarCajas(String numreferencia);// Elimina el Cajas DELETE
}
