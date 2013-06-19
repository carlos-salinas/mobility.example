package com.thingtrack.mobility.example.backend.service;

import java.util.List;

import com.thingtrack.mobility.backend.domain.Product;
import com.thingtrack.mobility.example.backend.dao.ProductDao;

public interface ProductService {
	
	void save(Product product) throws Exception;
	Product get(Integer id) throws Exception;
	List<Product> getAll() throws Exception;
	void delete(Integer id) throws Exception;
	void update(Product product) throws Exception;

}
