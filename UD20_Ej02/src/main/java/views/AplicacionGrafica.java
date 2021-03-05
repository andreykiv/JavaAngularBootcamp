package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;
	private JLabel queBoton;
	private JButton btn1;
	private JButton btn2;


	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 400, 400);

		setTitle("Ventana con interaccion");
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
		queBoton= new JLabel("Has Pulsado: ");
		//colocamos el componente
		queBoton.setBounds(20, 40, 175, 100);

		//creamos el componente JBUTTON 
		btn1 = new JButton("Boton 1");
		btn1.setBounds(170, 40, 80, 30);
		
		btn2 = new JButton("Boton 2");
		btn2.setBounds(270, 40, 80, 30);

		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá

		contentPane.add(btn1);

		contentPane.add(btn2);
		contentPane.add(queBoton);


		//EVENT HANDLERS
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				queBoton.setText("Has Pulsado: Boton 1");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				queBoton.setText("Has Pulsado: Boton 2");
			}
		});
	}
}
