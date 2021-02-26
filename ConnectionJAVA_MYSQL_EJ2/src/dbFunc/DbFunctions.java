package dbFunc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


/**
 * @author Myroslav Andreykiv
 *
 */
public class DbFunctions {
	
		public static Connection conexion;

		
		//METODO QUE CREA LA TABLA ARTICULOS
		public static void createTableDepartamentos(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Articulos
				String Query = "create table if not exists "+name+""
						+ "(codigo int,\r\n"
						+ "nombre varchar(100),\r\n"
						+ "presupuesto int,\r\n"
						+ "primary key(codigo)\r\n"
						+ ") Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA EMPLEADOS
		public static void createTableEmpleados(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS "+name+""
						+ "(dni varchar(10) not null,\r\n"
						+ "nombre varchar(100),\r\n"
						+ "apellidos varchar(255),\r\n"
						+ "departamento int,\r\n"
						+ "primary key (dni),\r\n"
						+ "key departamento(departamento),\r\n"
						+ "foreign key(departamento)\r\n"
						+ "references departamentos(codigo)\r\n"
						+ "on update cascade\r\n"
						+ "on delete cascade\r\n"
						+ ")Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA DEPARTAMENTOS
		public static void insertDataDepartamentos(String db, String table_name, int codigo, String nombre, int presupuesto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigo + "\", "
						+ "\"" + nombre + "\","
						+ "\"" + presupuesto + "\");";

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA EMPLEADOS
		public static void insertDataEmpleados(String db, String table_name, String dni, String nombre, String apellidos, int departamento) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + dni + "\", "
						+ "\"" + nombre + "\", "
						+ "\"" + apellidos + "\", "
						+ "\"" + departamento + "\"); ";
				

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE OBTIENE VALORES EMPLEADOS
		public static void getValuesEmpleados(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("DNI: " +  resultSet.getString("dni") + " "
							+ "Nombre: " +  resultSet.getString("nombre") + " "
							+ "Apellidos: " +  resultSet.getString("apellidos") + " "
							+ "Departamento: " +  resultSet.getString("departamento") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES DEOARTAMENTOS
		public static void getValuesDepartamentos(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Codigo: " +  resultSet.getString("codigo") + " "
							+ "Nombre: " +  resultSet.getString("nombre") + " "
							+ "Presupuesto: " +  resultSet.getString("presupuesto") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE ABRE LA CONEXION CON SERVER MYSQL
		public static void openConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.163:3306?useTimezone=true&serverTimezone=UTC", "remote", "passremote");
				System.out.print("Server Connected");
				fecha();

			}catch(SQLException | ClassNotFoundException ex  ){
				System.out.print("No se ha podido conectar con mi base de datos");
				fecha();
				System.out.println(ex.getMessage());	
			}
		}

		//METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
		public static void closeConnection() {
			try {

				conexion.close();
				System.out.print("Server Disconnected");
				fecha();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.print("Error cerrando conexion");
				fecha();
			}
		}

		//METODO QUE CREA LA BASE DE DATOS
		public static void createDB(String name) {
			try {
				String Query="CREATE DATABASE IF NOT EXISTS "+ name;
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("DB creada con exito!");

				JOptionPane.showMessageDialog(null, "Se ha creado la DB " +name+ "de forma exitosa.");
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error creando la DB.");
			}	
		}

		//METODO QUE LIMPIA TABLAS MYSQL
		public static void deleteRecord(String db, String table_name, String ID) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Registros de tabla ELIMINADOS con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
			}
		}

		//METODO QUE ELIMINA TABLAS MYSQL
		public static void deleteTabla(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "DROP TABLE " + table_name + ";";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("TABLA ELIMINADA con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando la tabla");
			}
		}

		//METODO QUE MUESTRA FECHA
		public static void fecha() {
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			System.out.println(" - " + hourdateFormat.format(date));
		}
}
