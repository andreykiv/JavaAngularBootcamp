package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.ClienteController;
import models.dto.Cliente;

public class VentanaRegistroCliente extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController; //objeto clienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textIdCliente,textNombre,textApellido,textDireccion,textDni;
	private JLabel idCliente,nombre,apellido,direccion,dni;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */

	public VentanaRegistroCliente() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CLIENTES");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		idCliente=new JLabel();
		idCliente.setText("idCliente");
		idCliente.setBounds(20, 80, 80, 25);
		add(idCliente);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(290, 160, 80, 25);
		add(apellido);
		
		direccion=new JLabel();
		direccion.setText("Direccion");
		direccion.setBounds(290, 120, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(20, 160, 80, 25);
		add(dni);
		
		textIdCliente=new JTextField();
		textIdCliente.setBounds(80, 80, 80, 25);
		add(textIdCliente);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textApellido=new JTextField();
		textApellido.setBounds(340, 160, 80, 25);
		add(textApellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(340, 120, 80, 25);
		add(textDireccion);
		
		textDni=new JTextField();
		textDni.setBounds(80, 160, 190, 25);
		add(textDni);
		
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
		textIdCliente.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDni.setText("");
	}


	public void setCoordinador(ClienteController clienteController) {
		this.clienteController=clienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cliente miCliente=new Cliente();
				miCliente.setIdCliente(Integer.parseInt(textIdCliente.getText()));
				miCliente.setNombre(textNombre.getText());
				miCliente.setApellido(textApellido.getText());
				miCliente.setDireccion(textDireccion.getText());
				miCliente.setDni(Integer.parseInt(textDni.getText()));
				//pasamos al controller el objeto micLiente
				clienteController.registrarCliente(miCliente);	
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
