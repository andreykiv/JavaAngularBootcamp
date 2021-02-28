package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Myroslav Andreykiv
 *
 */
public class AplicacionGrafica  extends JFrame {
	
	// PANEL DE APLICACIÓN:
	//atributos
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSaludar;
	private JLabel etiqueta;
	
	//CONSTRUCTOR POR DEFECTO
	public AplicacionGrafica() {
		
		//Coordenadas x,y (esquina de arriba a la izquierda), width y length
		setBounds(400, 200, 450, 400);
		
		setTitle("Saludador");
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
		etiqueta= new JLabel("Escribe un nombre para saludar: ");
		//colocamos el componente
		etiqueta.setBounds(20, 9, 250, 150);
		
		//creamos el componente JTEXTFIELD (campo donde el user va a introducir el texto)
		textField = new JTextField();
		textField.setBounds(260, 70, 100, 30);
		
		//creamos el componente JBUTTON 
		btnSaludar = new JButton("Saludar");
		btnSaludar.setBounds(165, 133, 89, 23);

		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá
		
		contentPane.add(etiqueta);
		contentPane.add(textField);
		contentPane.add(btnSaludar);
		
		//EVENT HANDLERS
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hola "+ textField.getText());
			}
		});
	}
}
