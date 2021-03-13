package actividad3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.dao.IAlmacenesDAO;
import actividad3.dto.Almacenes;


@Service
public class AlmacenesServiceImpl implements IAlmacenesService {
	//Utilizamos los metodos de la interface IAlmacenesDAO, es como si instaciaramos.
	@Autowired
	IAlmacenesDAO iAlmacenesDAO;

	@Override
	public List<Almacenes> listarAlmacenes() {

		return iAlmacenesDAO.findAll();
	}

	@Override
	public Almacenes guardarAlmacenes(Almacenes almacenes) {

		return iAlmacenesDAO.save(almacenes);
	}

	@Override
	public Almacenes almacenesXID(Long id) {

		return iAlmacenesDAO.findById(id).get();
	}

	@Override
	public Almacenes actualizarAlmacenes(Almacenes almacenes) {

		return iAlmacenesDAO.save(almacenes);
	}

	@Override
	public void eliminarAlmacenes(Long id) {
		iAlmacenesDAO.deleteById(id);
	}
}
