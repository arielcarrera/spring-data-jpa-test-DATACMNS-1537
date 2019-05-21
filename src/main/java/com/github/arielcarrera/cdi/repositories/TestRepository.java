package com.github.arielcarrera.cdi.repositories;

import org.springframework.data.repository.cdi.Eager;

import com.github.arielcarrera.cdi.test.entities.TestEntity;

@Eager
public interface TestRepository extends BRepository<TestEntity, Integer>{

}
