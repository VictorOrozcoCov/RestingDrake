package com.iavega.services.restfuldragon.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

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

	public Response getRace(String raceId) {
		TypedQuery<DRace> query = entityManager.createQuery("SELECT e FROM DRace AS e WHERE e.raceId = :raceId",
				DRace.class);
		query.setParameter("raceId", Integer.parseInt(raceId));
		List<DRace> selectedRace = query.getResultList();
		return Response.ok().entity(selectedRace).build();
	}

}
