package actividad2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad2.dao.IDepartamentoDAO;
import actividad2.dto.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {
	//Utilizamos los metodos de la interface IDepartamentoDAO, es como si instaciaramos.
	@Autowired
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listarDepartamentos() {

		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento departamentoXID(Long id) {

		return iDepartamentoDAO.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		iDepartamentoDAO.deleteById(id);
	}
}
