package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;
	private JRadioButton opcion1;
	private JRadioButton opcion2;
	private JRadioButton opcion3;
	private JCheckBox especialidad1;
	private JCheckBox especialidad2;
	private JCheckBox especialidad3;
	private JButton btnFinish;
	private JLabel pregunta1;
	private JLabel pregunta2;
	private JLabel pregunta3;
	private JSlider slider;
	
	public AplicacionGrafica() {
		//Coordenadas x,y (esquina de arriba a la izquierda), width y length
		setBounds(400, 200, 700, 400);
		
		setTitle("Encuesta");
//		//para que se acabe el programa cuando cerramos la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		//para hacer visible la ventana
		setVisible(true);
		
//		creamos el panel
		contentPane = new JPanel();
//		//indicamos su diseño
		contentPane.setLayout(null);
		//asignamos el panel a la ventana
		setContentPane(contentPane);
		
		//CREACIÓN COMPONENTES
		//creamos el componente JLABEL
		pregunta1= new JLabel("Elije tu especialidad: ");
		//colocamos el componente
		pregunta1.setBounds(300, 40, 175, 100);
		
		//creamos el componente JLABEL 
		pregunta2= new JLabel("Elije un sistema operativo: ");
		//colocamos el componente
		pregunta2.setBounds(20, 40, 175, 100);
		
		//creamos el componente JLABEL 
		pregunta3= new JLabel("Selecciona horas dedicadas en el ordenador: ");
		//colocamos el componente
		pregunta3.setBounds(180, 200, 300, 50);
		
		//creamos el componente JRADIOBUTTON (campo donde el user va a introducir el texto)
		opcion1 = new JRadioButton("Windows", false);
		opcion1.setBounds(20, 100, 175, 30);
		
		opcion2 = new JRadioButton("Linux", false);
		opcion2.setBounds(20, 120, 175, 30);
		
		opcion3 = new JRadioButton("Mac", false);
		opcion3.setBounds(20, 140, 175, 30);
		
		//añadimos los componentes de radioButton dentro de un mismo grupo
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(opcion1);
		bgroup.add(opcion2);
		bgroup.add(opcion3);
		
		//creamos componentes JCheckBox
		especialidad1 = new JCheckBox("Programación", false);
		especialidad1.setBounds(300, 100, 175, 30);
		
		especialidad2 = new JCheckBox("Diseño gráfico", false);
		especialidad2.setBounds(300, 120, 175, 30);
		
		especialidad3 = new JCheckBox("Administración", false);
		especialidad3.setBounds(300, 140, 175, 30);
				
		//creamos el componente JBUTTON 
		btnFinish = new JButton("Finalizar");
		btnFinish.setBounds(222, 300, 89, 23);

		//creamos el componente JSLIDER
		slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		
		slider.setBounds(180, 240, 200, 50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
	    slider.setMajorTickSpacing(10);
	    slider.setMinorTickSpacing(0);

		
		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá
		//preguntas
		contentPane.add(pregunta1);
		contentPane.add(pregunta2);
		contentPane.add(pregunta3);
		
		//opciones radio button
		contentPane.add(opcion1);
		contentPane.add(opcion2);
		contentPane.add(opcion3);
		//opciones especialidad
		contentPane.add(especialidad1);
		contentPane.add(especialidad2);
		contentPane.add(especialidad3);
		
		contentPane.add(slider);
		//opciones checkbox
		contentPane.add(btnFinish);
		
		//EVENT HANDLER
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema operativo elejido: "+ getOpcion() + ". Total horas dedicadas: " + getHoras() + 
						". Especialidades seleccionadas: " + getEspecialidad());
			}
		});
	}
	
	
	//valor de bulletPoint
	public String getOpcion() {
		String opcion = "";
		if(opcion1.isSelected()) {
			opcion = opcion1.getText();
		} else if (opcion2.isSelected()) {
			opcion = opcion2.getText();
		} else if(opcion3.isSelected()) {
			opcion = opcion3.getText();
		}
		return opcion;
	}
	//obtenemos las horas seleccionadas
	public int getHoras() {
		int horas = 0;
		horas = slider.getValue();
		
		return horas;
	}
	
	//obtenemos las especialidades seleccionadas
	public String getEspecialidad() {
		String especialidad = "";
		if(especialidad1.isSelected()) {
			especialidad += especialidad1.getText() + " ";
		}
		if(especialidad2.isSelected()) {
			especialidad += especialidad2.getText() + " ";
		}
		if(especialidad3.isSelected()) {
			especialidad += especialidad3.getText() + " ";
		}
		
		return especialidad;
	}
}


