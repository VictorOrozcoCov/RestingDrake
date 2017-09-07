package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/races")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RacesResource {

	private RacesResourceImpl racesImpl;

	public RacesResource() {
		this.racesImpl = new RacesResourceImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRaces() {
		return racesImpl.getRaces();
	}

	@GET()
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRace(@PathParam("id") String raceId) {
		return racesImpl.getRace(raceId);
	}
}
