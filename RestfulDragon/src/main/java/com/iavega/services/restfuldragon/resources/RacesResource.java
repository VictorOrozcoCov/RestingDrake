package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/races")
public class RacesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRaces() {
		return "Races!";
	}
}
