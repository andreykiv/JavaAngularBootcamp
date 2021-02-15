package display;
/**
 * @author: Myroslav Andreykiv
 **/

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import models.Bike;
import models.Coche;
import models.Conductor;
import models.Titular;
import models.Truck;
import models.Licencia;


//funciones con el scanner
public class Screen {
	static Scanner sc = new Scanner(System.in);
	
	//crear titular
	public static Titular crearTitular() {
		//importamos el tipo de licencia del conductor (que lo tendra que crear)
		Licencia licenciaTitular = crearLicencia();
		
		System.out.println("Introduce el nombre del titular");
		String nombreTitular = sc.next();
		System.out.println("Introduce el apellido del titular");
		String apellidoTitular = sc.next();
		System.out.println("Introduce la fecha de nacimiento");
		String fechaNacimientoTitular = sc.next();
		
		System.out.println("Dispone de seguro? "
				+ "\n1. Sí "
				+ "\n2. No");
		int siSeguro = sc.nextInt();
		boolean disponeSeguro = false;
		if(siSeguro == 1) {
			disponeSeguro = true;
		}
		
		System.out.println("Dispone de garaje própio? "
				+ "\n1. Sí "
				+ "\n2. No");
		int siGaraje = sc.nextInt();
		boolean disponeGaraje = false;
		if(siSeguro == 1) {
			disponeGaraje = true;
		}
		
		Titular newTitular = new Titular(nombreTitular, apellidoTitular, fechaNacimientoTitular, licenciaTitular, disponeSeguro, disponeGaraje);
		//devolvemos el objeto creado
		return newTitular;
	}
	
	public static Conductor crearConductor() {
		//importamos el tipo de licencia del conductor (que lo tendra que crear)
		Licencia licenciaConductor = crearLicencia();
		
		System.out.println("Introduce el nombre del conductor");
		String nombreConductor = sc.next();
		System.out.println("Introduce el apellido del conductor");
		String apellidoConductor = sc.next();
		System.out.println("Introduce la fecha de nacimiento");
		String fechaNacimientoConductor = sc.next();
		
		Conductor newConductor = new Conductor(nombreConductor, apellidoConductor, fechaNacimientoConductor, licenciaConductor);
		return newConductor;
	}

	//metodo para crear licencia
	public static Licencia crearLicencia() {
		
		System.out.println("Introduce el ID de la Licencia de conducir");
		String idLicencia = sc.next();
		
		System.out.println("Introduce la categoria de la licencia (A, B o C)");
		String tipoLicencia = sc.next();
		
		System.out.println("Introduce el nombre completo del titular de la licencia: ");
		String nombreTitularLicencia = sc.next();
		
		
		String fechaCaducidadLicencia = JOptionPane.showInputDialog("Introduce la fecha de caducidad");
		
		Licencia nuevaLicencia = new Licencia(idLicencia, tipoLicencia, nombreTitularLicencia, fechaCaducidadLicencia);
		return nuevaLicencia;
	}
	//que tipo persona crear
	public static Object crearPersona() {
		Object myObj = null;
		
		System.out.println("Indica que tipo de persona quieres crear: "
				+ "\n 1.Titular "
				+ "\n 2.Conductor");
		int tipoPersona = sc.nextInt();
		if(tipoPersona == 1) {
			myObj = crearTitular();
		} else if(tipoPersona == 2) {
			myObj = crearConductor();
		}
		return myObj;
	}
	
	public static Object crearVehiculo() {
		System.out.println("Indica que tipo de vehiculo quieres crear: "
				+ "\n 1.Coche "
				+ "\n 2.Moto "
				+ "\n 3.Camión");
		Object myObj = null;
		
		int tipoVehiculo = sc.nextInt();
		if(tipoVehiculo == 1) {
			myObj = getInfoCoche();
		} else if(tipoVehiculo == 2) {
			myObj = getInfoBike();
		} else if(tipoVehiculo == 3) {
			myObj = getInfoTruck();
		}
		return myObj;
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
		} else {
			System.out.println("Objeto introducido no válido");
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
			//si el titular no es el conductor
			if(siTitularConductor == 2) {
				//si no será conductor empezar el programa creando un conductor
				empiezaPrograma(crearConductor());
			}
			//si el titular será conductor salir del programa
		//mostrar por pantalla que el vehiculo se ha creado
		System.out.println("Hemos verificado si el titular sera conductor!");
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
		} else {
			System.out.println("Objeto no válido");
		}
		
		//creamos un int para devolver al Main para saber que objeto user quiere crear
		int queOpcion = 0;
		//hacer hasta que el user escoja una opcion
		do {
			System.out.println("Indica que es lo que quieres crear: "
					+ "\n1. Coche "
					+ "\n2. Moto "
					+ "\n3. Camión");
			int opcion = sc.nextInt();
			//comprobamos que la opcion que elige el user está entre las disponibles y si la licencia del titular es la adecuada
			if(opcion == 1 && queLicencia.equalsIgnoreCase("B")) {
				queOpcion = opcion;
			} else if(opcion == 2 && queLicencia.equalsIgnoreCase("A")) {
				queOpcion = opcion;
			} else if(opcion == 3 && queLicencia.equalsIgnoreCase("C")){
				queOpcion = opcion;
			} else {
				System.out.println("La licencia del titular no le permite crear el vehículo seleccionado.");
			}
			
		} while(queOpcion == 0);
		
		return queOpcion;
	}
	
	public static void getRuedasCoche(Coche coche) {
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.next();
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.next();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		//comprobamos el diametro
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//asignamos las caracteristicas del coche 
		coche.setMarcaRuedasTraseras(marcaRuedasTraseras);
		coche.setMarcaRuedasDelanteras(marcaRuedasDelanteras);
		coche.setDiametroRuedasTraseras(diametroRuedasTraseras);
		coche.setDiametroRuedasDelanteras(diametroRuedasDelanteras);
	}
	
	public static void getRuedasBike(Bike bike) {
		System.out.println("Introduce la marca de la rueda trasera: ");
		String marcaRuedasTraseras = sc.next();
		
		System.out.println("Introduce la marca de las rueda delantera: ");
		String marcaRuedasDelanteras= sc.next();
		
		System.out.println("Introduce el diametro de las rueda trasera: ");
		double diametroRuedasTraseras = sc.nextDouble();
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las rueda delantera: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		//asignamos las caracteristicas de la moto
		
		bike.setDiametroRuedaDelantera(diametroRuedasDelanteras);
		bike.setDiametroRuedaTrasera(diametroRuedasDelanteras);
		bike.setMarcaRuedaDelantera(marcaRuedasDelanteras);
		bike.setMarcaRuedaTrasera(marcaRuedasTraseras);
	}
	
	public static void getRuedasTruck(Truck truck) {
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		System.out.println("Introduce la marca de las ruedas traseras: ");
		String marcaRuedasTraseras = sc.next();
		//Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
		
		System.out.println("Introduce la marca de las ruedas delanteras: ");
		String marcaRuedasDelanteras= sc.next();
		
		System.out.println("Introduce el diametro de las ruedas traseras: ");
		double diametroRuedasTraseras = sc.nextDouble();
		//comprobamos el diametro
		comprobarDiametro(diametroRuedasTraseras);
		
		System.out.println("Introduce el diametro de las ruedas delanteras: ");
		double diametroRuedasDelanteras = sc.nextDouble();
		comprobarDiametro(diametroRuedasDelanteras);
		
		//asignamos las caracteristicas del coche 
		truck.setMarcaRuedasTraseras(marcaRuedasTraseras);
		truck.setMarcaRuedasDelanteras(marcaRuedasDelanteras);
		truck.setDiametroRuedasTraseras(diametroRuedasTraseras);
		truck.setDiametroRuedasDelanteras(diametroRuedasDelanteras);
	}
	
	//Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
	public static Coche getInfoCoche() {
		System.out.println("Introduce la matricula del coche: ");
		String matricula = sc.next();
		
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca del coche: ");
		String marca = sc.next();
		
		System.out.println("Introduce el color del coche: ");
		String color = sc.next();
		
		//Crear el cotxe amb les dades anteriors.
		Coche miCoche = new Coche(matricula, marca, color);
		//cogemos mas info del user para el coche
		getRuedasCoche(miCoche);
		
		//asignamos titular al vehiculo
		Titular titularCoche = crearTitular();
		//asignamos al coche creado el titular del coche
		miCoche.setTitular(titularCoche);
		
		//declaramos una variable que monitorize si el titular tiene el permiso adecuado para conducir el coche
		boolean siTiene = false;
		if(titularCoche.getLicencia().getTipo().equalsIgnoreCase("b")) {
			siTiene = true;
		}
		
		//creamos una array de personas donde introducimos el objeto titularCoche
		ArrayList personas = new ArrayList();
		
		//asignamos la persona creada al arrayList de personas
		personas.add(titularCoche);
		
		//asignamos el arrayList de personas al coche creado
		miCoche.setPersonas(personas);
		//creamos una variable que monitorize si terminar la creacion del coche
		boolean siFinalizar = false;
		//bucle hasta que el usuario diga que no quiera crear conductores y que alguien tiene el permiso adecuado
		do {
			System.out.println("Indica si quieres añadir conductor al coche que quieres crear: "
					+ "\n 1.Sí "
					+ "\n 2.No");
			int opcion = sc.nextInt();
			
			if(opcion == 1) {
				//creamos nuevo conductor
				Conductor nuevoConductor = crearConductor();
				//comprobamos si el conductor creado tiene permiso adecuado
				if(nuevoConductor.getLicencia().getTipo().equalsIgnoreCase("b")) {
					//siTieneLicencia adecuada lo añadimos al array de personas
					personas.add(nuevoConductor);
					siTiene = true;
				} else {
					System.out.println("El conductor creado no tiene la licencia para conducir un coche");
				}
				//si elige opcion 2 y tiene licencia adecuada permitir crear el coche
			} else if(opcion == 2) {
				if(siTiene) {
					siFinalizar = true;
				} else {
					System.out.println("No existe conductor ni titular con la licencia del tipo B");
				}
			}
		} while (siFinalizar == false && siTiene == false);
		
		System.out.println("Coche creado!");
		//devolvemos el coche creado
		return miCoche;
	}
	
	public static Bike getInfoBike() {
		System.out.println("Introduce la matricula de la moto: ");
		String matricula = sc.next();
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca de la moto: ");
		String marca = sc.next();
		
		System.out.println("Introduce el color de la moto: ");
		String color = sc.next();
		
		//Crear el cotxe amb les dades anteriors.
		Bike miBike = new Bike(matricula, marca, color);
		//pasamos el resto de parametros a bike
		getRuedasBike(miBike);
		//asignamos titular al vehiculo
		Titular titularBike = crearTitular();
		//asignamos al coche creado el titular de la moto
		miBike.setTitular(titularBike);

		//declaramos una variable que monitorize si el titular tiene el permiso adecuado para conducir la moto
		boolean siTiene = false;
		if(titularBike.getLicencia().getTipo().equalsIgnoreCase("a")) {
			siTiene = true;
		}

		//creamos una array de personas donde introducimos el objeto del titular de la moto
		ArrayList personas = new ArrayList();

		//asignamos la persona creada al arrayList de personas
		personas.add(titularBike);

		//asignamos el arrayList de personas a la moto creada
		miBike.setPersonas(personas);
		//creamos una variable que monitorize si terminar la creacion de la moto
		boolean siFinalizar = false;
		//bucle hasta que el usuario diga que no quiera crear conductores y que alguien tiene el permiso adecuado
		do {
			System.out.println("Indica si quieres añadir conductor a la moto que quieres crear: "
					+ "\n 1.Sí "
					+ "\n 2.No");
			int opcion = sc.nextInt();

			if(opcion == 1) {
				//creamos nuevo conductor
				Conductor nuevoConductor = crearConductor();
				//comprobamos si el conductor creado tiene permiso adecuado
				if(nuevoConductor.getLicencia().getTipo().equalsIgnoreCase("a")) {
					//siTieneLicencia adecuada lo añadimos al array de personas
					personas.add(nuevoConductor);
					siTiene = true;
				} else {
					System.out.println("El conductor creado no tiene la licencia para conducir una moto");
				}
				//si elige opcion 2 y tiene licencia adecuada permitir crear la moto
			} else if(opcion == 2) {
				if(siTiene) {
					siFinalizar = true;
				} else {
					System.out.println("No existe conductor ni titular con la licencia del tipo A");
				}
			}
		} while (siFinalizar == false && siTiene == false);

		System.out.println("Moto creada!");
		//devolvemos la moto creada
		return miBike;
	}
	
	public static Truck getInfoTruck() {
		System.out.println("Introduce la matricula del camión: ");
		String matricula = sc.next();
		
		//llamamos a la funcion para comprobar la matricula
		comprobarMatricula(matricula);
		
		System.out.println("Introduce la marca del camión: ");
		String marca = sc.next();
		
		System.out.println("Introduce el color del camión: ");
		String color = sc.next();
		
		//Crear el cotxe amb les dades anteriors.
		Truck miTruck = new Truck(matricula, marca, color);
		//asignamos el resto de los atributos
		getRuedasTruck(miTruck);
		//asignamos titular al vehiculo
		Titular titularTruck = crearTitular();
		//asignamos al coche creado el titular del camión
		miTruck.setTitular(titularTruck);

		//declaramos una variable que monitorize si el titular tiene el permiso adecuado para conducir el camión
		boolean siTiene = false;
		if(titularTruck.getLicencia().getTipo().equalsIgnoreCase("c")) {
			siTiene = true;
		}

		//creamos una array de personas donde introducimos el objeto del titular del camión
		ArrayList personas = new ArrayList();

		//asignamos la persona creada al arrayList de personas
		personas.add(titularTruck);

		//asignamos el arrayList de personas a la camión creado
		miTruck.setPersonas(personas);
		//creamos una variable que monitorize si terminar la creacion de la camión
		boolean siFinalizar = false;
		//bucle hasta que el usuario diga que no quiera crear conductores y que alguien tiene el permiso adecuado
		do {
			System.out.println("Indica si quieres añadir conductor al camión que quieres crear: "
					+ "\n 1.Sí "
					+ "\n 2.No");
			int opcion = sc.nextInt();

			if(opcion == 1) {
				//creamos nuevo conductor
				Conductor nuevoConductor = crearConductor();
				//comprobamos si el conductor creado tiene permiso adecuado
				if(nuevoConductor.getLicencia().getTipo().equalsIgnoreCase("c")) {
					//siTieneLicencia adecuada lo añadimos al array de personas
					personas.add(nuevoConductor);
					siTiene = true;
				} else {
					System.out.println("El conductor creado no tiene la licencia para conducir un camión");
				}
				//si elige opcion 2 y tiene licencia adecuada permitir crear el camión
			} else if(opcion == 2) {
				if(siTiene) {
					siFinalizar = true;
				} else {
					System.out.println("No existe conductor ni titular con la licencia del tipo C");
				}
			}
		} while (siFinalizar == false && siTiene == false);

		System.out.println("Camión creado!");
		//devolvemos el camión
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
				matricula = sc.next();
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
