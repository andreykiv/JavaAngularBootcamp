package actividad1.service;

import java.util.List;

import actividad1.dto.Suministra;

public interface ISuministraService {

	//Metodos del CRUD
		public List<Suministra> listarSuministra(); //Listar All 
		
		public Suministra guardarSuministra(Suministra suministra);	//Guarda un Suministra CREATE
		
		public Suministra suministraXID(int id); //Leer datos de un Suministra READ
		
		public Suministra actualizarSuministra(Suministra suministra); //Actualiza datos del Suministra UPDATE
		
		public void eliminarSuministra(int id);// Elimina el Suministra DELETE
	
}


