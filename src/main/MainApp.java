package main;

import models.Manager;

public class MainApp {

	public static void main(String[] args) {
		Manager someManag = new Manager();
		someManag.setSalarioMensual(100);
		System.out.println(someManag.getSalarioMensual());

	}

}
