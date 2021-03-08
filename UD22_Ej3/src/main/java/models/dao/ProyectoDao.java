package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.conexion.Conexion;
import models.dto.Proyecto;

public class ProyectoDao {
	/**
	 * Clase que permite el acceso a la base de datos
	 * CRUD
	 *
	 */
	
	//METODO QUE INSERTA DATOS EN LA TABLA Proyectos
	public void registrarProyecto(Proyecto miProyecto) {
		
		Conexion conex = new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			//comando SQL para crear nuevo registro dentro de la tabla Proyectos
			String Query = "INSERT INTO proyecto VALUES(" 
					+ "\"" + miProyecto.getIdProyecto() + "\", "
					+ "\"" + miProyecto.getNombreProyecto() + "\", "
					+ "\"" + miProyecto.getHoras() + "\");";

			st.executeUpdate(Query);
			//mostramos el aviso al user que se ha creado
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el nuevo Proyecto!", "Información", JOptionPane.INFORMATION_MESSAGE);
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
	
	//METODO QUE DEVUELVE Proyecto SEGÚN SU ID
	public Proyecto buscarProyecto(String idProyecto) {
		//creamos nueva conexion
		Conexion conex = new Conexion();
		//creamos nuevo Proyecto
		Proyecto Proyecto = new Proyecto();
		//por defecto no existe
		boolean existe = false;
		
		try {
			String sql = "SELECT * FROM  proyecto where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			//pasamos el primer palametro a la consulta (dni)
			consulta.setString(1, idProyecto);
			//obtenemos el objeto generado de la consulta
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				//Proyecto existe, asignamos a true
				existe=true;
				//asignamos al objeto Proyecto los datos sacados de la BD
				Proyecto.setIdProyecto(res.getString("id"));
				Proyecto.setNombreProyecto(res.getString("nombre"));
				Proyecto.setHoras(Integer.parseInt(res.getString("horas")));
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
		
		//si Proyecto existe en la BD se devuelve sinó se devuelve como null
		if(existe) {
			return Proyecto;
		} else {
			return null;
		}
	}
	
	//METODO QUE MODIFICA EL OBJETO DE Proyecto QUE SE INTRODUCE
	public void modificarProyecto(Proyecto miProyecto) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE proyecto SET id= ? , nombre = ?, horas = ? WHERE id = ?";
			PreparedStatement statement = conex.getConnection().prepareStatement(consulta);
			
			statement.setString(1, miProyecto.getIdProyecto());
			statement.setString(2, miProyecto.getNombreProyecto());
			statement.setInt(3, miProyecto.getHoras());
			statement.setString(4, miProyecto.getIdProyecto());
			
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);
			
		} catch(SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error, no se conectó con la BD");
		}
	}
	//METODO QUE ELIMINA AL Proyecto DE LA BD
	public void eliminarProyecto(String idProyecto) {
		Conexion conex = new Conexion();
		
		try {
			String sql = "DELETE FROM proyecto WHERE id ='"+idProyecto+"'";
			Statement st = conex.getConnection().createStatement();
			//hacemos el update del objeto Proyecto
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
