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

		
		//METODO QUE CREA LA TABLA CAJEROS
		public static void createTableCajeros(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Cajeros
				String Query = "create table "+name+"("
						+ "codigo int auto_increment not null,\r\n"
						+ "nomApels varchar(255),\r\n"
						+ "primary key(codigo)\r\n"
						+ ")Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA PRODUCTOS
		public static void createTableProductos(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				//query de mySQL para crear tabla Peliculas
				String Query = "create table "+name+"("
						+ "codigo int auto_increment not null,\r\n"
						+ "nombre varchar(100),\r\n"
						+ "precio int,\r\n"
						+ "primary key(codigo)\r\n"
						+ ")Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA MAQUINAS REGISTRADORAS
		public static void createTableMaquinasRegistradoras(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "create table "+name+ "("
						+ "codigo int auto_increment not null,\r\n"
						+ "piso int,\r\n"
						+ "primary key(codigo)\r\n"
						+ ")Engine=InnoDB;";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE CREA LA TABLA MAQUINAS VENTA
		public static void createTableVenta(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "create table "+name+ "("
						+ "cajero int not null,\r\n"
						+ "maquina int not null,\r\n"
						+ "producto int not null,\r\n"
						+ "primary key(cajero, maquina, producto),\r\n"
						+ "key producto(producto),\r\n"
						+ "key cajero(cajero),\r\n"
						+ "key maquina(maquina),\r\n"
						+ "foreign key(producto)\r\n"
						+ "references productos(codigo)\r\n"
						+ "on update cascade\r\n"
						+ "on delete cascade,\r\n"
						+ "foreign key(maquina)\r\n"
						+ "references maquinasRegistradoras(codigo)\r\n"
						+ "on update cascade\r\n"
						+ "on delete cascade,\r\n"
						+ "foreign key(cajero)\r\n"
						+ "references cajeros(codigo)\r\n"
						+ "on update cascade\r\n"
						+ "on delete cascade);";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");
			}
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA PRODUCTOS
		public static void insertDataProductos(String db, String table_name, int codigo, String nombre, int precio) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigo + "\", "
						+ "\"" + nombre + "\", "
						+ "\"" + precio + "\");";

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA CAJEROS
		public static void insertDataCajeros(String db, String table_name, int codigo, String nomApels) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigo + "\", "			
						+ "\"" + nomApels + "\"); ";
				

				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA MAQUINAS REGISTRADORAS
		public static void insertDataMaquinasRegistradoras(String db, String table_name, int codigo, int piso) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + codigo + "\", "	
						+ "\"" + piso + "\"); ";
				
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE INSERTA DATOS EN LA TABLA VENTA
		public static void insertDataVenta(String db, String table_name, int cajero, int maquina, int producto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO " + table_name + " VALUES(" 
						+ "\"" + cajero + "\", "	
						+ "\"" + maquina + "\", "	
						+ "\"" + producto + "\"); ";
				
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		//METODO QUE OBTIENE VALORES PRODUCTOS
		public static void getValuesProductos(String db, String table_name) {
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
							+ "Precio: " +  resultSet.getString("precio") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES CAJEROS
		public static void getValuesCajeros(String db, String table_name) {
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
							+ "NomApels: " +  resultSet.getString("nomApels") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES MAQUINAS REGISTRADORAS
		public static void getValuesMaquinasRegistradoras(String db, String table_name) {
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
							+ "Piso: " +  resultSet.getString("piso") + " "
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE OBTIENE VALORES MAQUINAS REGISTRADORAS
		public static void getValuesVenta(String db, String table_name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Cajero: " +  resultSet.getString("cajero") + " "
							+ "Maquina: " +  resultSet.getString("maquina") + " "
							+ "Producto: " +  resultSet.getString("producto") + " "
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
