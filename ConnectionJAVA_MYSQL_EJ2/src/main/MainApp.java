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
		DbFunctions.createDB("Empleados");
		
		//creamos la tabla DEPARTAMENTOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableDepartamentos("Empleados", "departamentos");
		
		//insertamos registros String db, String table_name, int codigo, String nombre, int presupuesto
		DbFunctions.insertDataDepartamentos("Empleados", "departamentos", 1, "Marketing", 20000);
		DbFunctions.insertDataDepartamentos("Empleados", "departamentos", 2, "I+D", 10000);
		DbFunctions.insertDataDepartamentos("Empleados", "departamentos", 3, "IT", 15000);
		DbFunctions.insertDataDepartamentos("Empleados", "departamentos", 4, "Contabilidad", 11000);
		DbFunctions.insertDataDepartamentos("Empleados", "departamentos", 5, "Calidad", 5000);
		
		//creamos la tabla EMPLEADOS pasando como parametros el nombre de la BD y la tabla que queremos crear.
		DbFunctions.createTableEmpleados("Empleados", "empleados");
		//insertamos registros String db, String table_name, String dni, String nombre, String apellidos, int departamento
		DbFunctions.insertDataEmpleados("Empleados", "empleados", "x3409121", "Michael", "Scott", 2);
		DbFunctions.insertDataEmpleados("Empleados", "empleados", "x3409122", "Dwight", "Schrude", 1);
		DbFunctions.insertDataEmpleados("Empleados", "empleados", "x3409123", "Jim", "Harpert", 4);
		DbFunctions.insertDataEmpleados("Empleados", "empleados", "x3409124", "Kevin", "Kevins", 5);
		DbFunctions.insertDataEmpleados("Empleados", "empleados", "x3409125", "Margharet", "Los Santos", 2);
		//mostramos la info obtenida
		DbFunctions.getValuesEmpleados("Empleados", "empleados");
		DbFunctions.getValuesDepartamentos("Empleados", "departamentos");
		
		//cerramos la conexión con la BD.
		DbFunctions.closeConnection();
	}

}
