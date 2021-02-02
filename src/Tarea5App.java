
public class Tarea5App {

	public static void main(String[] args) {
		int A = 5;
		int B = 19;
		int C = 14;
		int D = 11;
		
		System.out.println("Valores iniciales: ");
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		System.out.println("C: " + C);
		System.out.println("D: " + D);
		
		B = C;
		C = A;
		A = D;
		D = B;
		
		System.out.println("Valores posteriores: ");
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		System.out.println("C: " + C);
		System.out.println("D: " + D);
	}

}
