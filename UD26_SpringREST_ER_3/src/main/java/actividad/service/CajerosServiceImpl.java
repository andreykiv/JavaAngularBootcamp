package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.ICajerosDAO;
import actividad.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService {
	
	@Autowired
	ICajerosDAO icajerosDAO;

	@Override
	public List<Cajeros> listarCajeros() {
		return icajerosDAO.findAll();
	}

	@Override
	public Cajeros guardarCajero(Cajeros cajeros) {
		return icajerosDAO.save(cajeros);
	}

	@Override
	public Cajeros cajeroXID(int id) {
		return icajerosDAO.findById(id).get();
	}

	@Override
	public Cajeros actualizarCajero(Cajeros cajeros) {
		return icajerosDAO.save(cajeros);
	}

	@Override
	public void eliminarCajero(int id) {
		icajerosDAO.deleteById(id);
	}

}
