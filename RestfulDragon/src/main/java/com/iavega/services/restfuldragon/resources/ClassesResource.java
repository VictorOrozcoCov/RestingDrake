package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/classes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClassesResource {

	private ClassesResourceImpl classesImpl;

	public ClassesResource() {
		this.classesImpl = new ClassesResourceImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClasses() {
		return classesImpl.getClasses();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getClass(@PathParam("id") String classId) {
		return classesImpl.getClass(classId);
	}
}
