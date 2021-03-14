package actividad.service;

import java.util.List;

import actividad.dto.Investigadores;

public interface IInvestigadoresService {

	//Metodos del CRUD
		public List<Investigadores> listarInvestigadores(); //Listar All 
		
		public Investigadores guardarInvestigador(Investigadores investigador);	//Guarda un Investigador CREATE
		
		public Investigadores investigadorXID(String dni); //Leer datos de un Investigador READ
		
		public Investigadores actualizarInvestigador(Investigadores investigador); //Actualiza datos del Investigador UPDATE
		
		public void eliminarInvestigador(String dni);// Elimina el Investigador DELETE
	
}


