package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controllers.AsignadoAController;
import controllers.CientificosController;
import controllers.ProyectoController;

public class VentanaPrincipal extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private CientificosController cientificosController; //objeto cientificosController que permite la relacion entre esta clase y la clase cientificosController
	private ProyectoController proyectoController; //objeto  proyectoController que permite la relacion entre esta clase y la clase proyectoController
	private AsignadoAController asignadoAController; //objeto AsignadoAController que permite la relacion entre esta clase y la clase cientificosController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton btnRegistrarCientificos, btnBuscarCientificos, btnRegistrarProyecto, btnBuscarProyecto, btnRegistrarAsignadoA, btnBuscarAsignadoA;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnRegistrarCientificos = new JButton();
		btnRegistrarCientificos.setBounds(90, 280, 150, 25);
		btnRegistrarCientificos.setText("Registrar Cientificos");
		
		btnBuscarCientificos = new JButton();
		btnBuscarCientificos.setBounds(240, 280, 150, 25);
		btnBuscarCientificos.setText("Buscar Cientificos");
		
		btnRegistrarProyecto = new JButton();
		btnRegistrarProyecto.setBounds(90, 320, 150, 25);
		btnRegistrarProyecto.setText("Registrar Proyecto");
		
		btnBuscarProyecto = new JButton();
		btnBuscarProyecto.setBounds(240, 320, 150, 25);
		btnBuscarProyecto.setText("Buscar Proyecto");
		
		btnRegistrarAsignadoA = new JButton();
		btnRegistrarAsignadoA.setBounds(90, 360, 170, 25);
		btnRegistrarAsignadoA.setText("Registrar Asignado A");
		
		btnBuscarAsignadoA = new JButton();
		btnBuscarAsignadoA.setBounds(260, 360, 150, 25);
		btnBuscarAsignadoA.setText("Buscar Asignado A");

		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(75, 240, 250, 25);

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de tres tablas: cientificos, asignado_a y proyecto," 
				+ "tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 140);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		btnRegistrarCientificos.addActionListener(this);
		btnBuscarCientificos.addActionListener(this);
		btnRegistrarProyecto.addActionListener(this);
		btnBuscarProyecto.addActionListener(this);
		btnRegistrarAsignadoA.addActionListener(this);
		btnBuscarAsignadoA.addActionListener(this);
		
		
		add(btnRegistrarCientificos);
		add(btnBuscarCientificos);
		add(btnRegistrarProyecto);
		add(btnBuscarProyecto);
		add(btnRegistrarAsignadoA);
		add(btnBuscarAsignadoA);
		add(labelSeleccion);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(480, 550);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	public void setCoordinador(CientificosController cientificosController) {
		this.cientificosController=cientificosController;
	}
	
	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	
	public void setCoordinador(AsignadoAController asignadoAController) {
		this.asignadoAController=asignadoAController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrarCientificos) {
			cientificosController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==btnBuscarCientificos) {
			cientificosController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==btnRegistrarProyecto) {
			proyectoController.mostrarVentanaRegistroProyecto();			
		}
		if (e.getSource()==btnBuscarProyecto) {
			proyectoController.mostrarVentanaConsultaProyecto();			
		}
		if (e.getSource()==btnRegistrarAsignadoA) {
			asignadoAController.mostrarVentanaRegistroAsignadoA();			
		}
		if (e.getSource()==btnBuscarAsignadoA) {
			asignadoAController.mostrarVentanaConsultaAsignadoA();			
		}
	}

}
