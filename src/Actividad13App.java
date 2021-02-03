import javax.swing.JOptionPane;

/*Crea una aplicación llamada CalculadoraInversa, nos pedirá 2 operandos (int) y un signo
aritmético (String), según este último se realizara la operación correspondiente. Al final
mostrara el resultado en un cuadro de dialogo.
Los signos aritméticos disponibles son:
+: suma los dos operandos.
-: resta los operandos.
*: multiplica los operandos.
/: divide los operandos, este debe dar un resultado con decimales (double)
^: 1º operando como base y 2º como exponente.
%: módulo, resto de la división entre operando1 y operando2.*/
public class Actividad13App {
	
	public static void CalculadoraInversa() {
		//obtenemos inputs del user
		String num1 = JOptionPane.showInputDialog("Introduce el primer número");
		String num2 = JOptionPane.showInputDialog("Introduce el segundo número");
		String signo = JOptionPane.showInputDialog("Introduce el signo aritmético");
		//parseamos str en num
		int parsedNum1 = Integer.parseInt(num1);
		int parsedNum2 = Integer.parseInt(num2);
		//switch para cada caso
		switch(signo) {
			case "+":
				int result = parsedNum1 + parsedNum2;
				JOptionPane.showMessageDialog(null, "El resultado es: "+ result);
				break;
			case "-":
				result = parsedNum1 - parsedNum2;
				JOptionPane.showMessageDialog(null, "El resultado es: "+ result);
				break;
			case "*":
				result = parsedNum1 * parsedNum2;
				JOptionPane.showMessageDialog(null, "El resultado es: "+ result);
				break;
			case "/":
				double resultDouble =  (double) parsedNum1 / (double) parsedNum2;
				JOptionPane.showMessageDialog(null, "El resultado es: "+ resultDouble);
				break;
			case "^":
				result = (int) Math.pow(parsedNum1, parsedNum2);
				JOptionPane.showMessageDialog(null, "El resultado es: "+ result);
				break;
			case "%":
				result = parsedNum1 % parsedNum2;
				JOptionPane.showMessageDialog(null, "El resultado es: "+ result);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Operador no valido");
		}
	}
	
	public static void main(String[] args) {
		//invocamos el metodo definido previamente
		CalculadoraInversa();
	}

}
