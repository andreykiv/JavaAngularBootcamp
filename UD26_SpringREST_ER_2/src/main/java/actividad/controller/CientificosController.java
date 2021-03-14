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

import actividad.dto.Cientificos;
import actividad.service.CientificosServiceImpl;


@RestController
@RequestMapping("/api")
public class CientificosController {
	
	@Autowired
	CientificosServiceImpl cientificoServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientificos> listarCientificos(){
		return cientificoServiceImpl.listarCientificos();
	}
	
	
	@PostMapping("/cientificos")
	public Cientificos guardarCientifico(@RequestBody Cientificos cientifico) {
		
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	
	
	@GetMapping("/cientificos/{dni}")
	public Cientificos cientificoXID(@PathVariable(name="dni") String dni) {
		
		Cientificos Cientifico_xid= new Cientificos();
		
		Cientifico_xid=cientificoServiceImpl.cientificoXID(dni);
		
		System.out.println("Cientifico XID: "+Cientifico_xid);
		
		return Cientifico_xid;
	}
	
	@PutMapping("/cientificos/{dni}")
	public Cientificos actualizarCientifico(@PathVariable(name="dni")String dni,@RequestBody Cientificos cientifico) {
		
		Cientificos Cientifico_seleccionado= new Cientificos();
		Cientificos Cientifico_actualizado= new Cientificos();
		
		Cientifico_seleccionado= cientificoServiceImpl.cientificoXID(dni);
		
		Cientifico_seleccionado.setNomapels(cientifico.getNomapels());
		
		Cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(Cientifico_seleccionado);
		
		System.out.println("El Cientifico actualizado es: "+ Cientifico_actualizado);
		
		return Cientifico_actualizado;
	}
	
	@DeleteMapping("/cientificos/{dni}")
	public void eleiminarCientifico(@PathVariable(name="dni")String dni) {
		cientificoServiceImpl.eliminarCientifico(dni);
	}
	
	
}
