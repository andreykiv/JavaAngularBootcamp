package models.service;

import javax.swing.JOptionPane;

import models.dao.AsignadoADao;
import models.dto.AsignadoA;
import controllers.AsignadoAController;

public class AsignadoAServ {
	//atributos AsignadoAServ
		private AsignadoAController AsignadoAController;
		
		public static boolean consultaAsignadoA=false;
		public static boolean modificarAsignadoA=false;
		
		//Metodo de vinculación con el controller principal
		public void setAsignadoAController(AsignadoAController asignadoAController) {
			this.setController(asignadoAController);
		}
		
		//Metodo que valida los datos de Registro antes de pasar estos al DAO
		public void validarRegistro(AsignadoA miAsignadoA) {
			AsignadoADao miAsignadoADao;
			//si el user inserta un dni mayor a 8caracteres y nombre mayor a 255 caracteres no se registra el AsignadoA
			if(!(miAsignadoA.getProyectoAsignado().length() > 4) || !(miAsignadoA.getCientificoAsignado().length() > 8)) {
				miAsignadoADao = new AsignadoADao();
				miAsignadoADao.registrarAsignadoA(miAsignadoA);
			} else {
				JOptionPane.showMessageDialog(null, "Id del proyecto asignado tiene que ser menor a 4 caracteres, DNI del cientifico tiene que ser menor a 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		//Metodo que valida los datos de consulta antes de pasar estos al DAO
		public AsignadoA validarConsulta(String dniCientifico, String idProyecto) {
			AsignadoADao miAsignadoADao;
			
				//si el dni de la persona es menor a 9  se valida la consulta
				if((dniCientifico.length() < 9) && (idProyecto.length() < 5)){
					miAsignadoADao = new AsignadoADao();
					consultaAsignadoA = true;
					return miAsignadoADao.buscarAsignadoA(dniCientifico, idProyecto);
				} else {
					JOptionPane.showMessageDialog(null, "El dni del cientifico o el id del proyecto no está entre el rango de valores permitidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			return null;
		}
		
		//Metodo que valida los datos de Modificación antes de pasar estos al DAO
		public void validarModificacion(AsignadoA miAsignadoA) {
			AsignadoADao miAsignadoADao;
			if((miAsignadoA.getCientificoAsignado().length() < 9) && (miAsignadoA.getProyectoAsignado().length() < 5)) {
				miAsignadoADao = new AsignadoADao();
				miAsignadoADao.modificarAsignadoA(miAsignadoA);
				modificarAsignadoA=true;
			} else {
				JOptionPane.showMessageDialog(null, "El dni del cientifico o id del proyecto no está dentro de rango de valores permitidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				modificarAsignadoA=false;
			}
		}
		
		
		//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
		public void validarEliminacion(String dniCientifico, String idProyecto) {
			AsignadoADao miAsignadoADao = new AsignadoADao();
			if((dniCientifico.length() < 8) && (idProyecto.length() < 5)) {
				miAsignadoADao.eliminarAsignadoA(dniCientifico, idProyecto);
			} else {
				JOptionPane.showMessageDialog(null, "El dni del cientifico o id del proyecto no está dentro de rango de valores permitidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
		//GETTERS Y SETTERS
		public AsignadoAController getAsignadoAController() {
			return AsignadoAController;
		}

		public void setController(AsignadoAController asignadoAController) {
			this.AsignadoAController = asignadoAController;
		}
}
