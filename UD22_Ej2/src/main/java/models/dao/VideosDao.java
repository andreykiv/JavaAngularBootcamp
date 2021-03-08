package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.conexion.Conexion;
import models.dto.Videos;

public class VideosDao {
	/**
	 * Clase que permite el acceso a la base de datos
	 * CRUD
	 *
	 */
	
	//METODO QUE INSERTA DATOS EN LA TABLA Videoss
	public void registrarVideos(Videos miVideo) {
		
		Conexion conex = new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			//comando SQL para crear nuevo registro dentro de la tabla Videoss
			String Query = "INSERT INTO videos VALUES(" 
					+ "\"" + miVideo.getIdVideo() + "\", "
					+ "\"" + miVideo.getTitleVideo() + "\", "
					+ "\"" + miVideo.getDirectorVideo() + "\", "
					+ "\"" + miVideo.getCli_idVideo() + "\");";

			st.executeUpdate(Query);
			//mostramos el aviso al user que se ha creado
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el nuevo Video!", "Información", JOptionPane.INFORMATION_MESSAGE);
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
	
	//METODO QUE DEVUELVE Videos SEGÚN SU ID
	public Videos buscarVideos(int idVideo) {
		//creamos nueva conexion
		Conexion conex = new Conexion();
		//creamos nuevo Video
		Videos Video = new Videos();
		//por defecto no existe
		boolean existe = false;
		
		try {
			String sql = "SELECT * FROM  videos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			//pasamos el primer palametro a la consulta (dni)
			consulta.setInt(1, idVideo);
			//obtenemos el objeto generado de la consulta
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				//Video existe, asignamos a true
				existe=true;
				//asignamos al objeto Video los datos sacados de la BD
				Video.setIdVideo(Integer.parseInt(res.getString("id")));
				Video.setTitleVideo(res.getString("title"));
				Video.setDirectorVideo(res.getString("director"));
				Video.setCli_idVideo(Integer.parseInt(res.getString("cli_id")));
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
		
		//si Video existe en la BD se devuelve sinó se devuelve como null
		if(existe) {
			return Video;
		} else {
			return null;
		}
	}
	
	//METODO QUE MODIFICA EL OBJETO DE Video QUE SE INTRODUCE
	public void modificarVideo(Videos miVideo) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE videos SET id= ? , title = ?, director = ?,  cli_id = ?";
			PreparedStatement statement = conex.getConnection().prepareStatement(consulta);
			
			statement.setInt(1, miVideo.getIdVideo());
			statement.setString(2, miVideo.getTitleVideo());
			statement.setString(3, miVideo.getDirectorVideo());
			statement.setInt(4, miVideo.getCli_idVideo());
			
		} catch(SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error, no se conectó con la BD");
		}
	}
	//METODO QUE ELIMINA AL Video DE LA BD
	public void eliminarVideo(String idVideo) {
		Conexion conex = new Conexion();
		
		try {
			String sql = "DELETE FROM videos WHERE id ='"+idVideo+"'";
			Statement st = conex.getConnection().createStatement();
			//hacemos el update del objeto Video
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
