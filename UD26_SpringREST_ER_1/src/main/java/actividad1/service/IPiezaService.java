package actividad1.service;

import java.util.List;

import actividad1.dto.Pieza;



public interface IPiezaService {

	//Metodos del CRUD
		public List<Pieza> listarPiezas(); //Listar All 
		
		public Pieza guardarPieza(Pieza pieza);	//Guarda un Pieza CREATE
		
		public Pieza piezaXID(int id); //Leer datos de un Pieza READ
		
		public Pieza actualizarPieza(Pieza pieza); //Actualiza datos del Pieza UPDATE
		
		public void eliminarPieza(int id);// Elimina el Pieza DELETE
	

}


