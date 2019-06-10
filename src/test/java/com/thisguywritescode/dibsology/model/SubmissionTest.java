package com.thisguywritescode.dibsology.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class SubmissionTest {

	private String VALID_STRING = "test string";
	private User VALID_USER = new User();
	private Submission submission;
	private Date VALID_DATE = new Date();

	@Before
	public void SetUp() {
		submission = new Submission();
	}

	@Test
	public void submissionGetId_returnsZeroForNewObject() {
		assertThat(submission.getId(), is(0));
	}

	@Test
	public void submissionSetTitle_appropriatelySetsTitle() {
		submission.setTitle(VALID_STRING);
		assertThat(submission.getTitle(), is(VALID_STRING));
	}

	@Test
	public void submissionSetText_appropriatelySetsText() {
		submission.setText(VALID_STRING);
		assertThat(submission.getText(), is(VALID_STRING));
	}

	@Test
	public void submissionSetCreated_at_appropriatelySetsCreated_at() {
		submission.setCreated_at(VALID_DATE);
		assertThat(submission.getCreated_at(), is(VALID_DATE));
	}

	@Test
	public void submissionSetUpdated_at_appropriatelySetsUpdated_at() {
		submission.setUpdated_at(VALID_DATE);
		assertThat(submission.getUpdated_at(), is(VALID_DATE));
	}

	@Test
	public void submissionSetUser_appropriatelySetsUser() {
		submission.setUser(VALID_USER);
		assertThat(submission.getUser(), is(VALID_USER));
	}

}
