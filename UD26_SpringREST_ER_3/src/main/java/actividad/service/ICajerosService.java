package actividad.service;

import java.util.List;

import actividad.dto.Cajeros;

public interface ICajerosService {

	//Metodos del CRUD
		public List<Cajeros> listarCajeros(); //Listar All 
		
		public Cajeros guardarCajero(Cajeros cajero);	//Guarda un Cajero CREATE
		
		public Cajeros cajeroXID(int id); //Leer datos de un Cajero READ
		
		public Cajeros actualizarCajero(Cajeros cajero); //Actualiza datos del Cajero UPDATE
		
		public void eliminarCajero(int id);// Elimina el Cajero DELETE
	
}


