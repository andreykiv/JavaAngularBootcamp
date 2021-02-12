/*Escribe un programa, utilizando para ello el paradigma de POO, que juegue
con el usuario a adivinar un número. Debe cumplir los siguientes
requerimientos:
1. El ordenador debe generar un número entre 1 y 500, y el usuario tiene
que intentar adivinarlo.
2. Cada vez que el usuario introduce un valor, el ordenador debe decirle al
usuario si el número que tiene que adivinar es mayor o menor que el que
ha introducido el usuario.
3. Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el
número de veces que el usuario ha intentado adivinar el número.
4. Si el usuario introduce algo que no es un número, debe indicarlo en
pantalla, y contarlo como un intento indicando que no ha conseguido
reconocer la entrada lanzando la excepción InputMismatchException.*/

/**
*@author: Myroslav Andreykiv
**/

package MAIN;
import java.util.InputMismatchException;
//importamos random
import java.util.Random;
import java.util.Scanner;

import MODELS.Ordenador;

public class MainApp {

	public static void main(String[] args) {
		//creamos un objeto de la clase Ordenador que ejecuta el codigo que queremos
		Ordenador miPC = new Ordenador();
	}

}
