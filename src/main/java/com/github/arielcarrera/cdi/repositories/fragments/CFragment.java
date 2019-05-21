package com.github.arielcarrera.cdi.repositories.fragments;
import java.io.Serializable;

/**
 * Test Fragment
 * @author Ariel Carrera <carreraariel@gmail.com>
 *
 * @param <T>
 * @param <ID>
 */
public interface CFragment<T, ID extends Serializable> extends BFragment<T> {

	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 *
	 * @param entity must not be {@literal null}.
	 * @return the saved entity will never be {@literal null}.
	 */
	<S extends T> S save(S entity);

}