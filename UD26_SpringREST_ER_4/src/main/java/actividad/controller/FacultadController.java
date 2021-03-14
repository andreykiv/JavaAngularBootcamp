package actividad.controller;

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

import actividad.dto.Facultad;
import actividad.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl FacultadServiceImpl;
	
	@GetMapping("/facultad")
	public List<Facultad> listarFacultad(){
		return FacultadServiceImpl.listarFacultades();
	}
	
	
	@PostMapping("/facultad")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		
		return FacultadServiceImpl.guardarFacultad(facultad);
	}
	
	
	@GetMapping("/facultad/{id}")
	public Facultad facultadXID(@PathVariable(name="id") int id) {
		
		Facultad facultad_xid= new Facultad();
		
		facultad_xid=FacultadServiceImpl.facultadXID(id);
		
		System.out.println("Maquina XID: "+facultad_xid);
		
		return facultad_xid;
	}
	
	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= FacultadServiceImpl.facultadXID(id);
		
		facultad_seleccionado.setNombre(facultad.getNombre());
		
		facultad_actualizado = FacultadServiceImpl.actualizarFacultad(facultad_seleccionado);
		
		System.out.println("La facultad actualizada es: "+ facultad_actualizado);
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultad/{id}")
	public void eleiminarFacultad(@PathVariable(name="id")int id) {
		FacultadServiceImpl.eliminarFacultad(id);
	}
	

}
