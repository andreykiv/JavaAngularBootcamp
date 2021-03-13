package actividad4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad4.dao.ISalasDAO;
import actividad4.dto.Salas;


@Service
public class SalasServiceImpl implements ISalasService {
	//Utilizamos los metodos de la interface ISalasDAO, es como si instaciaramos.
	@Autowired
	ISalasDAO iSalasDAO;

	@Override
	public List<Salas> listarSalas() {

		return iSalasDAO.findAll();
	}

	@Override
	public Salas guardarSalas(Salas salas) {

		return iSalasDAO.save(salas);
	}

	@Override
	public Salas SalasXID(Long id) {

		return iSalasDAO.findById(id).get();
	}

	@Override
	public Salas actualizarSalas(Salas salas) {

		return iSalasDAO.save(salas);
	}

	@Override
	public void eliminarSalas(Long id) {
		iSalasDAO.deleteById(id);
	}
}
