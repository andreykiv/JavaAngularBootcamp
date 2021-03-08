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
import models.service.CientificosServ;

public class VentanaBuscarCientificos extends JFrame implements ActionListener{
	
	
private static final long serialVersionUID = 1L;
	
	private CientificosController CientificosController; //objeto CientificosController que permite la relacion entre esta clase y la clase CientificosController
	private JLabel labelTitulo;
	private JTextField textDniCientifico, textNomApels;
	private JLabel dniCientificos, nomApels;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarCientificos() {

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
		labelTitulo.setText("ADMINISTRAR CIENTIFICOS");
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
		
		textDniCientifico=new JTextField();
		textDniCientifico.setBounds(80, 80, 80, 25);
		add(textDniCientifico);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(80, 120, 150, 25);
		add(textNomApels);
		
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

	public void setCoordinador(CientificosController controllerCientificos) {
		this.CientificosController=controllerCientificos;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			if(!textDniCientifico.getText().equals("") && !textNomApels.getText().equals("")){
				Cientificos miCientificos=new Cientificos();
				miCientificos.setDniCientifico(textDniCientifico.getText());
				miCientificos.setNomApelsCientifico(textNomApels.getText());

				CientificosController.modificarCientificos(miCientificos);
				
				if (CientificosServ.modificarCientificos==true) {
					habilita(false, false, true, false, true, true);	
				}
			}

		}
		
		if (e.getSource()==botonBuscar)
		{
			
			Cientificos miCientificos=CientificosController.buscarCientificos(textDniCientifico.getText());
			if (miCientificos!=null)
			{
				muestraCientificos(miCientificos);
				habilita(false, false, true, false, true, true);
			}
			else if(CientificosServ.consultaCientificos==true){
				JOptionPane.showMessageDialog(null, "Cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textDniCientifico.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar al cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					CientificosController.eliminarCientificos(textDniCientifico.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un DNI", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la Cientificos consultada
	 * @param miCientificos
	 */
	private void muestraCientificos(Cientificos miCientificos) {	
		textDniCientifico.setText(miCientificos.getDniCientifico());
		textNomApels.setText(miCientificos.getNomApelsCientifico());
		habilita(true, false, true, false, false, false);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textDniCientifico.setText("");
		textNomApels.setText("");
		habilita(true, false, true, false, false, false);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dniCientificos
	 * @param nomApelsCientificos
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean dniCientificos, boolean nomApelsCientificos, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDniCientifico.setEditable(dniCientificos);
		textNomApels.setEditable(nomApelsCientificos);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
