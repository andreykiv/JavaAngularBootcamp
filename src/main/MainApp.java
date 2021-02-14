package main;

import employee.Junior;
import employee.Mid;
import employee.Senior;
import models.Boss;
import models.Manager;
import models.Volunteer;

public class MainApp {

	public static void main(String[] args) {
		Manager newMan = new Manager(8000);
		Boss newBos = new Boss(10000);
		Junior newJun = new Junior(1111);
		Mid newMid = new Mid(1111);
		Senior newSenior = new Senior(1500);
		Volunteer newVol = new Volunteer(1233, 500);
		System.out.println(newBos.getSalarioBrutoMensual());

		System.out.println("El bonus anual del Boss es de: " + newBos.getBonus());

	
		
	}

}
