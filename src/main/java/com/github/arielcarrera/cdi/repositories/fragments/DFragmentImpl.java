package com.github.arielcarrera.cdi.repositories.fragments;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Helper Class for custom JPA queries insidea a Repository Fragment
 *  
 * @author Ariel Carrera
 *
 */
public class DFragmentImpl implements DFragment {

	@Inject
	EntityManager entityManager;
	
	public EntityManager customMethodEntityManager() {
		return entityManager;
	}

	public DFragmentImpl() {
		super();
	}
	
}
