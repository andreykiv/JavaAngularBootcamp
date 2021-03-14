package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.IMaquinasRegistradorasDAO;
import actividad.dto.MaquinasRegistradoras;

@Service
public class MaquinasRegistradorasServiceImpl implements IMaquinasRegistradorasService{
	
	@Autowired
	IMaquinasRegistradorasDAO iMaquinasRegistradorasDAO;

	@Override
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras() {
		return iMaquinasRegistradorasDAO.findAll();
	}

	@Override
	public MaquinasRegistradoras guardarMaquinaRegistradora(MaquinasRegistradoras maquinaRegistradoras) {
		return iMaquinasRegistradorasDAO.save(maquinaRegistradoras);
	}

	@Override
	public MaquinasRegistradoras maquinaRegistradoraXID(int id) {
		return iMaquinasRegistradorasDAO.findById(id).get();
	}

	@Override
	public MaquinasRegistradoras actualizarMaquinaRegistradora(MaquinasRegistradoras maquinaRegistradoras) {
		return iMaquinasRegistradorasDAO.save(maquinaRegistradoras);
	}

	@Override
	public void eliminarMaquinaRegistradora(int id) {
		iMaquinasRegistradorasDAO.deleteById(id);
	}
	
}
