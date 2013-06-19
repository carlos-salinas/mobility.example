package com.thingtrack.mobility.example.backend.dao;

import java.util.List;

import com.thingtrack.mobility.backend.domain.Product;

public interface ProductDao {
	
	void save(Product product) throws Exception;
	Product get(Integer id) throws Exception;
	List<Product> getAll() throws Exception;
	void delete(Integer id) throws Exception;
	void update(Product product) throws Exception;
}
