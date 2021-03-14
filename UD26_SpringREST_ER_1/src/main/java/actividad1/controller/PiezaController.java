package actividad1.controller;

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

import actividad1.dto.Pieza;
import actividad1.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl PiezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return PiezaServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		
		return PiezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{id}")
	public Pieza PiezaXID(@PathVariable(name="id") int id) {
		
		Pieza Pieza_xid= new Pieza();
		
		Pieza_xid=PiezaServiceImpl.piezaXID(id);
		
		System.out.println("Pieza XID: "+Pieza_xid);
		
		return Pieza_xid;
	}
	
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		Pieza Pieza_actualizado= new Pieza();
		
		Pieza_seleccionado= PiezaServiceImpl.piezaXID(id);
		
		Pieza_seleccionado.setNombre(pieza.getNombre());
		
		Pieza_actualizado = PiezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("La pieza actualizada es: "+ Pieza_actualizado);
		
		return Pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		PiezaServiceImpl.eliminarPieza(id);
	}
	
	
}
