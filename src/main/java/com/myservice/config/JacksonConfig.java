package com.myservice.config;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {

	private ObjectMapper objectMapper = objectMapperX();

    private ObjectMapper objectMapperX() {
    	String format = "yyyy-MM-dd";
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        objectMapper = builder.build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        
        objectMapper.setDateFormat(dateFormat);
        
        return objectMapper;
    }

	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}

}
