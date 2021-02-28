package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculadora extends JFrame{
	//operaciones disponibles de la calculadora: SUMA, RESTA, MULTIPLICACIÓN Y DIVISIÓN
	
	//atributos
	private JPanel contentPane;
	//haremos uso de 6 buttons. 4 para las operaciones, 1 para salir de la apliacion y 1 para mostrar el about.
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMultip;
	private JButton btnDivi;
	private JButton btnExit;
	private JButton btnAbout;
	//haremos uso de 3 textFields. Dos para los operando y uno para mostrar el resultado
	private JTextField operando1;
	private JTextField operando2;
	private JTextField resultado;
	//haremos uso de 4 JLabels para mostrar ciertos textos en la ventana
	private JLabel operandoUno;
	private JLabel operandoDos;
	private JLabel resultadoOperacion;
	private JLabel operacionDisponible;
	
	public Calculadora(){
		//Coordenadas x,y (starting from top left), width y length
		setBounds(400, 200, 450, 300);

		setTitle("Calculadora");
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
		//JLabels
		operandoUno= new JLabel("Operando 1: ");
		operandoUno.setBounds(20, 40, 150, 100);
		operandoDos= new JLabel("Operando 2: ");
		operandoDos.setBounds(150, 40, 150, 100);
		resultadoOperacion= new JLabel("Resultado: ");
		resultadoOperacion.setBounds(280, 40, 150, 100);
		operacionDisponible= new JLabel("Elije operación: ");
		operacionDisponible.setBounds(20, 100, 200, 100);
		//JTextFields
		operando1 = new JTextField();
		operando1.setBounds(20, 100, 100, 30);
		operando2 = new JTextField();
		operando2.setBounds(150, 100, 100, 30);
		resultado = new JTextField();
		resultado.setBounds(280, 100, 100, 30);
		
		//JButtons
		btnSuma = new JButton("+");
		btnSuma.setBounds(150, 140, 50, 23);
		
		btnResta = new JButton("-");
		btnResta.setBounds(210, 140, 50, 23);
		
		btnMultip = new JButton("X");
		btnMultip.setBounds(270, 140, 50, 23);
		
		btnDivi = new JButton("/");
		btnDivi.setBounds(330, 140, 50, 23);
		
		btnAbout = new JButton("About");
		btnAbout.setBounds(150, 10, 89, 23);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(280, 10, 80, 23);


		//AÑADIMOS LOS COMPONENTES AL PANEL
		//añadimos los elemento al panel, sinó no se verá

		contentPane.add(operandoUno);
		contentPane.add(operandoDos);
		contentPane.add(resultadoOperacion);
		contentPane.add(operacionDisponible);
		
		contentPane.add(operando1);
		contentPane.add(operando2);
		contentPane.add(resultado);
		
		contentPane.add(btnSuma);
		contentPane.add(btnResta);
		contentPane.add(btnMultip);
		contentPane.add(btnDivi);
		contentPane.add(btnExit);
		contentPane.add(btnAbout);
		

		//EVENT HANDLERS
		
		//EXIT
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(1);
			}
		});
		//ABOUT
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(null, "© Hackermanz Team V.0.1.");
			}
		});
		//SUMA
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					//asignamos el resultado al campo de resultado mostrando los últimos dos decimales
					resultado.setText(String.format("%.2f", getResultAdd()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de operandos.");
				}
				
			}
		});
		//RESTA
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					//asignamos el resultado al campo de resultado mostrando los últimos dos decimales
					resultado.setText(String.format("%.2f", getResultSubstract()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de operandos.");
				}
				
			}
		});
		//DIVISIÓN
		btnDivi.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					//asignamos el resultado al campo de resultado mostrando los últimos dos decimales
					resultado.setText(String.format("%.2f", getResultDiv()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de operandos.");
				}
				
			}
		});
		//MULTIPLICACIÓN
		btnMultip.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(hasData() && isInteger()) {
					//asignamos el resultado al campo de resultado mostrando los últimos dos decimales
					resultado.setText(String.format("%.2f", getResultMultiply()));
				} else {
					JOptionPane.showMessageDialog(null, "Introduce valores numéricos de operandos.");
				}
				
			}
		});
	}
	
	//comprobamos si existen valores de dos operandos
	public boolean hasData() {
		boolean hasData = false;	
		if(!operando1.getText().isEmpty() && !operando2.getText().isEmpty()) {
			hasData = true;
		}
		return hasData;
	}
	
	//comprobamos si los datos introducidos son integers
	public boolean isInteger() {
		try {
			Double.parseDouble(operando1.getText());
			Double.parseDouble(operando2.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	// obtenemos resultado de suma
	public double getResultAdd() {
		double result = 0;
		result+= Double.parseDouble(operando1.getText());
		result+= Double.parseDouble(operando2.getText());
		return result;
	}
	//resultado de resta
	public double getResultSubstract() {
		double result = 0;
		result+= Double.parseDouble(operando1.getText());
		result-= Double.parseDouble(operando2.getText());
		return result;
	}
	//resultado de división, avisamos que el Operando2 no puede ser 0
	public double getResultDiv() {
		double result = 0;
		result+= Double.parseDouble(operando1.getText());
		if(Double.parseDouble(operando2.getText()) != 0.00) {
			result/= Double.parseDouble(operando2.getText());
		} else {
			JOptionPane.showMessageDialog(null, "Operando2 no puede ser 0.");
		}
		return result;
	}
	//resultado de multiplicación
	public double getResultMultiply() {
		double result = 0;
		result+= Double.parseDouble(operando1.getText());
		result*= Double.parseDouble(operando2.getText());
		return result;
	}
}
