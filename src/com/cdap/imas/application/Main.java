package com.cdap.imas.application;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cdap.imas.filters.CorsFilter;
import com.cdap.imas.resources.HashDataResource;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("api")
public class Main extends Application {
	Logger LOGGER = Logger.getLogger(Main.class.getName());

	public Main() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("PENSIONS LIVE BACK END");
		beanConfig.setVersion("1.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("sathkara.pensions.gov.lk:8080/pms_dev");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("com.cdap.imas.resources");
		beanConfig.setScan(true);
		
	}

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> resources = new HashSet<Class<?>>();

		/******* resource mappings *********/
		resources.add(HashDataResource.class);
		
		
		/***** filter mappings ******/
		resources.add(CorsFilter.class);


		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		return resources;
	}

}
