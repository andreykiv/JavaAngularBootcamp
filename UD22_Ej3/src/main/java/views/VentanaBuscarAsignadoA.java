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
import models.service.AsignadoAServ;

public class VentanaBuscarAsignadoA extends JFrame implements ActionListener{
private static final long serialVersionUID = 1L;
	
	private AsignadoAController AsignadoAController; //objeto AsignadoAController que permite la relacion entre esta clase y la clase AsignadoAController
	private JTextField textCientificoAsignado, textProyectoAsignado;
	private JLabel cientificoAsignado, proyectoAsignado, labelTitulo;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarAsignadoA() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(220, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR ASIGNADO_A");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cientificoAsignado=new JLabel();
		cientificoAsignado.setText("DNI Cientifico");
		cientificoAsignado.setBounds(20, 80, 140, 25);
		add(cientificoAsignado);
		
		proyectoAsignado=new JLabel();
		proyectoAsignado.setText("ID Proyecto");
		proyectoAsignado.setBounds(20, 120, 80, 25);
		add(proyectoAsignado);
		
		textCientificoAsignado=new JTextField();
		textCientificoAsignado.setBounds(140, 80, 80, 25);
		add(textCientificoAsignado);
		
		textProyectoAsignado=new JTextField();
		textProyectoAsignado.setBounds(140, 120, 150, 25);
		add(textProyectoAsignado);
		
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

	public void setCoordinador(AsignadoAController controllerAsignadoA) {
		this.AsignadoAController=controllerAsignadoA;
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

				AsignadoAController.modificarAsignadoA(miAsignadoA);
				
				if (AsignadoAServ.modificarAsignadoA==true) {
					habilita(false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(e2);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			AsignadoA miAsignadoA=AsignadoAController.buscarAsignadoA(textCientificoAsignado.getText(), textProyectoAsignado.getText());
			if (miAsignadoA!=null)
			{
				muestraAsignadoA(miAsignadoA);
				habilita(false, false, true, false, true, true);
			}
			else if(AsignadoAServ.consultaAsignadoA==true){
				JOptionPane.showMessageDialog(null, "Proyecto o cientifico no existe en la BBDD","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCientificoAsignado.getText().equals("") || !textProyectoAsignado.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la AsignadoA?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					AsignadoAController.eliminarAsignadoA(textCientificoAsignado.getText(), textProyectoAsignado.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese el DNI del cientifico y ID del proyecto", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la AsignadoA consultada
	 * @param miAsignadoA
	 */
	private void muestraAsignadoA(AsignadoA miAsignadoA) {	
		textCientificoAsignado.setText(miAsignadoA.getCientificoAsignado());
		textProyectoAsignado.setText(miAsignadoA.getProyectoAsignado());
		habilita(true, true, true, false, false, false);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCientificoAsignado.setText("");
		textProyectoAsignado.setText("");
		habilita(true, true, true, false, false, false);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param cientificoAsignado
	 * @param proyectoAsignado
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean cientificoAsignado, boolean proyectoAsignado, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCientificoAsignado.setEditable(cientificoAsignado);
		textProyectoAsignado.setEditable(proyectoAsignado);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
