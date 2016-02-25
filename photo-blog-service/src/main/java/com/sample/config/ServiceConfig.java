package com.sample.config;

import io.swagger.jaxrs.config.BeanConfig;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ServiceConfig extends ResourceConfig{

	public ServiceConfig() {
		register(CORSResponseFilter.class);
		
		register(ObjectMapperResolver.class);
		register(JacksonJsonProvider.class);		
		//Added for swagger configuration
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/photo-blog-service/rest");
        beanConfig.setResourcePackage("com.sample.service");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
        
        
	}
}
