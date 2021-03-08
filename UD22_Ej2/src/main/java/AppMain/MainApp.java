package AppMain;


import controllers.ClienteController;
import controllers.VideosController;
import models.service.ClienteServ;
import models.service.VideosServ;
import views.VentanaBuscarCliente;
import views.VentanaBuscarVideos;
import views.VentanaPrincipal;
import views.VentanaRegistroCliente;
import views.VentanaRegistroVideos;

public class MainApp {
	
	ClienteServ miClienteServ;
	VideosServ miVideoServ;
	
	VentanaPrincipal miVentanaPrincipal;
	
	VentanaBuscarCliente miVentanaBuscarClientes;
	VentanaRegistroCliente miVentanaRegistroClientes;
	
	VentanaBuscarVideos miVentanaBuscarVideos;
	VentanaRegistroVideos miVentanaRegistroVideo;
	
	ClienteController clienteController;
	VideosController videoController;
	
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
		
		miVentanaRegistroClientes=new VentanaRegistroCliente();
		miVentanaBuscarClientes= new VentanaBuscarCliente();
		miClienteServ=new ClienteServ();
		clienteController= new ClienteController();
		
		miVentanaRegistroVideo= new VentanaRegistroVideos();
		miVentanaBuscarVideos= new VentanaBuscarVideos();
		miVideoServ= new VideosServ();
		videoController= new VideosController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(clienteController);
		miVentanaRegistroClientes.setCoordinador(clienteController);
		miVentanaBuscarClientes.setCoordinador(clienteController);
		miClienteServ.setClienteController(clienteController);
		
		miVentanaPrincipal.setCoordinador(videoController);
		miVentanaRegistroVideo.setCoordinador(videoController);
		miVentanaBuscarVideos.setCoordinador(videoController);
		miVideoServ.setController(videoController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		clienteController.setMiVentanaRegistro(miVentanaRegistroClientes);
		clienteController.setMiVentanaBuscar(miVentanaBuscarClientes);
		clienteController.setClienteServ(miClienteServ);
		
		videoController.setMiVentanaPrincipalVideos(miVentanaPrincipal);
		videoController.setMiVentanaRegistroVideos(miVentanaRegistroVideo);
		videoController.setMiVentanaBuscarVideos(miVentanaBuscarVideos);
		videoController.setVideoServ(miVideoServ);
				
		miVentanaPrincipal.setVisible(true);
	}
}
