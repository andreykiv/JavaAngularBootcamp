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
import models.service.ClienteServ;

public class VentanaBuscar extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private ClienteController clienteController; //objeto clienteController que permite la relacion entre esta clase y la clase clienteController
	private JLabel labelTitulo;
	private JTextField textIdCliente,textNombre,textApellido,textDireccion,textDni;
	private JLabel idCliente,nombre,apellido,direccion,dni;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

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
		labelTitulo.setText("ADMINISTRAR CLIENTES");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		idCliente=new JLabel();
		idCliente.setText("Id Cliente");
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
		direccion.setBounds(20, 160, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(290, 120, 80, 25);
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
		textDireccion.setBounds(80, 160, 190, 25);
		add(textDireccion);
		
		textDni=new JTextField();
		textDni.setBounds(340, 120, 80, 25);
		add(textDni);
		
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
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

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
				//guardamos la la info escrita por user en el objeto de Cliente
				Cliente miCliente=new Cliente();
				miCliente.setIdCliente(Integer.parseInt(textIdCliente.getText()));
				miCliente.setNombre(textNombre.getText());
				miCliente.setApellido(textApellido.getText());
				miCliente.setDireccion(textDireccion.getText());
				miCliente.setDni(Integer.parseInt(textDni.getText()));
				
				//pasamos el objeto miCliente al controller 
				clienteController.modificarCliente(miCliente);
				
				if (ClienteServ.modificarCliente==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cliente miCliente=clienteController.buscarCliente(textIdCliente.getText());
			if (miCliente!=null)
			{
				muestraCliente(miCliente);
			}
			else if(ClienteServ.consultaCliente==true){
				JOptionPane.showMessageDialog(null, "El cliente no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{	//si el campo no está vacio
			if (!textIdCliente.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar al Cliente?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					clienteController.eliminarCliente(textIdCliente.getText());
					//al eliminar el cliente limpiamos los componentes
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero ID del cliente", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}


	/**
	 * permite cargar los datos del clientee consultado
	 * @param miPersona
	 */
	private void muestraCliente(Cliente miCliente) {
		//añadimos los quotes en los campos donde obtenemos numeros para que se convierta a string
		textNombre.setText(miCliente.getNombre());
		textApellido.setText(miCliente.getApellido()+"");
		textDireccion.setText(miCliente.getDireccion()+"");
		textDni.setText(miCliente.getDni()+"");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textIdCliente.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDni.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param idCliente
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param dni
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean idCliente, boolean nombre, boolean apellido, boolean direccion, 
			boolean dni, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textIdCliente.setEditable(idCliente);
		textNombre.setEditable(nombre);
		textApellido.setEditable(apellido);
		textDireccion.setEditable(direccion);
		textDni.setEditable(dni);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}

}
