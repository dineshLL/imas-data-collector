package com.cdap.imas.data.dao;

import com.cdap.imas.datamodals.UrlServicesMap;

public class MetaDataDAO extends BaseDao {

	public void save(UrlServicesMap modal) {
		getDs().save(modal);
	}
	
	public UrlServicesMap get(String hash) {
		return getDs().createQuery(UrlServicesMap.class)
			.field("_id").equal(hash)
			.get();
	}
	
}
