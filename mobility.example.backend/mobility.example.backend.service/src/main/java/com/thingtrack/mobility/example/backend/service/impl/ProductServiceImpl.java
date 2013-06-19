package com.thingtrack.mobility.example.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.mobility.backend.domain.Product;
import com.thingtrack.mobility.example.backend.dao.ProductDao;
import com.thingtrack.mobility.example.backend.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public void save(Product product) throws Exception {
		productDao.save(product);
	}

	@Override
	public Product get(Integer id) throws Exception {
		return productDao.get(id);
	}

	@Override
	public List<Product> getAll() throws Exception {
		return productDao.getAll();
	}

	@Override
	public void delete(Integer id) throws Exception {
		productDao.delete(id);
	}

	@Override
	public void update(Product product) throws Exception {
		productDao.update(product);
	}

}
