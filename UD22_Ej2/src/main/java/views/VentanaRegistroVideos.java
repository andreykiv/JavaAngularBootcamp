package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.VideosController;
import models.dto.Videos;

public class VentanaRegistroVideos extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private VideosController videoController; //objeto videoController que permite la relacion entre esta clase y la clase VideoController
	private JLabel idVideo, labelTitulo, titulo, director,Cli_id;
	private JTextField textIdVideo, textTitle,textDirector,textCli_id;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroVideos() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE VIDEO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		idVideo=new JLabel();
		idVideo.setText("Id Videos");
		idVideo.setBounds(20, 120, 80, 25);
		add(idVideo);
		
		titulo=new JLabel();
		titulo.setText("Título");
		titulo.setBounds(255, 160, 80, 25);
		add(titulo);
		
		director=new JLabel();
		director.setText("Director");
		director.setBounds(255, 120, 80, 25);
		add(director);
		
		Cli_id=new JLabel();
		Cli_id.setText("Cli_id");
		Cli_id.setBounds(20, 160, 80, 25);
		add(Cli_id);
		
		textIdVideo=new JTextField();
		textIdVideo.setBounds(80, 120, 150, 25);
		add(textIdVideo);
		
		textTitle=new JTextField();
		textTitle.setBounds(310, 160, 150, 25);
		add(textTitle);
		
		textDirector=new JTextField();
		textDirector.setBounds(310, 120, 150, 25);
		add(textDirector);
		
		textCli_id=new JTextField();
		textCli_id.setBounds(80, 160, 150, 25);
		add(textCli_id);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		add(botonCancelar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	private void limpiar() 
	{
		textIdVideo.setText("");
		textTitle.setText("");
		textDirector.setText("");
		textCli_id.setText("");
	}


	public void setCoordinador(VideosController controllerVideos) {
		this.videoController=controllerVideos;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Videos miVideo=new Videos();
				miVideo.setIdVideo(Integer.parseInt(textIdVideo.getText()));
				miVideo.setTitleVideo(textTitle.getText());
				miVideo.setDirectorVideo(textDirector.getText());
				miVideo.setCli_idVideo(Integer.parseInt(textCli_id.getText()));
				videoController.registrarVideo(miVideo);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
}
