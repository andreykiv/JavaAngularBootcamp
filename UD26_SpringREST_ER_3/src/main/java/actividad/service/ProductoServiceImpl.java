package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.IProductosDAO;
import actividad.dto.Productos;


@Service
public class ProductoServiceImpl implements IProductosService {
	
	@Autowired
	IProductosDAO iProductoDAO;

	@Override
	public List<Productos> listarProductos() {
		return iProductoDAO.findAll();
	}

	@Override
	public Productos guardarProducto(Productos producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public Productos productoXID(int id) {
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Productos actualizarProducto(Productos producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int id) {
		iProductoDAO.deleteById(id);
	}

}
