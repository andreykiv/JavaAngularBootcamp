package M7FrontalAJAX.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import M7FrontalAJAX.dto.Products;

public interface IProductsDAO extends JpaRepository<Products, Long>{
	
}
