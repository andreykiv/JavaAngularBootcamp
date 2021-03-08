/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package controllers;
import models.dto.Cliente;
import models.service.ClienteServ;
import views.VentanaBuscarCliente;
import views.VentanaPrincipal;
import views.VentanaRegistroCliente;

public class ClienteController {
	//atributos
	private ClienteServ clienteServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCliente miVentanaRegistro;
	private VentanaBuscarCliente miVentanaBuscar;
	
	//Metodos GETTER y SETTER de vistas
	public ClienteServ getClienteServ() {
		return clienteServ;
	}
	public void setClienteServ(ClienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroCliente getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistroCliente miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaBuscarCliente getMiVentanaBuscar() {
		return miVentanaBuscar;
	}
	public void setMiVentanaBuscar(VentanaBuscarCliente miVentanaBuscar) {
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
	public void registrarCliente(Cliente miCliente) {
		clienteServ.validarRegistro(miCliente);
	}
	
	public Cliente buscarCliente(String idCliente) {
		return clienteServ.validarConsulta(idCliente);
	}
	
	public void modificarCliente(Cliente miCliente) {
		clienteServ.validarModificacion(miCliente);
	}
	
	public void eliminarCliente(String id) {
		clienteServ.validarEliminacion(id);
	}
}
