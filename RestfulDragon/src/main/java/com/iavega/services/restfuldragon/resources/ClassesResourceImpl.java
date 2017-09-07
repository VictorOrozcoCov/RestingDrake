package com.iavega.services.restfuldragon.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

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

	public Response getClass(String classId) {
		entityManager = emf.createEntityManager();
		TypedQuery<DClass> query = entityManager.createQuery("SELECT e FROM DClass AS e WHERE e.classId = :classId",
				DClass.class);
		query.setParameter("classId", Integer.parseInt(classId));
		List<DClass> selectedClass = query.getResultList();
		return Response.ok().entity(selectedClass).build();
	}
}
