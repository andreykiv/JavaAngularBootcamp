package views;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class AplicacionGrafica extends JFrame{
	//atributos
	private JPanel contentPane;
	private JLabel label1;
	private JTextArea textarea;
	private JScrollPane scroll;

	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 500, 400);

		setTitle("Ventana oyente");
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
		label1= new JLabel("Eventos: ");
		//colocamos el componente
		label1.setBounds(25, 5, 100, 100);
		contentPane.add(label1);
		
		//creamos el componente JTEXTAREA 
		textarea = new JTextArea("Texto inicial\nVentana activada\nVentana abierta");
		textarea.setBounds(95, 10, 300, 200);
		//para que se baje la palabra al terminar la linea
		textarea.setLineWrap(true);
		//cuando baje la palabra lo haga enteramente
		textarea.setWrapStyleWord(true);
		contentPane.add(textarea);
		
		//añadimos el JScrollPane para poder ver lo que está escrito si hay mucho texto
		//mismas coordenadas que textarea object
		scroll = new JScrollPane(textarea);
		scroll.setBounds(95, 10, 300, 200);
		contentPane.add(scroll);

		//EVENT HANDLERS AND LISTENERS
		KeyListener newKey = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				textarea.append("\nTecla pulsada");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				textarea.append("\nTecla pulsada y soltada");
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				textarea.append("\nTecla soltada");
				
			}
		};
		
		MouseListener newMouse = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textarea.append("\nBoton pulsado y soltado");				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				textarea.append("\nArea entrada");				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textarea.append("\nArea salida");				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				textarea.append("\nBoton pulsado");				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				textarea.append("\nBoton soltado");				
			}

		};

		textarea.addKeyListener(newKey);
		textarea.addMouseListener(newMouse);
	}
}
