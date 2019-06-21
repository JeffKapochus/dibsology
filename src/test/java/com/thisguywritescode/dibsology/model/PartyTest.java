package com.thisguywritescode.dibsology.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class PartyTest {

    private Party party;
	private final String VALID_STRING = "test string";
	private final Date VALID_DATE = new Date();
	private final Submission VALID_SUBMISSION = new Submission();

	@Before
	public void SetUp() {
		party = new Party();
	}

	@Test
	public void userGetId_returnsZeroForNewObject() {
		assertThat(party.getId(), is(0));
	}

	@Test
	public void userSetName_appropriatelySetsName() {
		party.setName(VALID_STRING);
		assertThat(party.getName(), is(VALID_STRING));
	}
	
	@Test
	public void userSetSubmissions_appropriatelySetsSubmissions() {
	    party.setSubmission(VALID_SUBMISSION);
	    assertThat(party.getSubmission(), is(VALID_SUBMISSION));
	}

	@Test
	public void userSetCreatedAt_appropriatelySetsCreatedAt() {
		party.setCreatedAt(VALID_DATE);
		assertThat(party.getCreatedAt(), is(VALID_DATE));
	}

	@Test
	public void userSetUpdatedAt_appropriatelySetsUpdatedAt() {
		party.setUpdatedAt(VALID_DATE);
		assertThat(party.getUpdatedAt(), is(VALID_DATE));
	}

}
