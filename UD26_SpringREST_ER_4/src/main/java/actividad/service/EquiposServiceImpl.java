package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.IEquiposDAO;
import actividad.dto.Equipos;


@Service
public class EquiposServiceImpl implements IEquiposService {
	
	@Autowired
	IEquiposDAO iEquipoDAO;

	@Override
	public List<Equipos> listarEquipos() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipos guardarEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipos equipoXID(String numserie) {
		return iEquipoDAO.findById(numserie).get();
	}

	@Override
	public Equipos actualizarEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(String numserie) {
		iEquipoDAO.deleteById(numserie);
	}

}
