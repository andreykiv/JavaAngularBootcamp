package actividad4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad4.dao.IPeliculasDAO;
import actividad4.dto.Peliculas;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
	//Utilizamos los metodos de la interface IPeliculasDAO, es como si instaciaramos.
	@Autowired
	IPeliculasDAO iPeliculasDAO;

	@Override
	public List<Peliculas> listarPeliculas() {

		return iPeliculasDAO.findAll();
	}

	@Override
	public Peliculas guardarPeliculas(Peliculas peliculas) {

		return iPeliculasDAO.save(peliculas);
	}

	@Override
	public Peliculas PeliculasXID(Long id) {

		return iPeliculasDAO.findById(id).get();
	}

	@Override
	public Peliculas actualizarPeliculas(Peliculas peliculas) {

		return iPeliculasDAO.save(peliculas);
	}

	@Override
	public void eliminarPeliculas(Long id) {
		iPeliculasDAO.deleteById(id);
	}
}
