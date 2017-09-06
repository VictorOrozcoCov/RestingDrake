package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/classes")
public class ClassesResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getClasses() {
		return "Classes!";
	}
}
