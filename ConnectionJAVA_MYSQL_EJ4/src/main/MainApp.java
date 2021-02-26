package main;

import dbFunc.DbFunctions;


/**
 * @author Myroslav Andreykiv
 *
 */

//Crea un programa JAVA que cree la siguiente base de datos. Añade al menos 5 registros validos por cada tabla.
public class MainApp {

	public static void main(String[] args) {
		//abrimos conexión con el servidor
		DbFunctions.openConnection();
		
		//creamos la base de datos
		DbFunctions.createDB("peliculasYSalas");
		
		//creamos la tabla DEPARTAMENTOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTablePeliculas("peliculasYSalas", "peliculas");
		
		//insertamos registros String db, String table_name, int codigo, String nombre, int calificacionEdad
		DbFunctions.insertDataPeliculas("peliculasYSalas", "peliculas", 1, "XMEN", 12);
		DbFunctions.insertDataPeliculas("peliculasYSalas", "peliculas", 2, "Robin Hood", 18);
		DbFunctions.insertDataPeliculas("peliculasYSalas", "peliculas", 3, "Hackerman", 16);
		DbFunctions.insertDataPeliculas("peliculasYSalas", "peliculas", 4, "Hackerwoman", 16);
		DbFunctions.insertDataPeliculas("peliculasYSalas", "peliculas", 5, "Batman", 12);
		
		//creamos la tabla EMPLEADOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableSalas("peliculasYSalas", "salas");
		//insertamos registros String db, String table_name, int codigo, String nombre, int pelicula
		DbFunctions.insertDataSalas("peliculasYSalas", "salas", 1, "Earth", 2);
		DbFunctions.insertDataSalas("peliculasYSalas", "salas", 2, "Water", 3);
		DbFunctions.insertDataSalas("peliculasYSalas", "salas", 3, "Air", 1);
		DbFunctions.insertDataSalas("peliculasYSalas", "salas", 4, "Fire", 4);
		DbFunctions.insertDataSalas("peliculasYSalas", "salas", 5, "Balance", 5);
		//mostramos la info obtenida
		
		DbFunctions.getValuesPeliculas("peliculasYSalas", "peliculas");
		DbFunctions.getValuesSalas("peliculasYSalas", "salas");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
