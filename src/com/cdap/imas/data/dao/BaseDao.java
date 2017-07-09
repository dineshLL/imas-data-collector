package com.cdap.imas.data.dao;

import org.mongodb.morphia.Datastore;

import com.cdap.imas.data.MongoConnectionManager;

public class BaseDao {

	private Datastore store = null;
	
	public BaseDao() {
		this.store = MongoConnectionManager.GET_MANAGER.getStore();
	}
	
	public Datastore getDs() {
		return this.store;
	}
	
}
