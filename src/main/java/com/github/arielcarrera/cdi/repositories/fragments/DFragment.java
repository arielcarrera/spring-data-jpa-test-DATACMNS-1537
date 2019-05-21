package com.github.arielcarrera.cdi.repositories.fragments;

import javax.persistence.EntityManager;

/**
 * Interface that provides custom methods for work with JPA inside Repository Fragments
 *  
 * @author Ariel Carrera
 *
 */
public interface DFragment {

	EntityManager customMethodEntityManager();
	
}
