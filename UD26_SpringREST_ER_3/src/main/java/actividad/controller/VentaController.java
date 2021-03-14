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

import actividad.service.VentaServiceImpl;
import actividad.dto.Venta;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/venta")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listarVenta();
	}
	
	
	@PostMapping("/venta")
	public Venta guardarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/venta/{id}")
	public Venta VentaXID(@PathVariable(name="id") int id) {
		
		Venta Venta_xid= new Venta();
		
		Venta_xid=ventaServiceImpl.ventaXID(id);
		
		System.out.println("Venta XID: "+Venta_xid);
		
		return Venta_xid;
	}
	
	@PutMapping("/venta/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id,@RequestBody Venta venta) {
		
		Venta Venta_seleccionado= new Venta();
		Venta Venta_actualizado= new Venta();
		
		Venta_seleccionado= ventaServiceImpl.ventaXID(id);
		
		
		Venta_seleccionado.setCajero(venta.getCajero());
		Venta_seleccionado.setProducto(venta.getProducto());
		Venta_seleccionado.setMaquinaRegistradora(venta.getMaquinaRegistradora());
		
		Venta_actualizado = ventaServiceImpl.actualizarVenta(Venta_seleccionado);
		
		System.out.println("La venta actualizada es: "+ Venta_actualizado);
		
		return Venta_actualizado;
	}
	
	@DeleteMapping("/venta/{id}")
	public void eleiminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
	
	
}
