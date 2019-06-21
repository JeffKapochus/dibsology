package com.thisguywritescode.dibsology.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SubmissionTest {

	private final String VALID_STRING = "test string";
	private final User VALID_USER = new User();
	private Submission submission;
	private final Date VALID_DATE = new Date();
	private List<Party> VALID_PARTIES_LIST;

	@Before
	public void SetUp() {
		submission = new Submission();
		
		VALID_PARTIES_LIST = new ArrayList<Party>();
		VALID_PARTIES_LIST.add(new Party());
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
	public void submissionSetUser_appropriatelySetsUser() {
	    submission.setUser(VALID_USER);
	    assertThat(submission.getUser(), is(VALID_USER));
	}
	
	@Test
	public void submissionSetParties_appropriatelySetsParties() {
	    submission.setParties(VALID_PARTIES_LIST);
	    assertThat(submission.getParties(), is(VALID_PARTIES_LIST));
	}

	@Test
	public void submissionSetCreatedAt_appropriatelySetsCreatedAt() {
		submission.setCreatedAt(VALID_DATE);
		assertThat(submission.getCreatedAt(), is(VALID_DATE));
	}

	@Test
	public void submissionSetUpdatedAt_appropriatelySetsUpdatedAt() {
		submission.setUpdatedAt(VALID_DATE);
		assertThat(submission.getUpdatedAt(), is(VALID_DATE));
	}

}
