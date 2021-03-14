package actividad.service;

import java.util.List;

import actividad.dto.Facultad;

public interface IFacultadService {
	//Metodos del CRUD
	public List<Facultad> listarFacultades(); //Listar All 
	
	public Facultad guardarFacultad(Facultad facultad);	//Guarda un Facultad CREATE
	
	public Facultad facultadXID(int id); //Leer datos de un Facultad READ
	
	public Facultad actualizarFacultad(Facultad facultad); //Actualiza datos del Facultad UPDATE
	
	public void eliminarFacultad(int id);// Elimina el Facultad DELETE
}
