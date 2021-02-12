package MAIN;

/**
**@author: Myroslav Andreykiv
*/

import java.util.Random;

import customException.MyException;
import verifiers.ParNoPar;

public class MainApp {
	
	static Random rnd = new Random();
	
	public static void main(String[] args) {
		//declaramos randon num
		int myRand = rnd.nextInt(1000);
		//llamamos al verifier y le pasamos random
		ParNoPar.esPar(myRand);
	}
}
