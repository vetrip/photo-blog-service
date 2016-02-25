package com.sample.config;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperResolver() {
        System.out.println("new ObjectMapperResolver()");
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.registerModule(new Hibernate4Module());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("ObjectMapperResolver.getContext(...)");
        return mapper;
    }
}