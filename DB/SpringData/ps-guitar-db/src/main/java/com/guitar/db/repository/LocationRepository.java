package com.guitar.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.guitar.db.model.Location;

@Repository
public class LocationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Location create(Location location) {
		entityManager.persist(location);
		entityManager.flush();
		return location;
	}

	public Location find(Long id) {
		return entityManager.find(Location.class, id);
	}

	public Location update(Location location) {
		location = entityManager.merge(location);
		entityManager.flush();
		return location;
	}

	public void delete(Location location) {
		entityManager.remove(location);
		entityManager.flush();
	}

	/**
	 * Custom finder
	 */
	public List<Location> getLocationByStateName(String name) {
		List<Location> locations = entityManager
				.createQuery("select l from Location l where l.state like :state")
				.setParameter("state", name + "%").getResultList();
		return locations;
	}
}
