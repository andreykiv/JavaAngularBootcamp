package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;
	private JTextField textfield;
	private JLabel tituloPeli;
	private JLabel peliList;
	private JComboBox jComboBox;
	private JButton btnAdd;

	
	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 700, 400);
		
		setTitle("Peliculas");
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
		tituloPeli= new JLabel("Peliculas: ");
		//colocamos el componente
		tituloPeli.setBounds(300, 40, 175, 100);
		
		//creamos el componente JLABEL 
		peliList= new JLabel("Escribe el titulo de una pelicula: ");
		//colocamos el componente
		peliList.setBounds(20, 40, 225, 100);
		
		//creamos el componente JTEXTFIELD (campo donde el user va a introducir el texto)
		textfield = new JTextField();
		textfield.setBounds(20, 100, 175, 30);
		
		//creamos componentes JCOMBOBOX
		jComboBox = new JComboBox();
		jComboBox.setBounds(300, 100, 175, 30);
		
		jComboBox.addItem("Start Wars");
		jComboBox.addItem("Hackerman Attacks!");
		
		//creamos el componente JBUTTON 
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(222, 255, 89, 23);
		
		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá

		contentPane.add(btnAdd);
		contentPane.add(jComboBox);
		contentPane.add(peliList);
		contentPane.add(tituloPeli);
		contentPane.add(textfield);
		
		//EVENT HANDLERS
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				jComboBox.addItem(textfield.getText());
			}
		});
	}
}


