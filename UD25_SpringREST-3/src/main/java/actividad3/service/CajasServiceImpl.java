package actividad3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.dao.ICajasDAO;
import actividad3.dto.Cajas;

@Service
public class CajasServiceImpl implements ICajasService{
	//Utilizamos los metodos de la interface ICajasDAO, es como si instaciaramos.
	@Autowired
	ICajasDAO iCajasDAO;

	@Override
	public List<Cajas> listarCajas() {

		return iCajasDAO.findAll();
	}

	@Override
	public Cajas guardarCajas(Cajas cajas) {

		return iCajasDAO.save(cajas);
	}

	@Override
	public Cajas cajasXReferencia(String numreferencia) {

		return iCajasDAO.findById(numreferencia).get();
	}

	@Override
	public Cajas actualizarCajas(Cajas cajas) {

		return iCajasDAO.save(cajas);
	}

	@Override
	public void eliminarCajas(String numreferencia) {
		iCajasDAO.deleteById(numreferencia);
	}
}
