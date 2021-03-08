/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la persona en
 * el Dao.
 */


/**
 * @author Myroslav Andreykiv
 *
 */

package models.service;
import models.dto.Cliente;

import javax.swing.JOptionPane;

import controllers.ClienteController;
import models.dao.ClienteDao;


public class ClienteServ {
	//atributos ClienteServ
	private ClienteController clienteController;
	
	public static boolean consultaCliente=false;
	public static boolean modificarCliente=false;
	
	//Metodo de vinculación con el controller principal
	public void setClienteController(ClienteController clienteController) {
		this.setController(clienteController);
	}
	
	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cliente miCliente) {
		ClienteDao miClienteDao;
		//si el user inserta un id menor a 99 no se registra el cliente
		if(miCliente.getIdCliente() > 99) {
			miClienteDao = new ClienteDao();
			miClienteDao.registrarCliente(miCliente);
		} else {
			JOptionPane.showMessageDialog(null, "El id del cliente debe ser mas de 3 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cliente validarConsulta(String idCliente) {
		ClienteDao miClienteDao;
		
		try {
			int id = Integer.parseInt(idCliente);
			//si el id de la persona es mayor a 99 se valida la consulta
			if(id > 99) {
				miClienteDao = new ClienteDao();
				consultaCliente = true;
				return miClienteDao.buscarCliente(id);
			} else {
				JOptionPane.showMessageDialog(null, "El id del cliente debe tener mas de 3 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		}
		return null;
	}
	
	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cliente miCliente) {
		ClienteDao miClienteDao;
		if(miCliente.getNombre().length()>5) {
			miClienteDao = new ClienteDao();
			miClienteDao.modificarCliente(miCliente);
			modificarCliente=true;
		}
	}
	
	
	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		ClienteDao miClienteDao = new ClienteDao();
		miClienteDao.eliminarCliente(codigo);
	}
	
	
	//GETTERS Y SETTERS
	public ClienteController getClienteController() {
		return clienteController;
	}

	public void setController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
}
