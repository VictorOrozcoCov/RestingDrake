package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iavega.services.restfuldragon.domain.DRaceRequest;

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

	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRace(DRaceRequest request) {
		return racesImpl.addRace(request);
	}

	@GET()
	@Path("/{id: \\d{1,2}}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRaceById(@PathParam("id") String raceId) {
		return racesImpl.getRaceById(raceId);
	}
	
	@GET
	@Path("/{name: \\w{2,}}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRaceByName(@PathParam("name") String raceName) {
		return racesImpl.getRaceByName(raceName);
	}
}
