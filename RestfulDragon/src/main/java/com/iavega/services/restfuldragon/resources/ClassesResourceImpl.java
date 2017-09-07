package com.iavega.services.restfuldragon.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import com.iavega.services.restfuldragon.domain.DClassRequest;
import com.iavega.services.restfuldragon.models.DClass;

public class ClassesResourceImpl {

	public ClassesResourceImpl() {

	}

	private static EntityManagerFactory emf;

	private static EntityManager entityManager;

	public Response getClasses() {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DClass> query = entityManager.createQuery("FROM DClass", DClass.class);
		List<DClass> allClasses = query.getResultList();
		return Response.ok().entity(allClasses).build();
	}

	public Response getClassById(String classId) {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DClass> query = entityManager.createQuery("SELECT e FROM DClass AS e WHERE e.classId = :classId",
				DClass.class);
		query.setParameter("classId", Integer.parseInt(classId));
		List<DClass> selectedClass = query.getResultList();
		return Response.ok().entity(selectedClass).build();
	}
	
	public Response getClassByName(String className) {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DClass> query = entityManager.createQuery("SELECT e FROM DClass AS e WHERE e.className = :className",
				DClass.class);
		String classNameValue = className.substring(0, 1).toUpperCase() + className.substring(1).toLowerCase();
		query.setParameter("className", classNameValue);
		List<DClass> selectedClass = query.getResultList();
		return Response.ok().entity(selectedClass).build();
	}

	public Response addClass(DClassRequest request) {
		if (request == null)
			return Response.status(400).entity("Empty request.").build();
		if (request.getName() == null || request.getName().isEmpty()) 
			return Response.status(400).entity("Empty body.").build();
		
		List<String> names = request.getName();
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();

		for (String name : names) {
			DClass dClass = new DClass();
			String className = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			dClass.setClassName(className);

			System.out.println(dClass);
			entityManager.getTransaction().begin();
			entityManager.persist(dClass);
			entityManager.getTransaction().commit();
			entityManager.detach(dClass);
		}

		return Response.accepted().entity(names).build();
	}
}
