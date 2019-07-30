package com.myservice.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.myservice.bean.Custom;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
    	register(Custom.class);
        register(JacksonConfig.class);
    }
}
