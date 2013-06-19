package com.thingtrack.mobility.example.backend.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.thingtrack.mobility.backend.domain.Product;
import com.thingtrack.mobility.example.backend.dao.ProductDao;

public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Product product) throws Exception {
		entityManager.persist(product);
	}

	@Override
	public Product get(Integer id) throws Exception {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> getAll() throws Exception {
		
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("SELECT p FROM Product p");
		
		TypedQuery<Product> query = entityManager.createQuery(queryBuffer.toString(), Product.class);
		
		return query.getResultList();
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		Product product = entityManager.find(Product.class, id);
		entityManager.remove(product);
	}

	@Override
	public void update(Product product) throws Exception {
		entityManager.merge(product);
	}

}
