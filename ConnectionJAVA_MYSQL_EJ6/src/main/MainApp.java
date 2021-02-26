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
		DbFunctions.createDB("piezasYProveedores");
		
		//creamos la tabla Piezas pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTablePiezas("piezasYProveedores", "piezas");
		
		//insertamos registros String db, String table_name, int codigo, String nombre
		DbFunctions.insertDataPiezas("piezasYProveedores", "piezas", 1, "Pieza1");
		DbFunctions.insertDataPiezas("piezasYProveedores", "piezas", 2, "Pieza2");
		DbFunctions.insertDataPiezas("piezasYProveedores", "piezas", 3, "Pieza3");
		DbFunctions.insertDataPiezas("piezasYProveedores", "piezas", 4, "Pieza4");
		DbFunctions.insertDataPiezas("piezasYProveedores", "piezas", 5, "Pieza5");

		
		//creamos la tabla Proveedores pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableProveedores("piezasYProveedores", "proveedores");
		//insertamos registros String db, String table_name, String id, String nombre
		DbFunctions.insertDataProveedores("piezasYProveedores", "proveedores", "asd1", "Sony");
		DbFunctions.insertDataProveedores("piezasYProveedores", "proveedores", "asd2", "Philips");
		DbFunctions.insertDataProveedores("piezasYProveedores", "proveedores", "asd3", "Acer");
		DbFunctions.insertDataProveedores("piezasYProveedores", "proveedores", "asd4", "Asus");
		DbFunctions.insertDataProveedores("piezasYProveedores", "proveedores", "asd5", "AOC");

		//creamos la tabla Suministra pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableSuministra("piezasYProveedores", "suministra");
		
		//insertamos registros String db, String table_name, int codigoPieza, String idProveedor, int precio
		DbFunctions.insertDataSuministra("piezasYProveedores", "suministra", 2, "asd2", 222);
		DbFunctions.insertDataSuministra("piezasYProveedores", "suministra", 1, "asd1", 122);
		DbFunctions.insertDataSuministra("piezasYProveedores", "suministra", 3, "asd2", 422);
		DbFunctions.insertDataSuministra("piezasYProveedores", "suministra", 4, "asd2", 22);
		DbFunctions.insertDataSuministra("piezasYProveedores", "suministra", 3, "asd4", 42);
		
		//mostramos la info obtenida
		
		DbFunctions.getValuesPiezas("piezasYProveedores", "piezas");
		DbFunctions.getValuesProveedores("piezasYProveedores", "proveedores");
		DbFunctions.getValuesSuministra("piezasYProveedores", "suministra");
		
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
