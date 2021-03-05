package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AplicacionGrafica extends JFrame {
	//atributos
	private JPanel contentPane;
	//conversion euros a pesetas
	final double rateEurosVsPesetas = 166.386;

	private JButton eurosAPtas, ptasAEuros, borrar;

	private JTextField cantidadAConvertir, resultado;

	private JLabel lblCantidad, lblResultado;


	public AplicacionGrafica() {
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 600, 400);

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
		eurosAPtas = new JButton("Euros a ptas");
		eurosAPtas.setBounds(75, 80, 130, 30);
		contentPane.add(eurosAPtas);
		
		ptasAEuros = new JButton("Ptas a euros");
		ptasAEuros.setBounds(225, 80, 130, 30);
		ptasAEuros.add(eurosAPtas);
		
		borrar = new JButton("Borrar");
		borrar.setBounds(375, 80, 130, 30);
		
		contentPane.add(eurosAPtas);
		contentPane.add(ptasAEuros);
		contentPane.add(borrar);
		//creamos componentes JTEXTAREA 
		cantidadAConvertir = new JTextField();
		cantidadAConvertir.setBounds(130, 40, 150, 30);

		resultado = new JTextField();
		resultado.setBounds(400, 40, 150, 30);
		resultado.setEditable(false);
	
		//añadimos componentes al contentPane
		contentPane.add(cantidadAConvertir);
		contentPane.add(resultado);
		
		//añadimos los JLabels
		lblCantidad = new JLabel("Cantidad a convertir");
		lblCantidad.setBounds(10, 40, 130, 30); 
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(325, 40, 130, 30); 
		
		contentPane.add(lblCantidad);
		contentPane.add(lblResultado);

		//EVENT HANDLERS AND LISTENERS
		eurosAPtas.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					resultado.setText(String.format("%.3f", getResultPesetas()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de la moneda.");
				}
			}
		});
		
		ptasAEuros.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					resultado.setText(String.format("%.3f", getResultEuros()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de la moneda.");
				}
			}
		});
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
					resultado.setText("");
					cantidadAConvertir.setText("");
			}
		});
	}

	//comprobamos si existen valores de dos campos
	public boolean hasData() {
		boolean hasData = false;	
		if(!cantidadAConvertir.getText().isEmpty()) {
			hasData = true;
		}
		return hasData;
	}

	//comprobamos si los datos introducidos son integers
	public boolean isInteger() {
		try {
			Double.parseDouble(cantidadAConvertir.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//obtenemos conversion de euros
	public double getResultEuros() {
		double result = 0;
		result+= Double.parseDouble(cantidadAConvertir.getText());
		result/=rateEurosVsPesetas;
		return result;
	}
	
	//obtenemos conversion de pesetas
	public double getResultPesetas() {
		double result = 0;
		result+= Double.parseDouble(cantidadAConvertir.getText());
		result*=rateEurosVsPesetas;
		return result;
	}
}
