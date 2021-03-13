package actividad3.service;

import java.util.List;

import actividad3.dto.Almacenes;

public interface IAlmacenesService {
	//Metodos del CRUD
	public List<Almacenes> listarAlmacenes(); //Listar All 

	public Almacenes guardarAlmacenes(Almacenes almacenes);	//Guarda un almacenes CREATE

	public Almacenes almacenesXID(Long id); //Leer datos de un almacenes READ

	public Almacenes actualizarAlmacenes(Almacenes almacenes); //Actualiza datos del almacenes UPDATE

	public void eliminarAlmacenes(Long id);// Elimina el almacenes DELETE
	
}
