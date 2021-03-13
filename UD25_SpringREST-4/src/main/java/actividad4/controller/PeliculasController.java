package actividad4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import actividad4.dto.Peliculas;
import actividad4.service.PeliculasServiceImpl;


@RestController
@RequestMapping("/api")
public class PeliculasController {
	@Autowired
	PeliculasServiceImpl peliculasServiceImpl;
	
	@GetMapping("/peliculas")
	public List<Peliculas> listarPeliculas(){
		return peliculasServiceImpl.listarPeliculas();
	}
	
	@PostMapping("/peliculas")
	public Peliculas crearPeliculas(@RequestBody Peliculas peliculas) {
		
		return peliculasServiceImpl.guardarPeliculas(peliculas);
	}
	
	@GetMapping("/peliculas/{id}")
	public Peliculas PeliculasXID(@PathVariable(name="id") Long id) {
		
		Peliculas peliculas_xID= new Peliculas();
		
		peliculas_xID = peliculasServiceImpl.PeliculasXID(id);
		
		System.out.println("Peliculas XDNI: "+peliculas_xID);
		
		return peliculas_xID;
	}
	
	@PutMapping("/peliculas/{id}")
	public Peliculas actualizarPeliculas(@PathVariable(name="id")Long id,@RequestBody Peliculas peliculas) {
		
		Peliculas peliculas_seleccionado= new Peliculas();
		Peliculas peliculas_actualizado= new Peliculas();
		
		peliculas_seleccionado= peliculasServiceImpl.PeliculasXID(id);
		
		peliculas_seleccionado.setNombre(peliculas.getNombre());
		peliculas_seleccionado.setCalificacionedad(peliculas.getCalificacionedad());

		
		peliculas_actualizado = peliculasServiceImpl.actualizarPeliculas(peliculas_seleccionado);
		
		System.out.println("La Pelicula actualizada es: "+ peliculas_actualizado);
		
		return peliculas_actualizado;
	}
	
	@DeleteMapping("/peliculas/{id}")
	public void eliminarPeliculas(@PathVariable(name="id")Long id) {
		peliculasServiceImpl.eliminarPeliculas(id);
	}
}
