package actividad3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import actividad3.dto.Almacenes;
import actividad3.service.AlmacenesServiceImpl;

@RestController
@RequestMapping("/api")
public class AlmacenesController {
	@Autowired
	AlmacenesServiceImpl almaceneServiceImpl;
	
	@GetMapping("/almacenes")
	public List<Almacenes> listarAlmacenes(){
		return almaceneServiceImpl.listarAlmacenes();
	}
	
	@PostMapping("/almacenes")
	public Almacenes crearAlmacenes(@RequestBody Almacenes almacenes) {
		
		return almaceneServiceImpl.guardarAlmacenes(almacenes);
	}
	
	@GetMapping("/almacenes/{id}")
	public Almacenes almacenesXID(@PathVariable(name="id") Long id) {
		
		Almacenes almacenes_xid= new Almacenes();
		
		almacenes_xid = almaceneServiceImpl.almacenesXID(id);
		
		System.out.println("almacenes XID: "+almacenes_xid);
		
		return almacenes_xid;
	}
	
	@PutMapping("/almacenes/{id}")
	public Almacenes actualizarAlmacenes(@PathVariable(name="id")Long id,@RequestBody Almacenes almacenes) {
		
		Almacenes almacenes_seleccionado= new Almacenes();
		Almacenes almacenes_actualizado= new Almacenes();
		
		almacenes_seleccionado= almaceneServiceImpl.almacenesXID(id);
		
		almacenes_seleccionado.setLugar(almacenes.getLugar());
		almacenes_seleccionado.setCapacidad(almacenes.getCapacidad());
		almacenes_seleccionado.setCajas(almacenes.getCajas());

		
		almacenes_actualizado = almaceneServiceImpl.actualizarAlmacenes(almacenes_seleccionado);
		
		System.out.println("El almacenes actualizado es: "+ almacenes_actualizado);
		
		return almacenes_actualizado;
	}
	
	@DeleteMapping("/almacenes/{id}")
	public void eliminarAlmacenes(@PathVariable(name="id")Long id) {
		almaceneServiceImpl.eliminarAlmacenes(id);
	}
}
