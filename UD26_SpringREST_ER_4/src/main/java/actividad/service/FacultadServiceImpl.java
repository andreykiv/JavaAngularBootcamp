package actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad.dao.IFacultadDAO;
import actividad.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listarFacultades() {
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(int id) {
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(int id) {
		iFacultadDAO.deleteById(id);
	}
	
}
