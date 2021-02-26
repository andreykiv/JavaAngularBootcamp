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
		DbFunctions.createDB("Almacenes");
		
		//creamos la tabla DEPARTAMENTOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableAlmacenes("Almacenes", "almacenes");
		
		//insertamos registros String db, String table_name, int codigo, String lugar, int capacidad
		DbFunctions.insertDataAlmacenes("Almacenes", "almacenes", 1, "San Francisco", 5);
		DbFunctions.insertDataAlmacenes("Almacenes", "almacenes", 2, "New York", 11);
		DbFunctions.insertDataAlmacenes("Almacenes", "almacenes", 3, "Beijing", 21);
		DbFunctions.insertDataAlmacenes("Almacenes", "almacenes", 4, "Kyiv", 4);
		DbFunctions.insertDataAlmacenes("Almacenes", "almacenes", 5, "Barcelona", 9);
		
		//creamos la tabla EMPLEADOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableCajas("Almacenes", "cajas");
		//insertamos registros String db, String table_name, String numReferencia, String contenido, int valor, int almacen
		DbFunctions.insertDataCajas("Almacenes", "cajas", "acsd1", "Scissors", 522, 2);
		DbFunctions.insertDataCajas("Almacenes", "cajas", "acsd2", "Paper", 522, 3);
		DbFunctions.insertDataCajas("Almacenes", "cajas", "acsd3", "Scissors", 522, 4);
		DbFunctions.insertDataCajas("Almacenes", "cajas", "acsd4", "Scissors", 522, 4);
		DbFunctions.insertDataCajas("Almacenes", "cajas", "acsd5", "Rock", 522, 5);
		//mostramos la info obtenida
		DbFunctions.getValuesCajas("Empleados", "empleados");
		DbFunctions.getValuesAlmacenes("Empleados", "departamentos");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
