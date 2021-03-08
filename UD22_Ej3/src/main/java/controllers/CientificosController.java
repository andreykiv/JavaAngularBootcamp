/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package controllers;
import models.dto.Cientificos;
import models.service.CientificosServ;
import views.VentanaBuscarCientificos;
import views.VentanaPrincipal;
import views.VentanaRegistroCientificos;

public class CientificosController {
	//atributos
	private CientificosServ cientificosServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCientificos miVentanaRegistro;
	private VentanaBuscarCientificos miVentanaBuscar;
	
	//Metodos GETTER y SETTER de vistas
	public CientificosServ getcientificosServ() {
		return cientificosServ;
	}
	public void setcientificosServ(CientificosServ cientificosServ) {
		this.cientificosServ = cientificosServ;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroCientificos getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistroCientificos miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaBuscarCientificos getMiVentanaBuscar() {
		return miVentanaBuscar;
	}
	public void setMiVentanaBuscar(VentanaBuscarCientificos miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	
	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCientificos(Cientificos miCientificos) {
		cientificosServ.validarRegistro(miCientificos);
	}
	
	public Cientificos buscarCientificos(String idCientificos) {
		return cientificosServ.validarConsulta(idCientificos);
	}
	
	public void modificarCientificos(Cientificos miCientificos) {
		cientificosServ.validarModificacion(miCientificos);
	}
	
	public void eliminarCientificos(String id) {
		cientificosServ.validarEliminacion(id);
	}
}
