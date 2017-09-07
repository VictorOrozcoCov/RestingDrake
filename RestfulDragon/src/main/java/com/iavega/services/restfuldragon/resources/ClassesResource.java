package com.iavega.services.restfuldragon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iavega.services.restfuldragon.domain.DClassRequest;

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

	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClass(DClassRequest request) {
		return classesImpl.addClass(request);
	}

	@GET
	@Path("/{id: \\d{1,2}}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClassById(@PathParam("id") String classId) {
		return classesImpl.getClassById(classId);
	}
	
	@GET
	@Path("/{name: \\w{2,}}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClassByName(@PathParam("name") String className) {
		return classesImpl.getClassByName(className);
	}

}
