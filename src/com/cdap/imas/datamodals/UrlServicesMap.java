package com.cdap.imas.datamodals;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("url-micro-services-map")
public class UrlServicesMap {

	@Id private String hash;
	@Property private String url;
	@Property private String method;
	@Property private List<String> executedMicroServices;
	
	public UrlServicesMap() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public List<String> getExecutedMicroServices() {
		return executedMicroServices;
	}

	public void setExecutedMicroServices(List<String> executedMicroServices) {
		this.executedMicroServices = executedMicroServices;
	}
	
}
