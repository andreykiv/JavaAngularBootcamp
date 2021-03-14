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

import actividad.dto.Investigadores;
import actividad.service.InvestigadoresServiceImpl;


@RestController
@RequestMapping("/api")
public class InvestigadoresController {
	
	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return investigadoresServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/investigadores")
	public Investigadores guardarInvestigador(@RequestBody Investigadores investigador) {
		
		return investigadoresServiceImpl.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/investigadores/{dni}")
	public Investigadores InvestigadorXID(@PathVariable(name="dni") String dni) {
		
		Investigadores Investigador_xid= new Investigadores();
		
		Investigador_xid=investigadoresServiceImpl.investigadorXID(dni);
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigadores actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigadores investigador) {
		
		Investigadores Investigador_seleccionado= new Investigadores();
		Investigadores Investigador_actualizado= new Investigadores();
		
		Investigador_seleccionado= investigadoresServiceImpl.investigadorXID(dni);
		
		Investigador_seleccionado.setNomapels(investigador.getNomapels());
		Investigador_seleccionado.setFacultad(investigador.getFacultad());
		
		Investigador_actualizado = investigadoresServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: "+ Investigador_actualizado);
		
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public void eleiminarInvestigador(@PathVariable(name="dni")String dni) {
		investigadoresServiceImpl.eliminarInvestigador(dni);
	}
	
	
}
