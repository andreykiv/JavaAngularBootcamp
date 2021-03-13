package com.crud.h2.controller;

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

import com.crud.h2.dto.Articulo;
import com.crud.h2.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl articuloServideImpl;
	
	@GetMapping("/articulos")
	public List<Articulo> listarArticulos(){
		return articuloServideImpl.listarArticulos();
	}
	
	@PostMapping("/articulos")
	public Articulo crearArticulo(@RequestBody Articulo articulo) {
		
		return articuloServideImpl.guardarArticulo(articulo);
	}
	
	@GetMapping("/articulos/{id}")
	public Articulo articuloXID(@PathVariable(name="id") Long id) {
		
		Articulo articulo_xid= new Articulo();
		
		articulo_xid = articuloServideImpl.articuloXID(id);
		
		System.out.println("Articulo XID: "+articulo_xid);
		
		return articulo_xid;
	}
	
	@PutMapping("/articulos/{id}")
	public Articulo actualizarArticulo(@PathVariable(name="id")Long id,@RequestBody Articulo articulo) {
		
		Articulo articulo_seleccionado= new Articulo();
		Articulo articulo_actualizado= new Articulo();
		
		articulo_seleccionado= articuloServideImpl.articuloXID(id);
		
		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricante(articulo.getFabricante());
		
		articulo_actualizado = articuloServideImpl.actualizarArticulo(articulo_seleccionado);
		
		System.out.println("El Articulo actualizado es: "+ articulo_actualizado);
		
		return articulo_actualizado;
	}
	
	@DeleteMapping("/articulos/{id}")
	public void eliminarArticulo(@PathVariable(name="id")Long id) {
		articuloServideImpl.eliminarArticulo(id);
	}
	
}
