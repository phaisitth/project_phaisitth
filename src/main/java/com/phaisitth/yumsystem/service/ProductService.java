package com.phaisitth.yumsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phaisitth.yumsystem.entity.Product;
import com.phaisitth.yumsystem.repository.ProductRepository;




@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//Search DB if have a keyword It's will show.
	public List<Product> listAll(String keyword){
		
		if(keyword!=null) {
			return productRepository.search(keyword);
		}
		return productRepository.findAll();
	}
	
	//Read all DB
	public Product get(int id) {
		return productRepository.findById(id).get();
	}
	
	//Save current Edited
	public void save(Product product) {
		productRepository.save(product);
	}
	
	//Delete item
	public void delete(int id) {
		productRepository.deleteById(id);
	}
}