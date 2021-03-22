package M7FrontalAJAX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import M7FrontalAJAX.dao.IProductsDAO;
import M7FrontalAJAX.dto.Products;

@Service
public class ProductsServiceImpl implements IProductsService{
	@Autowired
	IProductsDAO iProductsDAO;
	
	@Override
	public List<Products> listarProducts() {
		
		return iProductsDAO.findAll();
	}

	@Override
	public Products guardarProducts(Products products) {
		
		return iProductsDAO.save(products);
	}

	@Override
	public Products productsXID(Long id) {
		
		return iProductsDAO.findById(id).get();
	}

	@Override
	public Products actualizarProducts(Products products) {
		
		return iProductsDAO.save(products);
	}

	@Override
	public void eliminarProducts(Long id) {
		
		iProductsDAO.deleteById(id);
		
	}
}
