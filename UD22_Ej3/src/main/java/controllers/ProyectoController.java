package controllers;

import models.dto.Proyecto;
import models.service.ProyectoServ;
import views.VentanaBuscarProyecto;
import views.VentanaPrincipal;
import views.VentanaRegistroProyecto;

public class ProyectoController {
	//atributos
	private ProyectoServ ProyectoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroProyecto miVentanaRegistroProyecto;
	private VentanaBuscarProyecto miVentanaBuscarProyecto;
	
	//GETTERS Y SETTERS
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipalProyecto(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroProyecto getMiVentanaRegistroProyecto() {
		return miVentanaRegistroProyecto;
	}
	public void setMiVentanaRegistroProyecto(VentanaRegistroProyecto miVentanaRegistroProyecto) {
		this.miVentanaRegistroProyecto = miVentanaRegistroProyecto;
	}
	public VentanaBuscarProyecto getMiVentanaBuscarProyecto() {
		return miVentanaBuscarProyecto;
	}
	public void setMiVentanaBuscarProyecto(VentanaBuscarProyecto miVentanaBuscarProyecto) {
		this.miVentanaBuscarProyecto = miVentanaBuscarProyecto;
	}
	public ProyectoServ getProyectoerv() {
		return ProyectoServ;
	}
	public void setProyectoerv(ProyectoServ proyectoServ) {
		this.ProyectoServ = proyectoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroProyecto() {
		miVentanaRegistroProyecto.setVisible(true);
	}
	public void mostrarVentanaConsultaProyecto() {
		miVentanaBuscarProyecto.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarRegistro(miProyecto);
	}
	
	public Proyecto buscarProyecto(String idProyecto) {
		return ProyectoServ.validarConsulta(idProyecto);
	}
	
	public void modificarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarModificacion(miProyecto);
	}
	
	public void eliminarProyecto(String idProyecto) {
		ProyectoServ.validarEliminacion(idProyecto);
	}
}
