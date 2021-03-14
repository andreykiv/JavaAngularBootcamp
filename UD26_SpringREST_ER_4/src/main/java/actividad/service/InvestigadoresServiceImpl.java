package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.IInvestigadoresDAO;
import actividad.dto.Investigadores;

@Service
public class InvestigadoresServiceImpl implements IInvestigadoresService {
	
	@Autowired
	IInvestigadoresDAO iInvestigadoresDAO;

	@Override
	public List<Investigadores> listarInvestigadores() {
		return iInvestigadoresDAO.findAll();
	}

	@Override
	public Investigadores guardarInvestigador(Investigadores investigadores) {
		return iInvestigadoresDAO.save(investigadores);
	}

	@Override
	public Investigadores investigadorXID(String dni) {
		return iInvestigadoresDAO.findById(dni).get();
	}

	@Override
	public Investigadores actualizarInvestigador(Investigadores investigadores) {
		return iInvestigadoresDAO.save(investigadores);
	}

	@Override
	public void eliminarInvestigador(String dni) {
		iInvestigadoresDAO.deleteById(dni);
	}

}
