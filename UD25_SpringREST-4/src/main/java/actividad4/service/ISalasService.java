package actividad4.service;

import java.util.List;

import actividad4.dto.Salas;

public interface ISalasService {
	//Metodos del CRUD
	public List<Salas> listarSalas(); //Listar All 

	public Salas guardarSalas(Salas salas);	//Guarda un Salas CREATE

	public Salas SalasXID(Long id); //Leer datos de un Salas READ

	public Salas actualizarSalas(Salas salas); //Actualiza datos del Salas UPDATE

	public void eliminarSalas(Long id);// Elimina el Salas DELETE
}
