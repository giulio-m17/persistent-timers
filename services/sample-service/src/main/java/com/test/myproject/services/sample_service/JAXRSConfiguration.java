package com.test.myproject.services.sample_service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class JAXRSConfiguration extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Set<Class<?>> resources = new HashSet();
		
		resources.add(MyBean.class);
		
		return resources;
	}
}
