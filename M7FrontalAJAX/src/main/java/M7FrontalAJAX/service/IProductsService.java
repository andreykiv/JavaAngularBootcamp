package M7FrontalAJAX.service;

import java.util.List;

import M7FrontalAJAX.dto.Products;


public interface IProductsService {
	//Metodos del CRUD
	public List<Products> listarProducts(); //Listar All 
	
	public Products guardarProducts(Products products);	//Guarda un Products CREATE
	
	public Products productsXID(Long id); //Leer datos de un Products READ
	
	public Products actualizarProducts(Products products); //Actualiza datos del Products UPDATE
	
	public void eliminarProducts(Long id);// Elimina el Products DELETE
}
