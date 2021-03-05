package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * @author Myroslav Andreykiv
 *
 */

public class AplicacionGrafica  extends JFrame {
	//atributos
	private JPanel contentPane;
	
	private JButton btnCalcular;
	
	private JTextField alturaField;
	private JTextField pesoField;
	private JTextField imcField;
	
	private JLabel altura;
	private JLabel peso;
	private JLabel imc;
	

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
		btnCalcular = new JButton("Calcular IMC");
		btnCalcular.setBounds(50, 80, 150, 30);
		contentPane.add(btnCalcular);
		
		//creamos componentes JTEXTAREA 
		alturaField = new JTextField();
		alturaField.setBounds(115, 40, 150, 30);
		
		pesoField = new JTextField();
		pesoField.setBounds(335, 40, 150, 30);
		
		imcField = new JTextField();
		imcField.setBounds(275, 80, 150, 30);
		//añadimos componentes al contentPane
		contentPane.add(alturaField);
		contentPane.add(pesoField);
		contentPane.add(imcField);
		
		altura = new JLabel("Altura(metros)");
		altura.setBounds(25, 40, 125, 30);
		
		peso = new JLabel("Peso(kg)");
		peso.setBounds(275, 40, 80, 30);
		
		imc = new JLabel("IMC");
		imc.setBounds(240, 80, 150, 30);
		//añadimos componentes al contentPane
		contentPane.add(altura);
		contentPane.add(peso);
		contentPane.add(imc);
		
		//EVENT HANDLERS AND LISTENERS
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					imcField.setText(String.format("%.2f", getResult()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de altura y peso.");
				}
			}
		});
	}
	
	//comprobamos si existen valores de dos campos
	public boolean hasData() {
		boolean hasData = false;	
		if(!alturaField.getText().isEmpty() && !pesoField.getText().isEmpty()) {
			hasData = true;
		}
		return hasData;
	}
	
	//comprobamos si los datos introducidos son integers
	public boolean isInteger() {
		try {
			Double.parseDouble(pesoField.getText());
			Double.parseDouble(alturaField.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//obtenemos el resultado de IMC
	public double getResult() {
		double result = 0;
		result+= Double.parseDouble(pesoField.getText());
		if(Double.parseDouble(alturaField.getText()) != 0.00) {
			//obtenemos el resultado dividiendo el peso entre altura elevado a 2
			result/= Math.pow(Double.parseDouble(alturaField.getText()), 2);
		} else {
			JOptionPane.showMessageDialog(null, "Altura no puede ser 0.");
		}
		return result;
	}
}
