package actividad.service;

import java.util.List;

import actividad.dto.Equipos;

public interface IEquiposService {

	//Metodos del CRUD
		public List<Equipos> listarEquipos(); //Listar All 
		
		public Equipos guardarEquipo(Equipos equipo);	//Guarda un Equipo CREATE
		
		public Equipos equipoXID(String numserie); //Leer datos de un Equipo READ
		
		public Equipos actualizarEquipo(Equipos equipo); //Actualiza datos del Equipo UPDATE
		
		public void eliminarEquipo(String numserie);// Elimina el Equipo DELETE
	
}


