package actividad.service;

import java.util.List;

import actividad.dto.Cientificos;

public interface ICientificosService {

	//Metodos del CRUD
		public List<Cientificos> listarCientificos(); //Listar All 
		
		public Cientificos guardarCientifico(Cientificos cientifico);	//Guarda un cientifico CREATE
		
		public Cientificos cientificoXID(String dni); //Leer datos de un cientifico READ
		
		public Cientificos actualizarCientifico(Cientificos cientifico); //Actualiza datos del cientifico UPDATE
		
		public void eliminarCientifico(String dni);// Elimina el cientifico DELETE
	
}


