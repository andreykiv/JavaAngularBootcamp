package actividad4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import actividad4.dto.Salas;
import actividad4.service.SalasServiceImpl;

@RestController
@RequestMapping("/api")
public class SalasController {
	@Autowired
	SalasServiceImpl salasServiceImpl;
	
	@GetMapping("/salas")
	public List<Salas> listarSalas(){
		return salasServiceImpl.listarSalas();
	}
	
	@PostMapping("/salas")
	public Salas crearSalas(@RequestBody Salas salas) {
		
		return salasServiceImpl.guardarSalas(salas);
	}
	
	@GetMapping("/salas/{id}")
	public Salas salasXID(@PathVariable(name="id") Long id) {
		
		Salas salas_xid= new Salas();
		
		salas_xid = salasServiceImpl.SalasXID(id);
		
		System.out.println("Salas XID: "+salas_xid);
		
		return salas_xid;
	}
	
	@PutMapping("/salas/{id}")
	public Salas actualizarSalas(@PathVariable(name="id")Long id,@RequestBody Salas salas) {
		
		Salas salas_seleccionado= new Salas();
		Salas salas_actualizado= new Salas();
		
		salas_seleccionado= salasServiceImpl.SalasXID(id);
		
		salas_seleccionado.setNombre(salas.getNombre());
		salas_seleccionado.setPeliculas(salas.getPeliculas());

		
		salas_actualizado = salasServiceImpl.actualizarSalas(salas_seleccionado);
		
		System.out.println("El Salas actualizado es: "+ salas_actualizado);
		
		return salas_actualizado;
	}
	
	@DeleteMapping("/salas/{id}")
	public void eliminarSalas(@PathVariable(name="id")Long id) {
		salasServiceImpl.eliminarSalas(id);
	}
}
