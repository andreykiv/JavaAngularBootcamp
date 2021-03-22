package M7FrontalAJAX.controller;

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

import M7FrontalAJAX.dto.Products;
import M7FrontalAJAX.service.ProductsServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductsController {
	@Autowired
	ProductsServiceImpl ProductsServideImpl;
	
	@GetMapping("/products")
	public List<Products> listarProducts(){
		return ProductsServideImpl.listarProducts();
	}
	
	//@RequestBody lo eliminamos para que Spring entienda la peticiones x-www-form-urlencoded
	@PostMapping("/products")
	public Products guardarProducts(Products products) {
		
		return ProductsServideImpl.guardarProducts(products);
	}
	
	@GetMapping("/products/{id}")
	public Products productsXID(@PathVariable(name="id") Long id) {
		
		Products Products_xid= new Products();
		
		Products_xid=ProductsServideImpl.productsXID(id);
		
		System.out.println("Products XID: "+Products_xid);
		
		return Products_xid;
	}
	//@RequestBody lo eliminamos para que Spring entienda la peticiones x-www-form-urlencoded
	
	@PutMapping("/products/{id}")
	public Products actualizarProducts(@PathVariable(name="id")Long id, Products products) {
		
		Products Products_seleccionado= new Products();
		Products Products_actualizado= new Products();
		
		Products_seleccionado= ProductsServideImpl.productsXID(id);
		
		Products_seleccionado.setName(products.getName());
		Products_seleccionado.setDetail(products.getDetail());
		Products_seleccionado.setUpdatedAt(products.getUpdatedAt());
		
		Products_actualizado = ProductsServideImpl.actualizarProducts(Products_seleccionado);
		
		System.out.println("El Products actualizado es: "+ Products_actualizado);
		
		return Products_actualizado;
	}
	
	@DeleteMapping("/products/{id}")
	public void eliminarProducts(@PathVariable(name="id")Long id) {
		ProductsServideImpl.eliminarProducts(id);
		System.out.println("Producto eliminado!");
	}
}
