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

		
		//METODO QUE CREA LA TABLA PIEZAS
		public static void createTablePiezas(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Peliculas
				String Query = "create table "+name+"("
						+ "codigo int auto_increment not null,\r\n"
						+ "nombre varchar(100),\r\n"
						+ "primary key(codigo)\r\n"
						+ ")engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA PROVEEDORES
		public static void createTableProveedores(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Peliculas
				String Query = "create table "+name+"("
						+ "id char(4) not null,\r\n"
						+ "nombre varchar(100),\r\n"
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
		
		//METODO QUE CREA LA TABLA SUMINISTRA
		public static void createTableSuministra(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "create table "+name+ "("
						+ "codigoPieza int,\r\n"
						+ "idProveedor char(4),\r\n"
						+ "precio int,\r\n"
						+ "primary key(codigoPieza, idProveedor),\r\n"
						+ "key codigoPieza (codigoPieza),\r\n"
						+ "key idProveedor (idProveedor),\r\n"
						+ "foreign key(codigoPieza)\r\n"
						+ "references piezas(codigo)\r\n"
						+ "on update cascade\r\n"
						+ "on delete cascade,\r\n"
						+ "foreign key(idProveedor)\r\n"
						+ "references proveedores(id)\r\n"
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
		
		//METODO QUE INSERTA DATOS EN LA TABLA PIEZAS
		public static void insertDataPiezas(String db, String table_name, int codigo, String nombre) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigo + "\", "
						+ "\"" + nombre + "\");";

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA PROVEEDORES
		public static void insertDataProveedores(String db, String table_name, String id, String nombre) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + id + "\", "					
						+ "\"" + nombre + "\"); ";
				

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA SUMINISTRA
		public static void insertDataSuministra(String db, String table_name, int codigoPieza, String idProveedor, int precio) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigoPieza + "\", "	
						+ "\"" + idProveedor + "\", "	
						+ "\"" + precio + "\"); ";
				

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE OBTIENE VALORES PIEZAS
		public static void getValuesPiezas(String db, String table_name) {
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
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES DIRECTORES
		public static void getValuesProveedores(String db, String table_name) {
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
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES SUMINISTRA
		public static void getValuesSuministra(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Codigo pieza: " +  resultSet.getString("codigoPieza") + " "
							+ "Id Proveedor: " +  resultSet.getString("idProveedor") + " "
							+ "Precio: " +  resultSet.getString("precio") + " "
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
