package com.thingtrack.mobility.example.backend.integration.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestServiceDeployer extends Application{

	@Override
	public Set<Class<?>> getClasses() {
	
		Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ProductRestService.class);
        
        return classes;
	}
}
