package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.AsignadoAController;
import models.dto.AsignadoA;

public class VentanaRegistroAsignadoA extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private AsignadoAController AsignadoAController; //objeto AsignadoAController que permite la relacion entre esta clase y la clase AsignadoAController
	private JLabel cientificoAsignado, labelTitulo, proyectoAsignado;
	private JTextField textCientificoAsignado, textProyectoAsignado;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroAsignadoA() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ASIGNADO_A");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		cientificoAsignado=new JLabel();
		cientificoAsignado.setText("DNI Cientifico");
		cientificoAsignado.setBounds(20, 120, 80, 25);
		add(cientificoAsignado);
		
		proyectoAsignado=new JLabel();
		proyectoAsignado.setText("ID Proyecto ");
		proyectoAsignado.setBounds(20, 160, 80, 25);
		add(proyectoAsignado);
		
		textCientificoAsignado=new JTextField();
		textCientificoAsignado.setBounds(95, 120, 150, 25);
		add(textCientificoAsignado);
		
		textProyectoAsignado=new JTextField();
		textProyectoAsignado.setBounds(95, 160, 150, 25);
		add(textProyectoAsignado);
		
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
		textCientificoAsignado.setText("");
		textProyectoAsignado.setText("");
	}


	public void setCoordinador(AsignadoAController controllerAsignadoAs) {
		this.AsignadoAController=controllerAsignadoAs;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				AsignadoA miAsignadoA=new AsignadoA();
				miAsignadoA.setCientificoAsignado(textCientificoAsignado.getText());
				miAsignadoA.setProyectoAsignado(textProyectoAsignado.getText());
				
				AsignadoAController.registrarAsignadoA(miAsignadoA);	
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
