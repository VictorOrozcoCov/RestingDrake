package com.iavega.services.restfuldragon.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import com.iavega.services.restfuldragon.domain.DRaceRequest;
import com.iavega.services.restfuldragon.models.DRace;

public class RacesResourceImpl {

	public RacesResourceImpl() {

	}

	private static EntityManagerFactory emf;

	private static EntityManager entityManager;

	public Response getRaces() {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DRace> query = entityManager.createQuery("FROM DRace", DRace.class);
		List<DRace> allRaces = query.getResultList();
		return Response.ok().entity(allRaces).build();
	}

	public Response getRaceById(String raceId) {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DRace> query = entityManager.createQuery("SELECT e FROM DRace AS e WHERE e.raceId = :raceId",
				DRace.class);
		query.setParameter("raceId", Integer.parseInt(raceId));
		List<DRace> selectedRace = query.getResultList();
		return Response.ok().entity(selectedRace).build();
	}
	
	public Response getRaceByName(String raceName) {
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();
		TypedQuery<DRace> query = entityManager.createQuery("SELECT e FROM DRace AS e WHERE e.raceName = :raceName",
				DRace.class);
		String raceNameValue = raceName.substring(0, 1).toUpperCase() + raceName.substring(1).toLowerCase();
		query.setParameter("raceName", raceNameValue);
		List<DRace> selectedRace = query.getResultList();
		return Response.ok().entity(selectedRace).build();
	}

	public Response addRace(DRaceRequest request) {
		if (request == null)
			return Response.status(400).entity("Empty request.").build();
		if (request.getName() == null || request.getName().isEmpty())
			return Response.status(400).entity("Empty body.").build();

		List<String> names = request.getName();
		emf = Persistence.createEntityManagerFactory("PersistenceApplication");
		entityManager = emf.createEntityManager();

		for (String name : names) {
			DRace dRace = new DRace();
			String raceName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			dRace.setRaceName(raceName);

			System.out.println(dRace);
			entityManager.getTransaction().begin();
			entityManager.persist(dRace);
			entityManager.getTransaction().commit();
			entityManager.detach(dRace);
		}

		return Response.accepted().entity(names).build();
	}
}
