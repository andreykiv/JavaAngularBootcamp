package models.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.JOptionPane;

import models.conexion.Conexion;
import models.dto.Cliente;

public class ClienteDao {
	/**
	 * Clase que permite el acceso a la base de datos
	 * CRUD
	 *
	 */
	
	//METODO QUE INSERTA DATOS EN LA TABLA clientes
	public static void registrarCliente(Cliente miCliente) {
		
		Conexion conex = new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			//comando SQL para crear nuevo registro dentro de la tabla clientes
			String Query = "INSERT INTO cliente VALUES(" 
					+ "\"" + miCliente.getIdCliente() + "\", "
					+ "\"" + miCliente.getNombre() + "\", "
					+ "\"" + miCliente.getApellido() + "\", "
					+ "\"" + miCliente.getDireccion() + "\", "
					+ "\"" + miCliente.getDni() + "\", "
					+ "\"" + miCliente.getFecha() + "\");";

			st.executeUpdate(Query);
			//mostramos el aviso al user que se ha creado
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el nuevo cliente!", "Información", JOptionPane.INFORMATION_MESSAGE);
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
	
	//METODO QUE DEVUELVE cliente SEGÚN SU ID
	public Cliente buscarCliente(int idCliente) {
		//creamos nueva conexion
		Conexion conex = new Conexion();
		//creamos nuevo cliente
		Cliente cliente = new Cliente();
		//por defecto no existe
		boolean existe = false;
		
		try {
			String sql = "SELECT * FROM  cliente where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			//pasamos el primer palametro a la consulta (dni)
			consulta.setInt(1, idCliente);
			//obtenemos el objeto generado de la consulta
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				//cliente existe, asignamos a true
				existe=true;
				//asignamos al objeto Cliente los datos sacados de la BD
				cliente.setIdCliente(Integer.parseInt(res.getString("id")));
				cliente.setNombre(res.getString("nombre"));
				cliente.setApellido(res.getString("apellido"));
				cliente.setDireccion(res.getString("direccion"));
				cliente.setDni(Integer.parseInt(res.getString("dni")));
				cliente.setFecha(res.getString("fecha"));
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
		
		//si cliente existe en la BD se devuelve sinó se devuelve como null
		if(existe) {
			return cliente;
		} else {
			return null;
		}
	}
	
	//METODO QUE MODIFICA EL OBJETO DE cliente QUE SE INTRODUCE
	public void modificarCliente(Cliente miCliente) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE cliente SET id= ? , nombre = ? , apellido = ? , direccion = ? , dni = ? WHERE id= ?;";
			PreparedStatement statement = conex.getConnection().prepareStatement(consulta);
			
			statement.setInt(1, miCliente.getIdCliente());
			statement.setString(2, miCliente.getNombre());
			statement.setString(3, miCliente.getApellido());
			statement.setString(4, miCliente.getDireccion());
			statement.setInt(5, miCliente.getDni());
			statement.setInt(6, miCliente.getIdCliente());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);
			
		} catch(SQLException ex) {
			//mostramos los avisos por consola y al user
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al modificar ");
		}
	}
	//METODO QUE ELIMINA AL CLIENTE DE LA BD
	public void eliminarCliente(String idCliente) {
		Conexion conex = new Conexion();
		
		try {
			String sql = "DELETE FROM cliente WHERE id ='"+idCliente+"'";
			Statement st = conex.getConnection().createStatement();
			//hacemos el update del objeto cliente
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


