package Interface;

/**
**@author: Myroslav Andreykiv
*/


import java.util.InputMismatchException;
import java.util.Scanner;

import customException.MyException;

public class Calculadora {
	
	
	public static void calcular(){
		
		boolean proceder = false;
		
		do {//implementamos el try al principio ya que el usuario puede introducir un valor que no es el que buscamos al escoger las opciones
			try {
				//obtenemos num del usuario
				Scanner sc = new Scanner(System.in);
				//mostramos opciones disponibles por la pantalla
				System.out.println("Elige la operación deseada: +"
						+ "\n1. Suma"
						+ "\n2. Resta "
						+ "\n3. Multiplicación "
						+ "\n4. Potencia "
						+ "\n5. Raíz cuadrada "
						+ "\n6. Raíz cúbica "
						+ "\n7. División");
				
				int queOperacion = sc.nextInt();
				//segun el caso ejecutamos un bloque u otro
				switch(queOperacion) {
					case 1:
						System.out.println("Introduce el valor numérico de a: ");
						double  a = sc.nextInt();
						System.out.println("Introduce el valor numérico de b: ");
						double b = sc.nextInt();
						System.out.println("El resultado de la suma es de: " + (a + b));
						break;
					case 2:
						System.out.println("Introduce el valor numérico de a: ");
						a = sc.nextInt();
						System.out.println("Introduce el valor numérico de b: ");
						b = sc.nextInt();
						System.out.println("El resultado de la resta es de: " + (a - b));
						break;
					case 3:
						System.out.println("Introduce el valor numérico de a: ");
						a = sc.nextInt();
						System.out.println("Introduce el valor numérico de b: ");
						b = sc.nextInt();
						System.out.println("El resultado de la multiplicación es de: ");
						break;
					case 4:
						System.out.println("Introduce el valor numérico de a: ");
						a = sc.nextInt();
						System.out.println("Introduce el valor numérico de b: ");
						b = sc.nextInt();
						System.out.println("El resultado es: " + Math.pow(a, b));
						break;
					case 5:
						System.out.println("Introduce un valor numérico: ");
						a = sc.nextInt();
						//si a es negativo lanzamos excepción
						if(a < 0) {
							throw new MyException("No se puede obtener raiz cuadrada de un número negativo.");
						}
						System.out.println("La raiz cuadrada es "+ Math.sqrt(a));
						break;
						//si que se puede hacer raíz cúbica de un número negativo, no lanzamos excepción
					case 6:
						System.out.println("Introduce un valor numérico: ");
						a = sc.nextInt();
						System.out.println("La raiz cúbica es de: " + Math.cbrt(a));
						break;
					case 7:
						
						System.out.println("Introduce un valor numérico: ");
						a = sc.nextInt();
						System.out.println("Introduce el valor numérico de b: ");
						b = sc.nextInt();
						//si b es negativo lanzamos excepción
						if(b == 0) {
							throw new MyException("No se puede dividir entre 0");
						}
						System.out.println("El resultado de la división es de: "+ (a/b));

				}
				System.out.println("1. Salir del programa "
						+ "\n2. Otra operación");
				int userInt = sc.nextInt();
				
				if(userInt == 1) {
					proceder = true;
				}
				//si el user introduce un valor no numerico lanzamos excepción
			} catch(InputMismatchException e) {
				System.out.println("El carácter introducido no es un número");
			} catch(MyException e) {
				System.out.println(e.getMensajeExplicativo());
			}
		} while(proceder != true);
	}
}
