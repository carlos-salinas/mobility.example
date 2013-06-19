package com.thingtrack.mobility.example.backend.integration.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thingtrack.mobility.backend.domain.Product;
import com.thingtrack.mobility.example.backend.service.ProductService;

@Component
@Path("/product")
public class ProductRestService {

	@Autowired
	private ProductService productService;

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll() {

		try {
			return productService.getAll();
		} catch (Exception e) {
			throw new RuntimeException("No product found");
		}
	}

	// Defines that the next path parameter after product is
	// treated as a parameter and passed to the service layer
	// Allows to type http://localhost:8080/BASE_URL/product/1
	// 1 will be treaded as parameter product and passed to productService
	@GET
	@Path("{product}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product get(@PathParam("product") Integer id) {

		try {
			return productService.get(id);
		} catch (Exception e) {
			throw new RuntimeException("product not found with that id: " + id);
		}
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Product product) throws IOException {
		
		try {
			productService.save(product);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Product product) throws IOException {
		
		try {
			productService.update(product);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	@DELETE
	@Path("{product}")
	public void delete(@PathParam("product") Integer id){
		
		try {
			productService.delete(id);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
