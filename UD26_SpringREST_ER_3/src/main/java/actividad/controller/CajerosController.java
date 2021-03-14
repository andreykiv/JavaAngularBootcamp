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

import actividad.dto.Cajeros;
import actividad.service.CajerosServiceImpl;


@RestController
@RequestMapping("/api")
public class CajerosController {
	
	@Autowired
	CajerosServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/cajeros")
	public Cajeros guardarCajero(@RequestBody Cajeros cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	
	@GetMapping("/cajeros/{id}")
	public Cajeros cajeroXID(@PathVariable(name="id") int id) {
		
		Cajeros cajero_xid= new Cajeros();
		
		cajero_xid=cajeroServiceImpl.cajeroXID(id);
		
		System.out.println("cajero XID: "+cajero_xid);
		
		return cajero_xid;
	}
	
	@PutMapping("/cajeros/{id}")
	public Cajeros actualizarcajero(@PathVariable(name="id")int id,@RequestBody Cajeros cajero) {
		
		Cajeros cajero_seleccionado= new Cajeros();
		Cajeros cajero_actualizado= new Cajeros();
		
		cajero_seleccionado= cajeroServiceImpl.cajeroXID(id);
		
		cajero_seleccionado.setNomapels(cajero.getNomapels());
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		
		System.out.println("El cajero actualizado es: "+ cajero_actualizado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{id}")
	public void eleiminarcajero(@PathVariable(name="id")int id) {
		cajeroServiceImpl.eliminarCajero(id);
	}
	
	
}
