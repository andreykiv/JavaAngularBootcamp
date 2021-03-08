package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.CientificosController;
import models.dto.Cientificos;

public class VentanaRegistroCientificos extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private CientificosController CientificosController; //objeto CientificosController que permite la relacion entre esta clase y la clase CientificosController
	private JLabel labelTitulo;
	private JTextField textDniCientificos,textNomApels;
	private JLabel dniCientificos,nomApels;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */

	public VentanaRegistroCientificos() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE Cientificos");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		dniCientificos=new JLabel();
		dniCientificos.setText("DNI");
		dniCientificos.setBounds(20, 80, 80, 25);
		add(dniCientificos);
		
		nomApels=new JLabel();
		nomApels.setText("Nombre");
		nomApels.setBounds(20, 120, 80, 25);
		add(nomApels);
		
		textDniCientificos=new JTextField();
		textDniCientificos.setBounds(80, 80, 80, 25);
		add(textDniCientificos);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(80, 120, 190, 25);
		add(textNomApels);
		
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
		textDniCientificos.setText("");
		textNomApels.setText("");
	}


	public void setCoordinador(CientificosController CientificosController) {
		this.CientificosController=CientificosController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientificos miCientificos=new Cientificos();
				miCientificos.setDniCientifico(textDniCientificos.getText());
				miCientificos.setNomApelsCientifico(textNomApels.getText());
				//pasamos al controller el objeto miCientificos
				CientificosController.registrarCientificos(miCientificos);	
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
