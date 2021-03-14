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

import actividad.dto.MaquinasRegistradoras;
import actividad.service.MaquinasRegistradorasServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinasRegistradorasController {
	
	@Autowired
	MaquinasRegistradorasServiceImpl maquinasRegistradorasServiceImpl;
	
	@GetMapping("/maquinasRegistradoras")
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(){
		return maquinasRegistradorasServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinasRegistradoras")
	public MaquinasRegistradoras guardarmaquinaRegistradora(@RequestBody MaquinasRegistradoras maquinaRegistradora) {
		
		return maquinasRegistradorasServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	
	@GetMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras maquinaRegistradoraXID(@PathVariable(name="id") int id) {
		
		MaquinasRegistradoras maquinaRegistradora_xid= new MaquinasRegistradoras();
		
		maquinaRegistradora_xid=maquinasRegistradorasServiceImpl.maquinaRegistradoraXID(id);
		
		System.out.println("Maquina XID: "+maquinaRegistradora_xid);
		
		return maquinaRegistradora_xid;
	}
	
	@PutMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras actualizarMaquinaRegistradora(@PathVariable(name="id")int id,@RequestBody MaquinasRegistradoras maquinaRegistradora) {
		
		MaquinasRegistradoras maquinaRegistradora_seleccionado= new MaquinasRegistradoras();
		MaquinasRegistradoras maquinaRegistradora_actualizado= new MaquinasRegistradoras();
		
		maquinaRegistradora_seleccionado= maquinasRegistradorasServiceImpl.maquinaRegistradoraXID(id);
		
		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradora_actualizado = maquinasRegistradorasServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);
		
		System.out.println("La maquinaRegistradora actualizada es: "+ maquinaRegistradora_actualizado);
		
		return maquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinasRegistradoras/{id}")
	public void eleiminarmaquinaRegistradora(@PathVariable(name="id")int id) {
		maquinasRegistradorasServiceImpl.eliminarMaquinaRegistradora(id);
	}
	

}
