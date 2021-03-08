package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controllers.ClienteController;
import controllers.VideosController;

public class VentanaPrincipal extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private ClienteController clienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private VideosController videosController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton btnRegistrarClientes, btnBuscarClientes, btnRegistrarVideo, btnBuscarVideo;
	

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

		btnRegistrarClientes = new JButton();
		btnRegistrarClientes.setBounds(90, 280, 150, 25);
		btnRegistrarClientes.setText("Registrar Clientes");
		
		btnBuscarClientes = new JButton();
		btnBuscarClientes.setBounds(240, 280, 150, 25);
		btnBuscarClientes.setText("Buscar Clientes");
		
		btnRegistrarVideo = new JButton();
		btnRegistrarVideo.setBounds(90, 320, 150, 25);
		btnRegistrarVideo.setText("Registrar Videos");
		
		btnBuscarVideo = new JButton();
		btnBuscarVideo.setBounds(240, 320, 150, 25);
		btnBuscarVideo.setText("Buscar Videos");

		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(75, 240, 250, 25);

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cliente." +
				"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

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

		btnRegistrarClientes.addActionListener(this);
		btnBuscarClientes.addActionListener(this);
		btnBuscarVideo.addActionListener(this);
		btnRegistrarVideo.addActionListener(this);
		
		add(btnRegistrarClientes);
		add(btnBuscarClientes);
		add(btnBuscarVideo);
		add(btnRegistrarVideo);
		add(labelSeleccion);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(480, 550);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	public void setCoordinador(ClienteController clienteController) {
		this.clienteController=clienteController;
	}
	
	public void setCoordinador(VideosController videoController) {
		this.videosController=videoController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrarClientes) {
			clienteController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==btnBuscarClientes) {
			clienteController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==btnRegistrarVideo) {
			videosController.mostrarVentanaRegistroVideos();			
		}
		if (e.getSource()==btnBuscarVideo) {
			videosController.mostrarVentanaConsultaVideos();			
		}
	}

}
