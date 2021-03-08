package controllers;

import models.dto.Videos;
import models.service.VideosServ;
import views.VentanaBuscarVideos;
import views.VentanaPrincipal;
import views.VentanaRegistroVideos;

public class VideosController {
	//atributos
	private VideosServ videoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroVideos miVentanaRegistroVideos;
	private VentanaBuscarVideos miVentanaBuscarVideos;
	
	//GETTERS Y SETTERS
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipalVideos(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroVideos getMiVentanaRegistroVideos() {
		return miVentanaRegistroVideos;
	}
	public void setMiVentanaRegistroVideos(VentanaRegistroVideos miVentanaRegistroVideos) {
		this.miVentanaRegistroVideos = miVentanaRegistroVideos;
	}
	public VentanaBuscarVideos getMiVentanaBuscarVideos() {
		return miVentanaBuscarVideos;
	}
	public void setMiVentanaBuscarVideos(VentanaBuscarVideos miVentanaBuscarVideos) {
		this.miVentanaBuscarVideos = miVentanaBuscarVideos;
	}
	public VideosServ getVideoServ() {
		return videoServ;
	}
	public void setVideoServ(VideosServ videoServ) {
		this.videoServ = videoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroVideos() {
		miVentanaRegistroVideos.setVisible(true);
	}
	public void mostrarVentanaConsultaVideos() {
		miVentanaBuscarVideos.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarVideo(Videos miVideo) {
		videoServ.validarRegistro(miVideo);
	}
	
	public Videos buscarVideo(String codigoVideo) {
		return videoServ.validarConsulta(codigoVideo);
	}
	
	public void modificarVideo(Videos miVideo) {
		videoServ.validarModificacion(miVideo);
	}
	
	public void eliminarVideo(String codigo) {
		videoServ.validarEliminacion(codigo);
	}
}
