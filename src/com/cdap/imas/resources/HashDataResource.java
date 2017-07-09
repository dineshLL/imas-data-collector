package com.cdap.imas.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cdap.imas.modal.ImasMeta;
import com.cdap.imas.services.ImasMetaDataService;


@Path("/data")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HashDataResource {

	@POST
	public Response recieveImasMeta(ImasMeta meta) {
		ImasMetaDataService service = new ImasMetaDataService();
		service.handleInboundImasMeta(meta);
		return Response.ok().build();
	}
	
}
