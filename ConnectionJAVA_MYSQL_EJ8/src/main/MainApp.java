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
		DbFunctions.createDB("grandesAlmacenes");
		
		//creamos la tabla Productos pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableProductos("grandesAlmacenes", "productos");
		
		//insertamos registros String db, String table_name, int codigo, String nombre, int precio
		DbFunctions.insertDataProductos("grandesAlmacenes", "productos", 1, "Monitor", 224);
		DbFunctions.insertDataProductos("grandesAlmacenes", "productos", 2, "Ratón", 44);
		DbFunctions.insertDataProductos("grandesAlmacenes", "productos", 3, "Teclado", 99);
		DbFunctions.insertDataProductos("grandesAlmacenes", "productos", 4, "Altavoces", 150);
		DbFunctions.insertDataProductos("grandesAlmacenes", "productos", 5, "PC", 999);

		
		//creamos la tabla Cajeros pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableCajeros("grandesAlmacenes", "cajeros");
		//insertamos registros String db, String table_name, int codigo, String nomApels
		DbFunctions.insertDataCajeros("grandesAlmacenes", "cajeros", 1, "Michael Scott");
		DbFunctions.insertDataCajeros("grandesAlmacenes", "cajeros", 2, "Michael Brott");
		DbFunctions.insertDataCajeros("grandesAlmacenes", "cajeros", 3, "Michael Gcott");
		DbFunctions.insertDataCajeros("grandesAlmacenes", "cajeros", 4, "Michael Tcott");
		DbFunctions.insertDataCajeros("grandesAlmacenes", "cajeros", 5, "Michael Zcott");

		//creamos la tabla AsignadoA pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras");
		
		//insertamos registros String db, String table_name, int codigo, int piso
		DbFunctions.insertDataMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras", 1, 4);
		DbFunctions.insertDataMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras", 2, 4);
		DbFunctions.insertDataMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras", 3, 4);
		DbFunctions.insertDataMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras", 4, 1);
		DbFunctions.insertDataMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras", 5, 2);
		
		//creamos la tabla venta pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableVenta("grandesAlmacenes", "venta");
		//insertamos registros String db, String table_name, int cajero, int maquina, int producto
		DbFunctions.insertDataVenta("grandesAlmacenes", "venta", 1, 2, 1);
		DbFunctions.insertDataVenta("grandesAlmacenes", "venta", 1, 1, 1);
		DbFunctions.insertDataVenta("grandesAlmacenes", "venta", 2, 2, 1);
		DbFunctions.insertDataVenta("grandesAlmacenes", "venta", 4, 2, 1);
		DbFunctions.insertDataVenta("grandesAlmacenes", "venta", 1, 5, 1);
		
		//mostramos la info obtenida
		DbFunctions.getValuesProductos("grandesAlmacenes", "productos");
		DbFunctions.getValuesCajeros("grandesAlmacenes", "cajeros");
		DbFunctions.getValuesMaquinasRegistradoras("grandesAlmacenes", "maquinasRegistradoras");
		DbFunctions.getValuesVenta("grandesAlmacenes", "Venta");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
