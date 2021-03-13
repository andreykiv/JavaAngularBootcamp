package actividad3.controller;

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

import actividad3.dto.Cajas;
import actividad3.service.CajasServiceImpl;

@RestController
@RequestMapping("/api")
public class CajasController {
	@Autowired
	CajasServiceImpl cajaServiceImpl;
	
	@GetMapping("/cajas")
	public List<Cajas> listarCajas(){
		return cajaServiceImpl.listarCajas();
	}
	
	@PostMapping("/cajas")
	public Cajas crearCajas(@RequestBody Cajas cajas) {
		
		return cajaServiceImpl.guardarCajas(cajas);
	}
	
	@GetMapping("/cajas/{numreferencia}")
	public Cajas CajasXID(@PathVariable(name="numreferencia") String numreferencia) {
		
		Cajas cajas_xNumReferencia= new Cajas();
		
		cajas_xNumReferencia = cajaServiceImpl.cajasXReferencia(numreferencia);
		
		System.out.println("Cajas XDNI: "+cajas_xNumReferencia);
		
		return cajas_xNumReferencia;
	}
	
	@PutMapping("/cajas/{numreferencia}")
	public Cajas actualizarCajas(@PathVariable(name="numreferencia")String numreferencia,@RequestBody Cajas cajas) {
		
		Cajas cajas_seleccionado= new Cajas();
		Cajas cajas_actualizado= new Cajas();
		
		cajas_seleccionado= cajaServiceImpl.cajasXReferencia(numreferencia);
		
		cajas_seleccionado.setContenido(cajas.getContenido());
		cajas_seleccionado.setValor(cajas.getValor());
		cajas_seleccionado.setAlmacen(cajas.getAlmacen());

		
		cajas_actualizado = cajaServiceImpl.actualizarCajas(cajas_seleccionado);
		
		System.out.println("El Cajas actualizado es: "+ cajas_actualizado);
		
		return cajas_actualizado;
	}
	
	@DeleteMapping("/cajas/{numreferencia}")
	public void eliminarCajas(@PathVariable(name="dni")String numreferencia) {
		cajaServiceImpl.eliminarCajas(numreferencia);
	}
}
