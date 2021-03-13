package actividad4.service;

import java.util.List;

import actividad4.dto.Peliculas;

public interface IPeliculasService {
	//Metodos del CRUD
	public List<Peliculas> listarPeliculas(); //Listar All 

	public Peliculas guardarPeliculas(Peliculas peliculas);	//Guarda un Peliculas CREATE

	public Peliculas PeliculasXID(Long id); //Leer datos de un Peliculas READ

	public Peliculas actualizarPeliculas(Peliculas peliculas); //Actualiza datos del Peliculas UPDATE

	public void eliminarPeliculas(Long id);// Elimina el Peliculas DELETE
	
}
