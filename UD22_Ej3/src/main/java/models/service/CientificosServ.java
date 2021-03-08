/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de registros como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de registros, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite cientifico en
 * el Dao.
 */


/**
 * @author Myroslav Andreykiv
 *
 */

package models.service;
import models.dto.Cientificos;

import javax.swing.JOptionPane;

import controllers.CientificosController;
import models.dao.CientificosDao;


public class CientificosServ {
	//atributos CientificosServ
	private CientificosController CientificosController;
	
	public static boolean consultaCientificos=false;
	public static boolean modificarCientificos=false;
	
	//Metodo de vinculación con el controller principal
	public void setCientificosController(CientificosController CientificosController) {
		this.setController(CientificosController);
	}
	
	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientificos miCientificos) {
		CientificosDao miCientificosDao;
		//si el user inserta un dni mayor a 8caracteres y nombre mayor a 255 caracteres no se registra el Cientificos
		if(miCientificos.getDniCientifico().length() < 9 || miCientificos.getNomApelsCientifico().length() < 256) {
			miCientificosDao = new CientificosDao();
			miCientificosDao.registrarCientifico(miCientificos);
		} else {
			JOptionPane.showMessageDialog(null, "El DNI del Cientificos debe tener menos de 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientificos validarConsulta(String dniCientifico) {
		CientificosDao miCientificosDao;
		
			//si el dni de la persona es menor a 9  se valida la consulta
			if(dniCientifico.length() < 9) {
				miCientificosDao = new CientificosDao();
				consultaCientificos = true;
				return miCientificosDao.buscarCientifico(dniCientifico);
			} else {
				JOptionPane.showMessageDialog(null, "El dni del Cientificos debe tener menos de 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		return null;
	}
	
	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientificos miCientificos) {
		CientificosDao miCientificosDao;
		if(miCientificos.getDniCientifico().length() < 9 && miCientificos.getNomApelsCientifico().length() < 256) {
			miCientificosDao = new CientificosDao();
			miCientificosDao.modificarCientifico(miCientificos);
			modificarCientificos=true;
		} else {
			JOptionPane.showMessageDialog(null, "El dni del Cientifico debe tener menos de 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
			modificarCientificos=false;
		}
	}
	
	
	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String dniCientifico) {
		CientificosDao miCientificosDao = new CientificosDao();
		if(dniCientifico.length() < 9) {
			miCientificosDao.eliminarCientifico(dniCientifico);
		} else {
			JOptionPane.showMessageDialog(null, "El dni del Cientifico debe tener menos de 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	//GETTERS Y SETTERS
	public CientificosController getCientificosController() {
		return CientificosController;
	}

	public void setController(CientificosController CientificosController) {
		this.CientificosController = CientificosController;
	}
}
