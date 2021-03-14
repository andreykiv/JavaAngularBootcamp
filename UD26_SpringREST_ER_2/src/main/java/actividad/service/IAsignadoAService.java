package actividad.service;

import java.util.List;

import actividad.dto.AsignadoA;

public interface IAsignadoAService {

	//Metodos del CRUD
		public List<AsignadoA> listarAsignadoA(); //Listar All 
		
		public AsignadoA guardarAsignadoA(AsignadoA asignadoA);	//Guarda un AsignadoA CREATE
		
		public AsignadoA asignadoAXID(int id); //Leer datos de un AsignadoA READ
		
		public AsignadoA actualizarAsignadoA(AsignadoA asignadoA); //Actualiza datos del AsignadoA UPDATE
		
		public void eliminarAsignadoA(int id);// Elimina el AsignadoA DELETE
	
}


