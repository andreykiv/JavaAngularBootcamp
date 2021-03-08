package AppMain;


import controllers.CientificosController;
import controllers.ProyectoController;
import controllers.AsignadoAController;
import models.service.AsignadoAServ;
import models.service.CientificosServ;
import models.service.ProyectoServ;
import views.VentanaBuscarProyecto;
import views.VentanaBuscarAsignadoA;
import views.VentanaBuscarCientificos;
import views.VentanaPrincipal;
import views.VentanaRegistroAsignadoA;
import views.VentanaRegistroCientificos;
import views.VentanaRegistroProyecto;

public class MainApp {
	
	CientificosServ miCientificoServ;
	ProyectoServ miProyectoServ;
	AsignadoAServ miAsignadoAServ;
	
	VentanaPrincipal miVentanaPrincipal;
	
	VentanaBuscarCientificos miVentanaBuscarCientificos;
	VentanaRegistroCientificos miVentanaRegistroCientificos;
	
	VentanaBuscarProyecto miVentanaBuscarProyectos;
	VentanaRegistroProyecto miVentanaRegistroProyecto;
	
	VentanaBuscarAsignadoA miVentanaBuscarAsignadoA;
	VentanaRegistroAsignadoA miVentanaRegistroAsignadoA;
	
	CientificosController CientificosController;
	ProyectoController ProyectoController;
	AsignadoAController AsignadoAController;
	
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
		
		miVentanaRegistroCientificos=new VentanaRegistroCientificos();
		miVentanaBuscarCientificos= new VentanaBuscarCientificos();
		miCientificoServ=new CientificosServ();
		CientificosController= new CientificosController();
		
		miVentanaRegistroProyecto= new VentanaRegistroProyecto();
		miVentanaBuscarProyectos= new VentanaBuscarProyecto();
		miProyectoServ= new ProyectoServ();
		ProyectoController= new ProyectoController();
		
		miVentanaRegistroAsignadoA= new VentanaRegistroAsignadoA();
		miVentanaBuscarAsignadoA= new VentanaBuscarAsignadoA();
		miAsignadoAServ= new AsignadoAServ();
		AsignadoAController= new AsignadoAController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(CientificosController);
		miVentanaRegistroCientificos.setCoordinador(CientificosController);
		miVentanaBuscarCientificos.setCoordinador(CientificosController);
		miCientificoServ.setCientificosController(CientificosController);
		
		miVentanaPrincipal.setCoordinador(ProyectoController);
		miVentanaRegistroProyecto.setCoordinador(ProyectoController);
		miVentanaBuscarProyectos.setCoordinador(ProyectoController);
		miProyectoServ.setController(ProyectoController);
		
		miVentanaPrincipal.setCoordinador(AsignadoAController);
		miVentanaRegistroAsignadoA.setCoordinador(AsignadoAController);
		miVentanaBuscarAsignadoA.setCoordinador(AsignadoAController);
		miAsignadoAServ.setController(AsignadoAController);
		
		/*Se establecen relaciones con la clase coordinador*/
		CientificosController.setMiVentanaPrincipal(miVentanaPrincipal);
		CientificosController.setMiVentanaRegistro(miVentanaRegistroCientificos);
		CientificosController.setMiVentanaBuscar(miVentanaBuscarCientificos);
		CientificosController.setcientificosServ(miCientificoServ);
		
		ProyectoController.setMiVentanaPrincipalProyecto(miVentanaPrincipal);
		ProyectoController.setMiVentanaRegistroProyecto(miVentanaRegistroProyecto);
		ProyectoController.setMiVentanaBuscarProyecto(miVentanaBuscarProyectos);
		ProyectoController.setProyectoerv(miProyectoServ);
		
		AsignadoAController.setMiVentanaPrincipalAsignadoA(miVentanaPrincipal);
		AsignadoAController.setMiVentanaRegistroAsignadoA(miVentanaRegistroAsignadoA);
		AsignadoAController.setMiVentanaBuscarAsignadoA(miVentanaBuscarAsignadoA);
		AsignadoAController.setAsignadoAerv(miAsignadoAServ);
				
		miVentanaPrincipal.setVisible(true);
	}
}
