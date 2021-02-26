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
		DbFunctions.createDB("directores");
		
		//creamos la tabla DESPACHOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableDespachos("directores", "despachos");
		
		//insertamos registros String db, String table_name, int numero, int capacidad
		DbFunctions.insertDataDespachos("directores", "despachos", 1, 12);
		DbFunctions.insertDataDespachos("directores", "despachos", 2, 5);
		DbFunctions.insertDataDespachos("directores", "despachos", 3, 6);
		DbFunctions.insertDataDespachos("directores", "despachos", 4, 4);
		DbFunctions.insertDataDespachos("directores", "despachos", 5, 7);

		
		//creamos la tabla DIRECTORES pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableDirectores("directores", "directores");
		//insertamos registros String db, String table_name, String dni, String nomApels, String DNIjefe, int despacho
		DbFunctions.insertDataDirectores("directores", "directores", "x3434901", "Michael Scott", "x3434901", 4);
		DbFunctions.insertDataDirectores("directores", "directores", "x3434902", "Jim Harpert", "x3434901", 2);
		DbFunctions.insertDataDirectores("directores", "directores", "x3434903", "Dwigth Schrude", "x3434901", 1);
		DbFunctions.insertDataDirectores("directores", "directores", "x3434904", "Meredith", "x3434903", 3);
		DbFunctions.insertDataDirectores("directores", "directores", "x3434905", "Pam", "x3434903", 5);

		//mostramos la info obtenida
		
		DbFunctions.getValuesDespachos("directores", "despachos");
		DbFunctions.getValuesDirectores("directores", "directores");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
