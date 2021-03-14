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

import actividad.dto.Equipos;
import actividad.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {
	
	@Autowired
	EquiposServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/equipos")
	public Equipos guardarEquipo(@RequestBody Equipos equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/equipos/{numserie}")
	public Equipos equipoXID(@PathVariable(name="numserie") String numserie) {
		
		Equipos equipo_xid= new Equipos();
		
		equipo_xid=equipoServiceImpl.equipoXID(numserie);
		
		System.out.println("Equipo XID: "+equipo_xid);
		
		return equipo_xid;
	}
	
	@PutMapping("/equipos/{numserie}")
	public Equipos actualizarequipo(@PathVariable(name="numserie")String numserie,@RequestBody Equipos equipo) {
		
		Equipos equipo_seleccionado= new Equipos();
		Equipos equipo_actualizado= new Equipos();
		
		equipo_seleccionado= equipoServiceImpl.equipoXID(numserie);
		
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		
		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);
		
		System.out.println("El equipo actualizado es: "+ equipo_actualizado);
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{numserie}")
	public void eleiminarequipo(@PathVariable(name="numserie")String numserie) {
		equipoServiceImpl.eliminarEquipo(numserie);
	}
}
