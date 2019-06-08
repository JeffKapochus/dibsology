package com.thisguywritescode.dibsology.repository;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

@DataJpaTest
public class SubmissionRepositoryTest {
	
	//@Autowired
	//@PersistenceContext
	//private EntityManager entityManager;
	
	@Autowired
	SubmissionRepository submissionRepository;
	
	private Submission submission;

	@Before
	public void setUp() {
		//entityManager = EntityManagerFactory.
		//User user = new User("Test name", "Test Email");
		//submission = new Submission("Test Title", "Test Description", user);
		//entityManager.persist(submission);
	}
	
	@Test
	public void setUp_hasProperlyInstantiated() {
		//assertThat(entityManager, is(notNullValue()));
	}
	
	@Test
	public void test() {
		Submission result = submissionRepository.getOne(1);
		assertThat(result, is(submission));
	}

}
