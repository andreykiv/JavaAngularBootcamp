package models.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {
	
	static String bd = "patronMVC_ej3";
	static String login = "remote";
	static String password = "passremote";
	static String url = "jdbc:mysql://192.168.0.163:3306/"+bd+"?useTimezone=true&serverTimezone=UTC";
	
	Connection conn = null;

	//constructor de DBConnection
	public Conexion() {
		try {
			//obtenemos la conexion
			conn = DriverManager.getConnection(url,login,password);
			if(conn!=null) {
				System.out.println("Conexión a base de datos "+bd+"_SUCCESS at");
				fecha();
			}
		}
		catch(SQLException e){
		System.out.println(e);
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//Permite retornar la conexion
	public Connection getConnection(){
		return conn;
	}

	public void desconectar(){
		conn = null;
	}
	
	//METODO QUE MUESTRA FECHA
	public static Date fecha() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println(" - " + hourdateFormat.format(date));
		return date;
	}
	
	public static String fechaFormateada() {
		String dataLocal = "";
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd/");
		dataLocal = hourdateFormat.format(date);
		return dataLocal;
	}
}
