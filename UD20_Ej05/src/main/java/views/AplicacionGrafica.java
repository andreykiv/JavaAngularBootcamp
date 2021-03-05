package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class AplicacionGrafica extends JFrame{
	//atributos
	private JPanel contentPane;
	private JButton btnClean;
	private JTextArea textarea;
	private JScrollPane scroll;

	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 500, 400);

		setTitle("Todos los eventos del ratón");
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
		//creamos el componente JBUTTON
		btnClean = new JButton("Limpiar");
		btnClean.setBounds(200, 5, 100, 30);
		contentPane.add(btnClean);
		
		//creamos el componente JTEXTAREA 
		textarea = new JTextArea("Texto inicial");
		textarea.setBounds(95, 150, 400, 100);


		//añadimos el JScrollPane para poder ver lo que está escrito si hay mucho texto
		//mismas coordenadas que textarea object
		scroll = new JScrollPane(textarea);
		scroll.setBounds(95, 150, 300, 100);
		contentPane.add(scroll);

		//EVENT HANDLERS AND LISTENERS
		MouseListener newMouse = new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				textarea.append("Boton pulsado y soltado ");				
			}

			public void mouseEntered(MouseEvent e) {
				textarea.append("Componente entrado ");				
			}


			public void mouseExited(MouseEvent e) {
				textarea.append("Componente salido ");				
			}


			public void mousePressed(MouseEvent e) {
				textarea.append("Boton pulsado ");				
			}


			public void mouseReleased(MouseEvent e) {
				textarea.append("Boton soltado ");				
			}

		};
		
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				textarea.setText("");
			}
		});

		textarea.addMouseListener(newMouse);
	}
}
