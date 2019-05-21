package com.github.arielcarrera.cdi.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.demos.jpacditesting.support.JtaEnvironment;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.data.domain.Example;

import com.github.arielcarrera.cdi.repositories.TestRepository;
import com.github.arielcarrera.cdi.test.entities.TestEntity;

public class RepositoryTest {

	@ClassRule
	public static JtaEnvironment jtaEnvironment = new JtaEnvironment();
	@Rule
	public WeldInitiator weld = WeldInitiator.from(new Weld()).activate(RequestScoped.class, ApplicationScoped.class)
				.inject(this).build();
	
	@Inject
	protected EntityManager entityManager;
	
	@Inject
	protected TestRepository repo;

	public RepositoryTest() {
		super();
	}
	
	@Before
	public void load() {
		getEntityManager().getTransaction().begin();
		for (int i = 1; i <= 10; i++) {
			entityManager.persist(new TestEntity(i, i + 100, i + 100));
		}
		getEntityManager().getTransaction().commit();
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Test
	public void findById() {
		getEntityManager().getTransaction().begin();
		Optional<TestEntity> op = repo.findById(1);
		getEntityManager().getTransaction().commit();
		assertNotNull(op);
		assertTrue(op.isPresent());
		assertTrue(op.get().getValue().equals(101));
	}
	
	@Test
	public void customMethodEntityManager() {
		
		EntityManager em = repo.customMethodEntityManager();
		assertNotNull(em);
	}

	@Test
	public void findOne() {
		getEntityManager().getTransaction().begin();
		Optional<TestEntity> op = repo.findOne(Example.of(new TestEntity(1, 101)));
		getEntityManager().getTransaction().commit();
		assertNotNull(op);
		assertTrue(op.isPresent());
		assertTrue(op.get().getValue().equals(101));
	}
	
	@Test
	public void save() {
		getEntityManager().getTransaction().begin();
		TestEntity e = repo.save(new TestEntity(11, 111));
		getEntityManager().getTransaction().commit();
		assertNotNull(e);
	}
	
	@Test
	public void customMethodSave() {
		getEntityManager().getTransaction().begin();
		repo.customMethodSave(new TestEntity(11, 111));
		getEntityManager().getTransaction().commit();
		getEntityManager().getTransaction().begin();
		Optional<TestEntity> op = repo.findById(11);
		getEntityManager().getTransaction().commit();
		assertNotNull(op);
		assertTrue(op.isPresent());
	}
}