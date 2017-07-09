package com.cdap.imas.services;

import java.util.ArrayList;
import java.util.List;

import com.cdap.imas.data.dao.MetaDataDAO;
import com.cdap.imas.datamodals.UrlServicesMap;
import com.cdap.imas.modal.ImasMeta;

import javafx.concurrent.Task;

/**
 * handles the imas meta data
 * @author Dinesh
 *
 */
public class ImasMetaDataService {

	/**
	 * handle the inbound meta data
	 * 
	 */
	public void handleInboundImasMeta(ImasMeta meta) {
		MetaDataDAO dao = new MetaDataDAO();
		
		switch (meta.getInboundType()) {
		case ImasMeta.FROM_API_GATEWAY: {
			if(dao.get(meta.getHash()) == null) {
				UrlServicesMap modal = new UrlServicesMap();
				modal.setHash(meta.getHash());
				modal.setMethod(meta.getHttpMethod());
				modal.setUrl(meta.getUrl());
				
				dao.save(modal);
			}
			break;
		}
		
		case ImasMeta.FROM_MICROSERVICE: {
			UrlServicesMap map = dao.get(meta.getHash());
			if(map.getExecutedMicroServices() == null) {
				List<String> list = new ArrayList<>();
				list.add(meta.getContainerId());
				
				map.setExecutedMicroServices(list);
				dao.save(map);
				
			} else {
				String isAvailable = map.getExecutedMicroServices()
					.parallelStream()
					.filter(i -> i.equals(meta.getContainerId()))
					.findAny().orElse(null);
				
				if(isAvailable == null) {
					map.getExecutedMicroServices().add(meta.getContainerId());
					dao.save(map);
				}
			}
			
			
		}
		default:
			break;
		}
	}
	
	
	/**
	 * class for handling the meta data storing
	 * @author Dinesh
	 *
	 */
	private class InboundMetaHandlerTask extends Task<Void> {
		private final ImasMeta meta;
		
		public InboundMetaHandlerTask(ImasMeta meta) {
			this.meta = meta;
		}
		
		@Override
		protected Void call() throws Exception {
			MetaDataDAO dao = new MetaDataDAO();
			switch (meta.getInboundType()) {
			case ImasMeta.FROM_API_GATEWAY: {
				if(dao.get(meta.getHash()) == null) {
					UrlServicesMap modal = new UrlServicesMap();
					modal.setHash(meta.getHash());
					modal.setMethod(meta.getHttpMethod());
					modal.setUrl(meta.getUrl());
					
					dao.save(modal);
				}
				break;
			}
			
			default:
				break;
			}
			
			return null;
		}
		
	}
	
}
