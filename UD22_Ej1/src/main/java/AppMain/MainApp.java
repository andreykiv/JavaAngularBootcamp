package AppMain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controllers.ClienteController;
import models.service.ClienteServ;
import views.VentanaBuscar;
import views.VentanaPrincipal;
import views.VentanaRegistro;

public class MainApp {
	
	ClienteServ miClienteServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	ClienteController clienteController;
	
	/**
	 * @param args
	 */


	public static void main(String[] args) {
		
		MainApp miPrincipal=new MainApp();
		miPrincipal.iniciar();	
	}
	
	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		miClienteServ=new ClienteServ();
		clienteController= new ClienteController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(clienteController);
		miVentanaRegistro.setCoordinador(clienteController);
		miVentanaBuscar.setCoordinador(clienteController);
		miClienteServ.setClienteController(clienteController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		clienteController.setMiVentanaRegistro(miVentanaRegistro);
		clienteController.setMiVentanaBuscar(miVentanaBuscar);
		clienteController.setClienteServ(miClienteServ);
				
		miVentanaPrincipal.setVisible(true);
	}


}
