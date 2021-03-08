package models.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.conexion.Conexion;
import models.dto.Cientificos;

public class CientificosDao {
	/**
	 * Clase que permite el acceso a la base de datos
	 * CRUD
	 *
	 */
	
	//METODO QUE INSERTA DATOS EN LA TABLA cientificos
	public static void registrarCientifico(Cientificos miCientifico) {
		
		Conexion conex = new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			//comando SQL para crear nuevo registro dentro de la tabla cientificos
			String Query = "INSERT INTO cientificos VALUES(" 
					+ "\"" + miCientifico.getDniCientifico() + "\", "
					+ "\"" + miCientifico.getNomApelsCientifico() + "\");";

			st.executeUpdate(Query);
			//mostramos el aviso al user que se ha creado
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el nuevo Cientifico!", "Información", JOptionPane.INFORMATION_MESSAGE);
			//mostramos por la consola el comando de SQL
			System.out.println(Query);
			//cerramos el statement y conexion
			st.close();
			conex.desconectar();
			
		} catch (SQLException ex) {
			//mostramos el error por consola
			System.out.println(ex.getMessage());
			//y avisamos al user que no se ha almacenado
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	//METODO QUE DEVUELVE Cientifico SEGÚN SU dni
	public Cientificos buscarCientifico(String dniCientifico) {
		//creamos nueva conexion
		Conexion conex = new Conexion();
		//creamos nuevo Cientifico
		Cientificos Cientifico = new Cientificos();
		//por defecto no existe
		boolean existe = false;
		
		try {
			String sql = "SELECT * FROM  cientificos where dni = ? ;";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			//pasamos el primer palametro a la consulta (dni)
			consulta.setString(1, dniCientifico);
			//obtenemos el objeto generado de la consulta
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				//Cientifico existe, asignamos a true
				existe=true;
				//asignamos al objeto Cientifico los datos sacados de la BD
				Cientifico.setDniCientifico(res.getString("dni"));
				Cientifico.setNomApelsCientifico(res.getString("nomApels"));

			}
			//desconectamos de la consulta y de la db
			res.close();
			conex.desconectar();
			//mostramos el comando sql por consola
			System.out.println(sql);
			
		} catch (SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error, no se conectó con la BD");
		}
		
		//si Cientifico existe en la BD se devuelve sinó se devuelve como null
		if(existe) {
			return Cientifico;
		} else {
			return null;
		}
	}
	
	//METODO QUE MODIFICA EL OBJETO DE Cientifico QUE SE INTRODUCE
	public void modificarCientifico(Cientificos miCientifico) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE cientificos SET dni = ? , nomApels = ? WHERE dni = ?;";
			PreparedStatement statement = conex.getConnection().prepareStatement(consulta);
			
			statement.setString(1, miCientifico.getDniCientifico());
			statement.setString(2, miCientifico.getNomApelsCientifico());
			statement.setString(3, miCientifico.getDniCientifico());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);
			
		} catch(SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error, no se conectó con la BD");
		}
	}
	//METODO QUE ELIMINA AL Cientifico DE LA BD
	public void eliminarCientifico(String dniCientifico) {
		Conexion conex = new Conexion();
		
		try {
			String sql = "DELETE FROM cientificos WHERE dni ='"+dniCientifico+"'";
			Statement st = conex.getConnection().createStatement();
			//hacemos el update del objeto Cientifico
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch( SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
		}
	}
}


