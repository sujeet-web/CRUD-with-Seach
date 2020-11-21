package com.infotech.corejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.corejava.entity.Product;
import com.infotech.corejava.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	//1.Based on change on controller class i changed here also seacring by name(iphone) but its hardcoded.
	/*public List<Product> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}*/
	
	//2. Geeting all product from DB.
	/*public List<Product> listAll() {
		return repo.findAll();
	}*/
	//3. Now we are passing the keyword from UI.
	public List<Product> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
		
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
