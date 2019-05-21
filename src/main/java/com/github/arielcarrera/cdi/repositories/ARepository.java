package com.github.arielcarrera.cdi.repositories;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.github.arielcarrera.cdi.repositories.fragments.AFragment;
import com.github.arielcarrera.cdi.repositories.fragments.BFragment;

/**
 * Test Repository
 * @author Ariel Carrera <carreraariel@gmail.com>
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ARepository<T, ID extends Serializable>
		extends Repository<T, ID>, AFragment<T,ID>, BFragment<T>
{
}