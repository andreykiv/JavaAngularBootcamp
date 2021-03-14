package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.ICientificosDAO;
import actividad.dto.Cientificos;

@Service
public class CientificosServiceImpl implements ICientificosService {
	
	@Autowired
	ICientificosDAO iCientificosDAO;

	@Override
	public List<Cientificos> listarCientificos() {
		return iCientificosDAO.findAll();
	}

	@Override
	public Cientificos guardarCientifico(Cientificos cientificos) {
		return iCientificosDAO.save(cientificos);
	}

	@Override
	public Cientificos cientificoXID(String dni) {
		return iCientificosDAO.findById(dni).get();
	}

	@Override
	public Cientificos actualizarCientifico(Cientificos cientificos) {
		return iCientificosDAO.save(cientificos);
	}

	@Override
	public void eliminarCientifico(String dni) {
		iCientificosDAO.deleteById(dni);
	}

}
