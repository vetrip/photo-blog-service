package com.sample.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ServiceConfig extends ResourceConfig{

	public ServiceConfig() {
		register(CORSResponseFilter.class);
	}
}
