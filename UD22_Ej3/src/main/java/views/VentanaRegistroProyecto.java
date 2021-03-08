package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.ProyectoController;
import models.dto.Proyecto;

public class VentanaRegistroProyecto extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private ProyectoController ProyectoController; //objeto ProyectoController que permite la relacion entre esta clase y la clase ProyectoController
	private JLabel idProyecto, labelTitulo, nombreProyecto, horasProyecto;
	private JTextField textIdProyecto, textNombre,textHoras;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroProyecto() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PROYECTO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		idProyecto=new JLabel();
		idProyecto.setText("ID");
		idProyecto.setBounds(20, 120, 80, 25);
		add(idProyecto);
		
		nombreProyecto=new JLabel();
		nombreProyecto.setText("Nombre");
		nombreProyecto.setBounds(255, 120, 80, 25);
		add(nombreProyecto);
		
		horasProyecto=new JLabel();
		horasProyecto.setText("Horas");
		horasProyecto.setBounds(20, 160, 80, 25);
		add(horasProyecto);
		
		textIdProyecto=new JTextField();
		textIdProyecto.setBounds(80, 120, 150, 25);
		add(textIdProyecto);
		
		textNombre=new JTextField();
		textNombre.setBounds(310, 120, 150, 25);
		add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(80, 160, 150, 25);
		add(textHoras);
		
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
		textIdProyecto.setText("");
		textNombre.setText("");
		textHoras.setText("");
	}


	public void setCoordinador(ProyectoController controllerProyectos) {
		this.ProyectoController=controllerProyectos;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Proyecto miProyecto=new Proyecto();
				miProyecto.setIdProyecto(textIdProyecto.getText());
				miProyecto.setNombreProyecto(textNombre.getText());
				miProyecto.setHoras(Integer.parseInt(textHoras.getText()));
				ProyectoController.registrarProyecto(miProyecto);	
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
