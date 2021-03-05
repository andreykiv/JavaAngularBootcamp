package view;


import javax.swing.*;


public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;

	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 700, 400);

		setTitle("Ejercicio1");
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

		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá

		//EVENT HANDLERS

	}
}
