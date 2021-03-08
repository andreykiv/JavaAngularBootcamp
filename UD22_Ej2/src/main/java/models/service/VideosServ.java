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

import controllers.VideosController;
import models.dao.VideosDao;
import models.dto.Videos;

public class VideosServ {
	
	private VideosController videoController; 
	public static boolean consultarVideo=false;
	public static boolean modificarVideo=false;
	
	//Metodo de vinculación con el controller principal
	public void setvideoController(VideosController videoController) {
		this.setController(videoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Videos miVideo) {
		VideosDao miVideoDao;
		miVideoDao = new VideosDao();
		miVideoDao.registrarVideos(miVideo);						
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Videos validarConsulta(String codigoVideo) {
		VideosDao miVideoDao;
		
		try {
			int codigo=Integer.parseInt(codigoVideo);	
			miVideoDao = new VideosDao();
			consultarVideo=true;
			return miVideoDao.buscarVideos(codigo);									
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultarVideo=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultarVideo=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Videos miVideo) {
		VideosDao miVideoDao;

			miVideoDao = new VideosDao();
			miVideoDao.modificarVideo(miVideo);	
			modificarVideo=true;

	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		VideosDao miVideoDao=new VideosDao();
		miVideoDao.eliminarVideo(codigo);
	}

	
	public VideosController getVideoController() {
		return videoController;
	}

	public void setController(VideosController videoController) {
		this.videoController = videoController;
	}
}
