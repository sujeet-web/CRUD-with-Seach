package com.infotech.corejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infotech.corejava.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
		// + " OR p.brand LIKE %?1%"
		// + " OR p.madein LIKE %?1%"
		// + " OR CONCAT(p.price, '') LIKE %?1%")
		//@Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.brand, ' ', p.madein, ' ', p.price) LIKE %?1%")
		//public List<Product> search(String keyword);
	
	
	 //Note::: For displying all product in UI no need to define any method in ProductRepository.
	
	 //1.searching by name [passing value from UI(iphone).
	 /*@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	 public List<Product> search(String keyword);*///we can use find findAll() i.e=public List<Product> findAll(String keyword);
	// public List<Product> search(String keyword);
	 
	 
	 //2.searching by name,brand and made in from UI.
	/* @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"+ "OR p.brand LIKE %?1%"+ "OR p.madein LIKE %?1%")
	 public List<Product> search(String keyword);*/
	 
	//3. seaching any product by passing any value from UI
	 @Query("SELECT p FROM Product p WHERE "
	                             + "CONCAT(p.id,p.name,p.brand,p.madein,p.price)"
	                             +"LIKE %?1%")
	 public List<Product> search(String keyword);
	 

}
