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
		DbFunctions.createDB("TiendaInformatica");
		
		//creamos la tabla Fabricantes pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableFabricantes("TiendaInformatica", "Fabricantes");
		//insertamos 5 registros a la tabla Fabricantes params: String DB, String TableName, int codigoFabricante, String nombreFabricante
		DbFunctions.insertDataFabricantes("TiendaInformatica", "Fabricantes", 1, "Sony");
		DbFunctions.insertDataFabricantes("TiendaInformatica", "Fabricantes", 2, "Panasonic");
		DbFunctions.insertDataFabricantes("TiendaInformatica", "Fabricantes", 3, "Philips");
		DbFunctions.insertDataFabricantes("TiendaInformatica", "Fabricantes", 4, "Acer");
		DbFunctions.insertDataFabricantes("TiendaInformatica", "Fabricantes", 5, "Asus");
		
		//creamos la tabla Articulos pasando como parametros el nombre de la BD y el nombre de la tabla que queremos crear
		DbFunctions.createTableArticulos("TiendaInformatica", "Articulos");
		//insertamos 5 registros a la tabla Articulos pasando como params: 
		//String DB, String TableName, int codigoFabricante, String nombreArticulo, int precio, int FK codigoFabricante
		DbFunctions.insertDataArticulos("TiendaInformatica", "Articulos", 1, "Videoconsola", 499, 1);
		DbFunctions.insertDataArticulos("TiendaInformatica", "Articulos", 2, "Monitor", 211, 1);
		DbFunctions.insertDataArticulos("TiendaInformatica", "Articulos", 3, "Portátil", 999, 4);
		DbFunctions.insertDataArticulos("TiendaInformatica", "Articulos", 4, "Cable USB", 24, 2);
		DbFunctions.insertDataArticulos("TiendaInformatica", "Articulos", 5, "Altavoz bluetooth", 333, 2);
		
		//mostramos los registros creados anteriormente por la consola
		DbFunctions.getValuesFabricantes("TiendaInformatica", "Fabricantes");
		DbFunctions.getValuesArticulos("TiendaInformatica", "Articulos");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
