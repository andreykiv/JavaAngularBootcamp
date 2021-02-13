package actividad4;

public class MainApp {

	public static void main(String[] args) {
		//(-b±√((b^2)-(4*a*c)))/(2*a)
		Raices miRaiz = new Raices(7, 15, 6);
		
		miRaiz.calcular();
	}

}
