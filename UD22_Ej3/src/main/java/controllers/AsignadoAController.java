package controllers;

import models.dto.AsignadoA;
import models.service.AsignadoAServ;
import views.VentanaBuscarAsignadoA;
import views.VentanaPrincipal;
import views.VentanaRegistroAsignadoA;
import controllers.AsignadoAController;

public class AsignadoAController {
	//atributos
	private AsignadoAServ AsignadoAServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroAsignadoA miVentanaRegistroAsignadoA;
	private VentanaBuscarAsignadoA miVentanaBuscarAsignadoA;

	//GETTERS Y SETTERS
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipalAsignadoA(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroAsignadoA getMiVentanaRegistroAsignadoA() {
		return miVentanaRegistroAsignadoA;
	}
	public void setMiVentanaRegistroAsignadoA(VentanaRegistroAsignadoA miVentanaRegistroAsignadoA) {
		this.miVentanaRegistroAsignadoA = miVentanaRegistroAsignadoA;
	}
	public VentanaBuscarAsignadoA getMiVentanaBuscarAsignadoA() {
		return miVentanaBuscarAsignadoA;
	}
	public void setMiVentanaBuscarAsignadoA(VentanaBuscarAsignadoA miVentanaBuscarAsignadoA) {
		this.miVentanaBuscarAsignadoA = miVentanaBuscarAsignadoA;
	}
	public AsignadoAServ getAsignadoAerv() {
		return AsignadoAServ;
	}
	public void setAsignadoAerv(AsignadoAServ AsignadoAServ) {
		this.AsignadoAServ = AsignadoAServ;
	}

	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroAsignadoA() {
		miVentanaRegistroAsignadoA.setVisible(true);
	}
	public void mostrarVentanaConsultaAsignadoA() {
		miVentanaBuscarAsignadoA.setVisible(true);
	}

	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarAsignadoA(AsignadoA miAsignadoA) {
		AsignadoAServ.validarRegistro(miAsignadoA);
	}

	public AsignadoA buscarAsignadoA(String dniCientifico, String idProyecto) {
		return AsignadoAServ.validarConsulta(dniCientifico, idProyecto);
	}

	public void modificarAsignadoA(AsignadoA miAsignadoA) {
		AsignadoAServ.validarModificacion(miAsignadoA);
	}

	public void eliminarAsignadoA(String dniCientifico, String idProyecto) {
		AsignadoAServ.validarEliminacion(dniCientifico, idProyecto);
	}
}
