package com.thisguywritescode.dibsology.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubmissionRepositoryTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	SubmissionRepository submissionRepository;

	private Submission submission;
	private User user;

	private int SUBMISSION_ID = 0;
	private int USER_ID = 0;
	private List<Submission> resultList;

	@Before
	public void setUp() {
		entityManager.flush();
		user = new User();
		submission = new Submission();
		entityManager.persist(user);
		submission.setUser(user);

		resultList = new ArrayList<Submission>();

		SUBMISSION_ID = submission.getId();
		USER_ID = user.getId();
	}

	@Test
	public void setUp_hasProperlyInstantiated() {
		assertThat(submissionRepository, is(notNullValue()));
		assertThat(entityManager, is(notNullValue()));
	}

	@Test
	public void findByUserId_returnsListOfOne_whenDatabaseContainsOneMatch() {
		entityManager.persist(submission);
		resultList.add(submission);

		List<Submission> result = submissionRepository.findByUserId(USER_ID);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByUserId_returnsListOfMany_whenDatabaseContainsMultipleMatches() {
		entityManager.persist(submission);
		resultList.add(submission);
		Submission submission2 = new Submission();
		submission2.setUser(user);
		entityManager.persist(submission2);
		resultList.add(submission2);

		List<Submission> result = submissionRepository.findByUserId(USER_ID);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByUserId_returnsEmptyList_whenDatabaseContainsNoMatches() {
		entityManager.clear();
		resultList = new ArrayList<Submission>();

		List<Submission> result = submissionRepository.findByUserId(USER_ID);
		assertThat(result, is(resultList));
	}

	@After
	public void tearDown() {
		entityManager.clear();
	}

}
