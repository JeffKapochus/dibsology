package com.thisguywritescode.dibsology.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class VoteTest {

    private Vote vote;
	private final String VALID_STRING = "test string";
	private final Date VALID_DATE = new Date();
	private final User VALID_USER = new User();
	private final Party VALID_PARTY = new Party();

	@Before
	public void SetUp() {
		vote = new Vote();
	}

	@Test
	public void partyrGetId_returnsZeroForNewObject() {
		assertThat(vote.getId(), is(0));
	}

	@Test
	public void partySetName_appropriatelySetsName() {
		vote.setName(VALID_STRING);
		assertThat(vote.getName(), is(VALID_STRING));
	}
	
	@Test
    public void partySetParty_appropriatelySetsParty() {
        vote.setParty(VALID_PARTY);
        assertThat(vote.getParty(), is(VALID_PARTY));
    }
	
	@Test
	public void partySetUser_appropriatelySetsUser() {
	    vote.setUser(VALID_USER);
	    assertThat(vote.getUser(), is(VALID_USER));
	}

	@Test
	public void partySetCreatedAt_appropriatelySetsCreatedAt() {
		vote.setCreatedAt(VALID_DATE);
		assertThat(vote.getCreatedAt(), is(VALID_DATE));
	}

	@Test
	public void partySetUpdatedAt_appropriatelySetsUpdatedAt() {
		vote.setUpdatedAt(VALID_DATE);
		assertThat(vote.getUpdatedAt(), is(VALID_DATE));
	}

}
