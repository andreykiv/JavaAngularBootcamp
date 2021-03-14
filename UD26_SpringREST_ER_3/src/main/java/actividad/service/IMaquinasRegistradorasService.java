package actividad.service;

import java.util.List;

import actividad.dto.MaquinasRegistradoras;

public interface IMaquinasRegistradorasService {
	//Metodos del CRUD
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(); //Listar All 
	
	public MaquinasRegistradoras guardarMaquinaRegistradora(MaquinasRegistradoras maquinaRegistradora);	//Guarda un MaquinaRegistradora CREATE
	
	public MaquinasRegistradoras maquinaRegistradoraXID(int id); //Leer datos de un MaquinaRegistradora READ
	
	public MaquinasRegistradoras actualizarMaquinaRegistradora(MaquinasRegistradoras maquinaRegistradora); //Actualiza datos del MaquinaRegistradora UPDATE
	
	public void eliminarMaquinaRegistradora(int id);// Elimina el MaquinaRegistradora DELETE
}
