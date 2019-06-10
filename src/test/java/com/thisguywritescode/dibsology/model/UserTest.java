package com.thisguywritescode.dibsology.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private final String VALID_STRING = "test string";
	private final User VALID_USER = new User();
	private User user;
	private final Date VALID_DATE = new Date();
	private Submission VALID_SUBMISSION;
	private List<Submission> VALID_SUBMISSION_LIST;

	@Before
	public void SetUp() {
		user = new User();

		VALID_SUBMISSION_LIST = Arrays.asList(VALID_SUBMISSION, VALID_SUBMISSION);
	}

	@Test
	public void userGetId_returnsZeroForNewObject() {
		assertThat(user.getId(), is(0));
	}

	@Test
	public void userSetName_appropriatelySetsName() {
		user.setName(VALID_STRING);
		assertThat(user.getName(), is(VALID_STRING));
	}

	@Test
	public void userSetEmail_appropriatelySetsEmail() {
		user.setEmail(VALID_STRING);
		assertThat(user.getEmail(), is(VALID_STRING));
	}

	@Test
	public void userSetCreated_at_appropriatelySetsCreated_at() {
		user.setCreated_at(VALID_DATE);
		assertThat(user.getCreated_at(), is(VALID_DATE));
	}

	@Test
	public void userSetUpdated_at_appropriatelySetsUpdated_at() {
		user.setUpdated_at(VALID_DATE);
		assertThat(user.getUpdated_at(), is(VALID_DATE));
	}

	@Test
	public void userSetSubmissions_appropriatelySetsSubmissions() {
		user.setSubmissions(VALID_SUBMISSION_LIST);
		assertThat(user.getSubmissions(), is(VALID_SUBMISSION_LIST));
	}

}
