package main;


import java.time.LocalDateTime;
import java.time.ZoneId;

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
		DbFunctions.createDB("investigadores");
		
		//creamos la tabla facultad pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableFacultad("investigadores", "facultad");
		//insertamos registros String db, String table_name, int codigo, String nombre
		DbFunctions.insertDataFacultad("investigadores", "facultad", 1, "Medicina");
		DbFunctions.insertDataFacultad("investigadores", "facultad", 2, "História");
		DbFunctions.insertDataFacultad("investigadores", "facultad", 3, "Geografia");
		DbFunctions.insertDataFacultad("investigadores", "facultad", 4, "Economía");
		DbFunctions.insertDataFacultad("investigadores", "facultad", 5, "Matemáticas");
		
		//creamos la tabla investigadores pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableInvestigadores("investigadores", "investigadores");
		//insertamos registros String db, String table_name, String dni, String nomApels, int facultad
		DbFunctions.insertDataInvestigadores("investigadores", "investigadores", "x3434341", "Investigador A", 2);
		DbFunctions.insertDataInvestigadores("investigadores", "investigadores", "x3434342", "Investigador B", 1);
		DbFunctions.insertDataInvestigadores("investigadores", "investigadores", "x3434343", "Investigador C", 2);
		DbFunctions.insertDataInvestigadores("investigadores", "investigadores", "x3434344", "Investigador D", 4);
		DbFunctions.insertDataInvestigadores("investigadores", "investigadores", "x3434345", "Investigador E", 5);
		
		//creamos la tabla equipos pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableEquipos("investigadores", "equipos");
		
		//insertamos registros String db, String table_name, String numSerie, String nombre, int facultad
		DbFunctions.insertDataEquipos("investigadores", "equipos", "abv1", "Equipo A", 2);
		DbFunctions.insertDataEquipos("investigadores", "equipos", "abv2", "Equipo B", 3);
		DbFunctions.insertDataEquipos("investigadores", "equipos", "abv3", "Equipo C", 5);
		DbFunctions.insertDataEquipos("investigadores", "equipos", "abv4", "Equipo D", 5);
		DbFunctions.insertDataEquipos("investigadores", "equipos", "abv5", "Equipo E", 1);
		
		//creamos la tabla reserva pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableReserva("investigadores", "reserva");
		
		//insertamos registros String db, String table_name, String dni, String numSerie, LocalDateTime comienzo, LocalDateTime fin 
		// (añadimos zonas donde la hora excede la hora actual respecto la hora del servidor)
		DbFunctions.insertDataReserva("investigadores", "reserva", "x3434341", "abv1", LocalDateTime.now(), LocalDateTime.now(ZoneId.of("Australia/Queensland")));
		DbFunctions.insertDataReserva("investigadores", "reserva", "x3434342", "abv2", LocalDateTime.now(), LocalDateTime.now(ZoneId.of("Africa/Cairo")));
		DbFunctions.insertDataReserva("investigadores", "reserva", "x3434343", "abv3", LocalDateTime.now(), LocalDateTime.now(ZoneId.of("PRC")));
		DbFunctions.insertDataReserva("investigadores", "reserva", "x3434344", "abv4", LocalDateTime.now(), LocalDateTime.now(ZoneId.of("Singapore")));
		DbFunctions.insertDataReserva("investigadores", "reserva", "x3434345", "abv5", LocalDateTime.now(), LocalDateTime.now(ZoneId.of("Europe/Kiev")));
			
		//mostramos la info obtenida
		DbFunctions.getValuesInvestigadores("investigadores", "investigadores");
		DbFunctions.getValuesFacultad("investigadores", "facultad");
		DbFunctions.getValuesEquipos("investigadores", "equipos");
		DbFunctions.getValuesReserva("investigadores", "reserva");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
