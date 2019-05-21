package com.github.arielcarrera.cdi.repositories;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.github.arielcarrera.cdi.repositories.fragments.CFragment;
import com.github.arielcarrera.cdi.repositories.fragments.DFragment;

/**
 * Test Repository
 * @author Ariel Carrera <carreraariel@gmail.com>
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BRepository<T, ID extends Serializable>
		extends ARepository<T, ID>, CFragment<T, ID>, DFragment {

	default void customMethodSave(T entity) {
		customMethodEntityManager().persist(entity);
	}
}
