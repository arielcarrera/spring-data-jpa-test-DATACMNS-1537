package com.github.arielcarrera.cdi.repositories.fragments;
import java.io.Serializable;
import java.util.Optional;

/**
 * Test Fragment
 * @author Ariel Carrera <carreraariel@gmail.com>
 *
 * @param <T>
 * @param <ID>
 */
public interface AFragment<T, ID extends Serializable> extends DFragment {

	/**
	 * Retrieves an entity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id or {@literal Optional#empty()} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}.
	 */
	Optional<T> findById(ID id);
	
}