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

		
		//METODO QUE CREA LA TABLA CIENTIFICOS
		public static void createTableCientificos(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Peliculas
				String Query = "create table "+name+"("
						+ "dni varchar(8) unique not null,\r\n"
						+ "nomApels varchar(255),\r\n"
						+ "primary key(dni)\r\n"
						+ ")Engine=InnoDb;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA PROYECTO
		public static void createTableProyecto(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Peliculas
				String Query = "create table "+name+"("
						+ "id char(4) unique not null,\r\n"
						+ "nombre varchar(255),\r\n"
						+ "horas int,\r\n"
						+ "primary key(id)\r\n"
						+ ")Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA ASIGNADO_A
		public static void createTableAsignadoA(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "create table "+name+ "("
						+ "cientifico varchar(8),\r\n"
						+ "proyecto char(4),\r\n"
						+ "primary key(cientifico, proyecto),\r\n"
						+ "key cientifico(cientifico),\r\n"
						+ "key proyecto(proyecto),\r\n"
						+ "foreign key(cientifico) \r\n"
						+ "references cientificos(dni)\r\n"
						+ "on delete cascade\r\n"
						+ "on update cascade,\r\n"
						+ "foreign key(proyecto)\r\n"
						+ "references proyecto(id)\r\n"
						+ "on delete cascade\r\n"
						+ "on update cascade\r\n"
						+ ") Engine =InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA CIENTIFICOS
		public static void insertDataCientificos(String db, String table_name, String dni, String nomApels) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + dni + "\", "
						+ "\"" + nomApels + "\");";

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA PROYECTO
		public static void insertDataProyecto(String db, String table_name, String id, String nombre, int horas) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + id + "\", "		
						+ "\"" + nombre + "\", "		
						+ "\"" + horas + "\"); ";
				

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA ASIGNADOA
		public static void insertDataAsignadoA(String db, String table_name, String cientifico, String proyecto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + cientifico + "\", "	
						+ "\"" + proyecto + "\"); ";
				
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE OBTIENE VALORES CIENTIFICOS
		public static void getValuesCientificos(String db, String table_name) {
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
							+ "NomApels: " +  resultSet.getString("nomApels") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES PROYECTO
		public static void getValuesProyecto(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Id: " +  resultSet.getString("id") + " "
							+ "Nombre: " +  resultSet.getString("nombre") + " "
							+ "Horas: " +  resultSet.getString("horas") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES ASIGNADOA
		public static void getValuesAsignadoA(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Cientifico: " +  resultSet.getString("cientifico") + " "
							+ "Proyecto: " +  resultSet.getString("proyecto") + " "
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
