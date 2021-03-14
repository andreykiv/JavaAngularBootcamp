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

import actividad.dto.Productos;
import actividad.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductosController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarproductoes(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Productos guardarproducto(@RequestBody Productos producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/productos/{id}")
	public Productos productoXID(@PathVariable(name="id") int id) {
		
		Productos producto_xid= new Productos();
		
		producto_xid=productoServiceImpl.productoXID(id);
		
		System.out.println("producto XID: "+producto_xid);
		
		return producto_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Productos actualizarproducto(@PathVariable(name="id")int id,@RequestBody Productos producto) {
		
		Productos producto_seleccionado= new Productos();
		Productos producto_actualizado= new Productos();
		
		producto_seleccionado= productoServiceImpl.productoXID(id);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("El producto actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eleiminarproducto(@PathVariable(name="id")int id) {
		productoServiceImpl.eliminarProducto(id);
	}
}
