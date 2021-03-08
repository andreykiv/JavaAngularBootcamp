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
import models.service.VideosServ;

public class VentanaBuscarVideos extends JFrame implements ActionListener{
	
	
private static final long serialVersionUID = 1L;
	
	private VideosController videoController; //objeto videoController que permite la relacion entre esta clase y la clase videoController
	private JLabel labelTitulo;
	private JTextField textId, textTitle, textCli_id, textDirector;
	private JLabel idVideo, Title, Cli_id, Director;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarVideos() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR VIDEOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		idVideo=new JLabel();
		idVideo.setText("Codigo");
		idVideo.setBounds(20, 80, 80, 25);
		add(idVideo);
		
		Title=new JLabel();
		Title.setText("Title");
		Title.setBounds(20, 120, 80, 25);
		add(Title);
		
		Director=new JLabel();
		Director.setText("Director");
		Director.setBounds(20, 160, 80, 25);
		add(Director);
		
		Cli_id=new JLabel();
		Cli_id.setText("Cli_id");
		Cli_id.setBounds(255, 120, 80, 25);
		add(Cli_id);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		add(textId);
		
		textTitle=new JTextField();
		textTitle.setBounds(80, 120, 150, 25);
		add(textTitle);
		
		textDirector=new JTextField();
		textDirector.setBounds(80, 160, 150, 25);
		add(textDirector);
		
		textCli_id=new JTextField();
		textCli_id.setBounds(310, 120, 150, 25);
		add(textCli_id);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		add(botonCancelar);
		add(botonBuscar);
		add(botonModificar);
		add(botonEliminar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
				
		setSize(490, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

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
				miVideo.setIdVideo(Integer.parseInt(textId.getText()));
				miVideo.setTitleVideo(textTitle.getText());
				miVideo.setDirectorVideo(textDirector.getText());
				miVideo.setCli_idVideo(Integer.parseInt(textCli_id.getText()));
				

				videoController.modificarVideo(miVideo);
				
				if (VideosServ.modificarVideo==true) {
					habilita(false, true, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(e2);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Videos miVideo=videoController.buscarVideo(textId.getText());
			if (miVideo!=null)
			{
				muestraVideo(miVideo);
			}
			else if(VideosServ.consultarVideo==true){
				JOptionPane.showMessageDialog(null, "La video no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Video?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					videoController.eliminarVideo(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la video consultada
	 * @param miVideo
	 */
	private void muestraVideo(Videos miVideo) {	
		textId.setText(miVideo.getIdVideo()+"");
		textTitle.setText(miVideo.getTitleVideo());
		textCli_id.setText(miVideo.getCli_idVideo()+"");
		textDirector.setText(miVideo.getDirectorVideo());
		habilita(true, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textTitle.setText("");
		textCli_id.setText("");
		textDirector.setText("");
		habilita(true, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param idVideo
	 * @param título
	 * @param director
	 * @param cli_idVideo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean idVideo, boolean title, boolean director, boolean cli_id, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(idVideo);
		textTitle.setEditable(title);
		textCli_id.setEditable(cli_id);
		textDirector.setEditable(director);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
