package verifiers;

/**
**@author: Myroslav Andreykiv
*/

import customException.MyException;

public class ParNoPar {
	public static void esPar(int random) {
		try {
			System.out.println("Generando número aleatorio...");
			if(random %2 == 0) {
				System.out.println("El número aleatorio es: " + random);
				throw new MyException("Es par");
			} else {
				System.out.println("El número aleatorio es: " + random);
				throw new MyException("Es impar");
			}
		} catch(MyException e) {
			System.out.println(e.getMensajeExplicativo());
		}
	}
}
