package display;
/**
 * @author: Myroslav Andreykiv
 **/

import java.util.Scanner;

import models.Bike;
import models.Coche;
import models.Conductor;
import models.Titular;
import models.Truck;
import models.Licencia;

//funciones con el scanner
public class Screen {
	static Scanner sc = new Scanner(System.in);
	
	public static Conductor crearConductor() {
		//importamos el tipo de licencia del conductor (que lo tendra que crear)
		Licencia licenciaConductor = crearLicencia();
		
		System.out.println("Introduce el nombre del conductor");
		String nombreConductor = sc.nextLine();
		System.out.println("Introduce el apellido del conductor");
		String apellidoConductor = sc.nextLine();
		System.out.println("Introduce la fecha de nacimiento");
		String fechaNacimientoConductor = sc.nextLine();
		
		Conductor newConductor = new Conductor(nombreConductor, apellidoConductor, fechaNacimientoConductor, licenciaConductor);
		return newConductor;
	}

	//metodo para crear licencia
	public static Licencia crearLicencia() {
		System.out.println("Introduce el ID de la Licencia de conducir");
		String idLicencia = sc.nextLine();
		System.out.println("Introduce la categoria de la licencia (A, B o C)");
		String tipoLicencia = sc.nextLine();
		System.out.println("Introduce el nombre completo del titular de la licencia: ");
		String nombreTitularLicencia = sc.nextLine();
		System.out.println("Introduce la fecha de caducidad: ");
		String fechaCaducidadLicencia = sc.nextLine();
		
		Licencia nuevaLicencia = new Licencia(idLicencia, tipoLicencia, nombreTitularLicencia, fechaCaducidadLicencia);
		return nuevaLicencia;
	}
	
	//metodo que empieza el programa
	public static void empiezaPrograma(Object conductorOTitular) {
		
		if(queVehiculoCrear(conductorOTitular) == 1) {
			Coche newCoche= getInfoCoche();
			siTitularSeraConductor(conductorOTitular);
		} else if(queVehiculoCrear(conductorOTitular) == 2) {
			Bike newBike = getInfoBike();
			siTitularSeraConductor(conductorOTitular);
			//Modifica l’exercici per afegir camió com a vehicle disponible.
		} else if(queVehiculoCrear(conductorOTitular) == 3) {
			Truck newTruck = getInfoTruck();
			siTitularSeraConductor(conductorOTitular);
		}
	}
	
	//pregunta si el titular será conductor
	public static void siTitularSeraConductor(Object conductorOTitular) {
		//solo ejecutarse si el objeto que le pasamos es Titular (no tiene sentido preguntarle al conductor si será conductor)
		if(conductorOTitular instanceof Titular) {
			System.out.println("El titular será conductor: "
					+ "\n1. Sí "
					+ "\n2. No");
			int siTitularConductor = sc.nextInt();
			//si el titular será conductor salir del programa
			if(siTitularConductor == 2) {
				//si no será conductor empezar el programa creando un conductor
				empiezaPrograma(crearConductor());
			}
		//mostrar por pantalla que el vehiculo se ha creado
		System.out.println("Vehiculo creado!");
		}
	}
	
	//Preguntar a l’usuari si vol crear un cotxe o una moto o un camió.
	public static int queVehiculoCrear(Object conductorOTitular) {
		
		String queLicencia = "";
		
		//comprobamos que tipo de licencia tiene el titular
		if(conductorOTitular instanceof Titular) {
			queLicencia = ((Titular) conductorOTitular).getLicencia().getTipo();
		} else if(conductorOTitular instanceof Conductor) {
			queLicencia = ((Conductor) conductorOTitular).getLicencia().getTipo();
		}
		
		//creamos un int para devolver al Main para saber que objeto user quiere crear
		int queOpcion = 0;
		//hacer hasta que el user no ponga una opcion
		do {
			System.out.println("Indica que es lo que quieres crear: "
					+ "\n1. Coche "
					+ "\n2. Moto "
					+ "\n3. Camión");
			int opcion = sc.nextInt();
			//comprobamos que la opcion que elige el user está entre las disponibles y si la licencia del titular es la adecuada
			if(opcion == 1 && queLicencia.equalsIgnoreCase("B")) {
				queOpcion = 1;
			} else if(opcion == 2 && queLicencia.equalsIgnoreCase("A")) {
				queOpcion = 2;
			} else if(opcion == 3 && queLicencia.equalsIgnoreCase("C")){
				queOpcion = 3;
			} else {
				System.out.println("La licencia del titular no le permite crear el vehículo seleccionado.");
			}
			
		} while(queOpcion == 0);
		
		return queOpcion;
	}
	//Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
	public static Coche getInfoCoche() {
		System.out.println("Introduce la matricula del coche: ");
		String matricula = sc.nextLine();
		
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca del coche: ");
		String marca = sc.nextLine();
		
		System.out.println("Introduce el color del coche: ");
		String color = sc.nextLine();
		
		//Crear el cotxe amb les dades anteriors.
		Coche miCoche = new Coche(matricula, marca, color);
		
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.nextLine();
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		//comprobamos el diametro
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//asignamos las caracteristicas del coche 
		miCoche.setMarcaRuedasTraseras(marcaRuedasTraseras);
		miCoche.setMarcaRuedasDelanteras(marcaRuedasDelanteras);
		miCoche.setDiametroRuedasTraseras(diametroRuedasTraseras);
		miCoche.setDiametroRuedasDelanteras(diametroRuedasDelanteras);
	
		return miCoche;
	}
	
	public static Bike getInfoBike() {
		System.out.println("Introduce la matricula de la moto: ");
		String matricula = sc.nextLine();
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca de la moto: ");
		String marca = sc.nextLine();
		
		System.out.println("Introduce el color de la moto: ");
		String color = sc.nextLine();
		
		//Crear el cotxe amb les dades anteriors.
		Bike miBike = new Bike(matricula, marca, color);
		
		System.out.println("Introduce la marca de la rueda trasera: ");
		String marcaRuedasTraseras = sc.nextLine();
		
		System.out.println("Introduce la marca de las rueda delantera: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las rueda trasera: ");
		double diametroRuedasTraseras = sc.nextDouble();
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las rueda delantera: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		//asignamos las caracteristicas de la moto
		
		miBike.setDiametroRuedaDelantera(diametroRuedasDelanteras);
		miBike.setDiametroRuedaTrasera(diametroRuedasDelanteras);
		miBike.setMarcaRuedaDelantera(marca);
		miBike.setMarcaRuedaTrasera(marca);
		
		return miBike;
	}
	
	public static Truck getInfoTruck() {
		System.out.println("Introduce la matricula del camión: ");
		String matricula = sc.nextLine();
		
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca del camión: ");
		String marca = sc.nextLine();
		
		System.out.println("Introduce el color del camión: ");
		String color = sc.nextLine();
		
		//Crear el cotxe amb les dades anteriors.
		Truck miTruck = new Truck(matricula, marca, color);
		
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.nextLine();
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.nextLine();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		//comprobamos el diametro
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//asignamos las caracteristicas del coche 
		miTruck.setMarcaRuedasTraseras(marcaRuedasTraseras);
		miTruck.setMarcaRuedasDelanteras(marcaRuedasDelanteras);
		miTruck.setDiametroRuedasTraseras(diametroRuedasTraseras);
		miTruck.setDiametroRuedasDelanteras(diametroRuedasDelanteras);
	
		return miTruck;
	}
	
	//comprobamos que la matricula esté compuesta por 4 numeros y 2 o 3 letras
	public static void comprobarMatricula(String matricula) {
		boolean correcto = false;
		//regex que incluya 4 primeros numeros y 2 o 3 letras
		String regexCondition = "[0-9]{4}[A-Za-z]{2,3}";
		do {
			if(matricula.matches(regexCondition)) {
				correcto = true;
			} else {
				System.out.println("Tiene que ser compuesta por 4 digitos y 2 o 3 letras: ");
				matricula = sc.nextLine();
			}
		} while(correcto != true);
	}
	
	public static void comprobarDiametro(double diametro) {
		boolean correcto = false;
		do {//comprobamos si se cumplen las condiciones
			
				if(diametro < 0.4 || diametro > 4) {
					System.out.println("Diametro ruedas tiene que ser inferior a 4 y superior a 0.4. Intenta de nuevo: ");
					diametro = sc.nextDouble();
				} else {
					correcto = true;
				}
		} while (correcto != true);

	}
}
