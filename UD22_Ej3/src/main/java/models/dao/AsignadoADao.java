package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.conexion.Conexion;
import models.dto.AsignadoA;

public class AsignadoADao {
	/**
	 * Clase que permite el acceso a la base de datos
	 * CRUD
	 *
	 */
	
	//METODO QUE INSERTA DATOS EN LA TABLA AsignadoAs
	public void registrarAsignadoA(AsignadoA miAsignadoA) {
		
		Conexion conex = new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			//comando SQL para crear nuevo registro dentro de la tabla AsignadoAs
			String Query = "INSERT INTO asignado_a VALUES(" 
					+ "\"" + miAsignadoA.getCientificoAsignado() + "\", "
					+ "\"" + miAsignadoA.getProyectoAsignado() + "\"); ";

			st.executeUpdate(Query);
			//mostramos el aviso al user que se ha creado
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el nuevo AsignadoA!", "Información", JOptionPane.INFORMATION_MESSAGE);
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
	
	//METODO QUE DEVUELVE AsignadoA SEGÚN SU ID
	public AsignadoA buscarAsignadoA(String dniCientificoAsignado, String proyectoAsignado) {
		//creamos nueva conexion
		Conexion conex = new Conexion();
		//creamos nuevo AsignadoA
		AsignadoA AsignadoA = new AsignadoA();
		//por defecto no existe
		boolean existe = false;
		
		try {
			String sql = "SELECT * FROM  asignado_a where cientifico = ? AND proyecto = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			//pasamos los parametros de la consulta (cientifico y proyecto como PK)
			consulta.setString(1, dniCientificoAsignado);
			consulta.setString(2, proyectoAsignado);
			//obtenemos el objeto generado de la consulta
			ResultSet res = consulta.executeQuery();
			
			
			while(res.next()) {
				//AsignadoA existe, asignamos a true
				existe=true;
				//asignamos al objeto AsignadoA los datos sacados de la BD
				AsignadoA.setCientificoAsignado(res.getString("cientifico"));
				AsignadoA.setProyectoAsignado(res.getString("proyecto"));
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
		
		//si AsignadoA existe en la BD se devuelve sinó se devuelve como null
		if(existe) {
			return AsignadoA;
		} else {
			return null;
		}
	}
	
	//METODO QUE MODIFICA EL OBJETO DE AsignadoA QUE SE INTRODUCE
	public void modificarAsignadoA(AsignadoA miAsignadoA) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE asignado_a SET cientifico= ? , proyecto = ? WHERE cientifico = ? AND proyecto = ?";
			PreparedStatement statement = conex.getConnection().prepareStatement(consulta);
			
			statement.setString(1, miAsignadoA.getCientificoAsignado());
			statement.setString(2, miAsignadoA.getProyectoAsignado());
			statement.setString(3, miAsignadoA.getCientificoAsignado());
			statement.setString(4, miAsignadoA.getProyectoAsignado());
			
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);
			
		} catch(SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error, no se conectó con la BD");
		}
	}
	//METODO QUE ELIMINA AL AsignadoA DE LA BD
	public void eliminarAsignadoA(String cientificoAsignado, String proyectoAsignado) {
		Conexion conex = new Conexion();
		
		try {
			String sql = "DELETE FROM asignado_a WHERE cientifico ='"+cientificoAsignado+"' AND proyecto ='"+proyectoAsignado+"'";
			Statement st = conex.getConnection().createStatement();
			//hacemos el update del objeto AsignadoA
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
