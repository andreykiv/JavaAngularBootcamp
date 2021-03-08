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
import models.service.ProyectoServ;

public class VentanaBuscarProyecto extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private ProyectoController ProyectoController; //objeto ProyectoController que permite la relacion entre esta clase y la clase ProyectoController
	private JLabel labelTitulo;
	private JTextField textIdProyecto,textNombre, textHoras;
	private JLabel idProyecto,nombre,horas;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarProyecto() {

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
		labelTitulo.setText("ADMINISTRAR PROYECTO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		idProyecto=new JLabel();
		idProyecto.setText("ID");
		idProyecto.setBounds(20, 80, 80, 25);
		add(idProyecto);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);
		
		horas=new JLabel();
		horas.setText("Horas");
		horas.setBounds(290, 120, 80, 25);
		add(horas);
		
		textIdProyecto=new JTextField();
		textIdProyecto.setBounds(80, 80, 80, 25);
		add(textIdProyecto);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(340, 120, 80, 25);
		add(textHoras);
		
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

	public void setCoordinador(ProyectoController ProyectoController) {
		this.ProyectoController=ProyectoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				//guardamos la la info escrita por user en el objeto de Proyecto
				Proyecto miProyecto=new Proyecto();
				miProyecto.setIdProyecto(textIdProyecto.getText());
				miProyecto.setNombreProyecto(textNombre.getText());
				miProyecto.setHoras(Integer.parseInt(textHoras.getText()));
				//pasamos el objeto miProyecto al controller 
				ProyectoController.modificarProyecto(miProyecto);
				
				if (ProyectoServ.modificarproyecto==true) {
					habilita(false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Proyecto miProyecto=ProyectoController.buscarProyecto(textIdProyecto.getText());
			if (miProyecto!=null)
			{
				muestraProyecto(miProyecto);
				habilita(true, false, false, true, false, true, true);
			}
			else if(ProyectoServ.consultarproyecto==true){
				JOptionPane.showMessageDialog(null, "El Proyecto no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{	//si el campo no está vacio
			if (!textIdProyecto.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar al Proyecto?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					ProyectoController.eliminarProyecto(textIdProyecto.getText());
					//al eliminar el Proyecto limpiamos los componentes
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero ID del Proyecto", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}


	/**
	 * permite cargar los datos del Proyectoe consultado
	 * @param miPersona
	 */
	private void muestraProyecto(Proyecto miProyecto) {
		//añadimos los quotes en los campos donde obtenemos numeros para que se convierta a string
		textIdProyecto.setText(miProyecto.getIdProyecto());
		textNombre.setText(miProyecto.getNombreProyecto());
		textHoras.setText(miProyecto.getHoras()+"");
		habilita(true, false, false, false, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textIdProyecto.setText("");
		textNombre.setText("");
		textHoras.setText("");
		habilita(true, false, false, true, false, false, false);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param idProyecto
	 * @param nombreProyecto
	 * @param horas
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean idProyecto, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textIdProyecto.setEditable(idProyecto);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}

}
