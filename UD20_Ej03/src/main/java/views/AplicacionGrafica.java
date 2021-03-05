package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;
	private JLabel label1;
	private JLabel label2;
	private JButton btn1;
	private JButton btn2;
	//numero de veces que los botones se pulsan (por defecto 0)
	private int numBoton1Pulsado = 0;
	private int numBoton2Pulsado = 0;


	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 400, 400);

		setTitle("Ventana con más interacción");
		//para que se acabe el programa cuando cerramos la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//para hacer visible la ventana
		setVisible(true);

		//creamos el panel
		contentPane = new JPanel();
		//indicamos su diseño
		contentPane.setLayout(null);
		//asignamos el panel a la ventana
		setContentPane(contentPane);

		//CREACIÓN COMPONENTES
		//creamos el componente JLABEL
		label1= new JLabel("Boton 1: ");
		//colocamos el componente
		label1.setBounds(25, 5, 175, 100);
		
		label2= new JLabel("Boton 2: ");
		//colocamos el componente
		label2.setBounds(200, 5, 175, 100);

		//creamos el componente JBUTTON 
		btn1 = new JButton("Boton 1");
		btn1.setBounds(25, 75, 80, 30);
		
		btn2 = new JButton("Boton 2");
		btn2.setBounds(200, 75, 80, 30);

		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá

		contentPane.add(btn1);
		contentPane.add(btn2);
		
		contentPane.add(label1);
		contentPane.add(label2);


		//EVENT HANDLERS
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//el atributo se suma cada vez que se pulsa el boton
				numBoton1Pulsado+=1;
				label1.setText("Boton 1: " + numBoton1Pulsado + " veces");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//el atributo se suma cada vez que se pulsa el boton
				numBoton2Pulsado+=1;
				label2.setText("Boton 2: " + numBoton2Pulsado + " veces");
			}
		});
	}
}
