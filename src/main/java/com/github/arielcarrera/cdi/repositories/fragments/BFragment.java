package com.github.arielcarrera.cdi.repositories.fragments;

import java.util.Optional;

import org.springframework.data.domain.Example;

/**
 * Test Fragment
 * @author Ariel Carrera <carreraariel@gmail.com>
 *
 * @param <T>
 */
public interface BFragment<T> {

	/**
	 * Returns a single entity matching the given {@link Example} or {@literal null} if none was found.
	 *
	 * @param example must not be {@literal null}.
	 * @return a single entity matching the given {@link Example} or {@link Optional#empty()} if none was found.
	 * @throws org.springframework.dao.IncorrectResultSizeDataAccessException if the Example yields more than one result.
	 */
	<S extends T> Optional<S> findOne(Example<S> example);

}
