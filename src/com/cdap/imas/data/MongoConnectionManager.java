package com.cdap.imas.data;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public enum MongoConnectionManager {
	
	GET_MANAGER;
	
	private Datastore store = null;
	
	private MongoConnectionManager() {
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.cdap.imas.datamodals");
		
		store = morphia.createDatastore(new MongoClient("localhost" , 27017), "imas-datastore");
		store.ensureIndexes();
	}
	
	public Datastore getStore() {
		return this.store;
	}
	
}
