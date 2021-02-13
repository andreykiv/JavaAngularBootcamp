/*Implementa los anteriores métodos en las clases Videojuego y Serie. Ahora crea
una aplicación ejecutable y realiza lo siguiente:
• Crea dos arrays, uno de Series y otro de Videojuegos, de 5 posiciones cada
uno.
• Crea un objeto en cada posición del array, con los valores que desees, puedes
usar distintos constructores.
• Entrega algunos Videojuegos y Series con el método entregar().
• Cuenta cuantos Series y Videojuegos hay entregados. Al contarlos,
devuélvelos.
• Por último, indica el Videojuego tiene más horas estimadas y la serie con mas
temporadas. Muestralos en pantalla con toda su información (usa el método
toString()).
*/
package actividad2;

public class MainApp {
	
	public static void cuantosEntregados(Serie[] misSeries, Videojuego[] misJuegos) {
		int seriesEntregadas = 0;
		int juegosEntregados = 0;
		
		for(int i = 0; i< 5; i++) {
			if(misSeries[i].entregado) {
				seriesEntregadas+= 1;
			}
			if(misJuegos[i].entregado) {
				juegosEntregados += 1;
			}
		}
		
		System.out.println("Series entregadas: " + seriesEntregadas);
		System.out.println("Juegos entregados: " + juegosEntregados);
	}
	
	public static void videoJuegoConMasHoras(Videojuego[] misJuegos) {
		int posicionMasHoras = 0;
		int maxHrsEstimadas = 0;
		for(int i = 0; i < misJuegos.length; i++) {
			//para saber la posicion del juego dentro de la array
			if(misJuegos[i].getHorasEstimadas() > maxHrsEstimadas) {
				//asignar posicionJuegoMasHoras si sus horasEstimadas son mayores a las horas de otros juegos
				posicionMasHoras = i;
				maxHrsEstimadas = misJuegos[i].getHorasEstimadas();
			}
		}
		System.out.println(misJuegos[posicionMasHoras].toString());
	}
	
	public static void serieConMasTemporadas(Serie[] misSeries) {
		int posicionMasTemporadas = 0;
		int maxTemporadas = 0;
		for(int i = 0; i < misSeries.length; i++) {
			//para saber la posicion del juego dentro de la array
			if(misSeries[i].getNumeroTemporadas() > maxTemporadas) {
				//asignar posicionJuegoMasHoras si sus horasEstimadas son mayores a las horas de otros juegos
				posicionMasTemporadas = i;
				maxTemporadas = misSeries[i].getNumeroTemporadas();
			}
		}
		System.out.println(misSeries[posicionMasTemporadas].toString());
	}

	public static void main(String[] args) {
		//creamos dos arrays con 5 posiciones cada una
		Serie misSeries[] = new Serie[5];
		Videojuego misJuegos[] = new Videojuego[5];
		
		//Crea un objeto en cada posición del array, con los valores que desees, puedes usar distintos constructores.
		misSeries[0] = new Serie("Breaking Bad", 6, "Drama", "Vince Gilligan");
		misSeries[1] = new Serie("Breaking Good", 2, "Comedy", "Vince Cooligan");
		misSeries[2] = new Serie("Breaking Ok", 4, "Comedy", "Vince Mooligan");
		misSeries[3] = new Serie("Breaking Terribly", 7, "Action", "Vince Hooligan");
		misSeries[4] = new Serie("Breaking Awesome", 6, "Drama", "Vince Bloodligan");
		
		//Crea un objeto en cada posición del array, con los valores que desees, puedes usar distintos constructores.
		misJuegos[0] = new Videojuego("Rimworld", 90, "Indie", "Paradox");
		misJuegos[1] = new Videojuego("The Long Dark", 55, "Survival", "Paradox");
		misJuegos[2] = new Videojuego("bla bla bla", 24, "Indie", "Paradox");
		misJuegos[3] = new Videojuego("Rimworld", 235, "Indie", "Paradox");
		misJuegos[4] = new Videojuego("WOW", 234, "RPG", "Blizzard");
		
		//Entrega algunos Videojuegos y Series con el método entregar().
		misSeries[0].entregar();
		misSeries[1].entregar();
		
		misJuegos[0].entregar();
		misJuegos[2].entregar();
		misJuegos[4].entregar();
		
		//llamamos al metodo definido previamente y le pasamos como parametro los arrays misSeries y misJuegos
		cuantosEntregados(misSeries, misJuegos);
		//lamamos al metodo definido previamente y le pasamos cono parametro el array de misJuegos
		videoJuegoConMasHoras(misJuegos);
		//lamamos al metodo definido previamente y le pasamos cono parametro el array de misSeries
		serieConMasTemporadas(misSeries);
	}

}
