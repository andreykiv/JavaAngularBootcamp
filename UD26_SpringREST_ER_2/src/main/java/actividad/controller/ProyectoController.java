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

import actividad.dto.Proyecto;
import actividad.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl ProyectoServiceImpl;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectoes(){
		return ProyectoServiceImpl.listarProyectos();
	}
	
	
	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto Proyecto) {
		
		return ProyectoServiceImpl.guardarProyecto(Proyecto);
	}
	
	
	@GetMapping("/proyectos/{id}")
	public Proyecto ProyectoXID(@PathVariable(name="id") String id) {
		
		Proyecto Proyecto_xid= new Proyecto();
		
		Proyecto_xid=ProyectoServiceImpl.ProyectoXID(id);
		
		System.out.println("Proyecto XID: "+Proyecto_xid);
		
		return Proyecto_xid;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= ProyectoServiceImpl.ProyectoXID(id);
		
		Proyecto_seleccionado.setNombre(proyecto.getNombre());
		Proyecto_seleccionado.setHoras(proyecto.getHoras());
		
		Proyecto_actualizado = ProyectoServiceImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El Proyecto actualizado es: "+ Proyecto_actualizado);
		
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")String id) {
		ProyectoServiceImpl.eliminarProyecto(id);
	}
}
