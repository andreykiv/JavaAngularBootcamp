/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la persona en
 * el Dao.
 */


/**
 * @author Myroslav Andreykiv
 *
 */
package models.service;

import javax.swing.JOptionPane;

import controllers.ProyectoController;
import models.dao.ProyectoDao;
import models.dto.Proyecto;

public class ProyectoServ {
	
	private ProyectoController proyectoController; 
	public static boolean consultarproyecto=false;
	public static boolean modificarproyecto=false;
	
	//Metodo de vinculación con el controller principal
	public void setproyectoController(ProyectoController proyectoController) {
		this.setController(proyectoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if((miProyecto.getIdProyecto().length() < 5) && (miProyecto.getNombreProyecto().length() < 255)) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);		
		} else {
			JOptionPane.showMessageDialog(null,"Debe ingresar un id del proyecto menor a 5 caracteres","Error",JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validarConsulta(String idProyecto) {
		ProyectoDao miProyectoDao;
		if(idProyecto.length() < 5) {
			miProyectoDao = new ProyectoDao();
			consultarproyecto=true;
			return miProyectoDao.buscarProyecto(idProyecto);		
		} else {
			JOptionPane.showMessageDialog(null,"Debe ingresar un id del proyecto menor a 5 caracteres","Error",JOptionPane.ERROR_MESSAGE);
			consultarproyecto=false;
		}
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if((miProyecto.getIdProyecto().length() < 5) && (miProyecto.getNombreProyecto().length() < 256)) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);	
			modificarproyecto=true;
		} else{
			JOptionPane.showMessageDialog(null,"Debe ingresar un id del proyecto menor a 5 caracteres","Error",JOptionPane.ERROR_MESSAGE);
			modificarproyecto=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String idProyecto) {
		ProyectoDao miProyectoDao=new ProyectoDao();
		if(idProyecto.length() < 5) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.eliminarProyecto(idProyecto);	
		} else{
			JOptionPane.showMessageDialog(null,"Debe ingresar un id del proyecto menor a 5 caracteres","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public ProyectoController getproyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}
}
