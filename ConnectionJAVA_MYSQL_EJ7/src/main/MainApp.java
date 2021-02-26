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
		DbFunctions.createDB("cientificos");
		
		//creamos la tabla Cientificos pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableCientificos("cientificos", "cientificos");
		
		//insertamos registros String db, String table_name, String dni, String nomApels
		DbFunctions.insertDataCientificos("cientificos", "cientificos", "x3434341", "Michael Scott");
		DbFunctions.insertDataCientificos("cientificos", "cientificos", "x3434342", "Michael Flott");
		DbFunctions.insertDataCientificos("cientificos", "cientificos", "x3434343", "Michael Glott");
		DbFunctions.insertDataCientificos("cientificos", "cientificos", "x3434344", "Michael Rlott");
		DbFunctions.insertDataCientificos("cientificos", "cientificos", "x3434345", "Michael Slott");

		
		//creamos la tabla Proyecto pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableProyecto("cientificos", "proyecto");
		//insertamos registros String db, String table_name, String id, String nombre, int horas
		DbFunctions.insertDataProyecto("cientificos", "proyecto", "asd1", "Proyecto1", 5);
		DbFunctions.insertDataProyecto("cientificos", "proyecto", "asd2", "Proyecto2", 7);
		DbFunctions.insertDataProyecto("cientificos", "proyecto", "asd3", "Proyecto3", 2);
		DbFunctions.insertDataProyecto("cientificos", "proyecto", "asd4", "Proyecto4", 4);
		DbFunctions.insertDataProyecto("cientificos", "proyecto", "asd5", "Proyecto5", 11);

		//creamos la tabla AsignadoA pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableAsignadoA("cientificos", "asignadoA");
		
		//insertamos registros String db, String table_name, String cientifico, String proyecto
		DbFunctions.insertDataAsignadoA("cientificos", "asignadoA", "x3434341", "asd1");
		DbFunctions.insertDataAsignadoA("cientificos", "asignadoA", "x3434342", "asd2");
		DbFunctions.insertDataAsignadoA("cientificos", "asignadoA", "x3434341", "asd3");
		DbFunctions.insertDataAsignadoA("cientificos", "asignadoA", "x3434341", "asd4");
		DbFunctions.insertDataAsignadoA("cientificos", "asignadoA", "x3434344", "asd5");
		
		//mostramos la info obtenida
		
		DbFunctions.getValuesCientificos("cientificos", "cientificos");
		DbFunctions.getValuesProyecto("cientificos", "proyecto");
		DbFunctions.getValuesAsignadoA("cientificos", "asignadoA");
		
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
