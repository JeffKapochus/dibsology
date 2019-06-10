package com.thisguywritescode.dibsology.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.repository.SubmissionRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubmissionServiceImplTest {

	@InjectMocks
	SubmissionService submissionService = new SubmissionServiceImpl();

	@Mock
	SubmissionRepository mockSubmissionRepository;

	@Mock
	Submission mockSubmission;

	private int VALID_SUBMISSION_ID = 1;
	private int VALID_USER_ID = 1;
	private List<Submission> VALID_SUBMISSION_LIST;
	private List<Submission> EMPTY_SUBMISSION_LIST;

	@Before
	public void setUp() {
		EMPTY_SUBMISSION_LIST = new ArrayList<Submission>();

		VALID_SUBMISSION_LIST = new ArrayList<Submission>();
		VALID_SUBMISSION_LIST.add(mockSubmission);
		VALID_SUBMISSION_LIST.add(mockSubmission);
		VALID_SUBMISSION_LIST.add(mockSubmission);

		doReturn(Optional.of(mockSubmission)).when(mockSubmissionRepository).findById(VALID_SUBMISSION_ID);
		doReturn(VALID_SUBMISSION_LIST).when(mockSubmissionRepository).findAll();
		doReturn(VALID_SUBMISSION_LIST).when(mockSubmissionRepository).findByUserId(VALID_USER_ID);
	}

	@Test
	public void getSubmissionById_returnsValidSubmission_whenGivenValidId() {
		assertThat(submissionService.getSubmissionById(VALID_SUBMISSION_ID), is(mockSubmission));
	}

	@Test
	public void getSubmissionById_returnsEmpty_whenGivenInvalidId() {
		assertThat(submissionService.getSubmissionById(0), is(nullValue()));
	}

	@Test
	public void getAllSubmissions_returnsValidSubmissionList_byDefault() {
		assertThat(submissionService.getAllSubmissions(), is(VALID_SUBMISSION_LIST));
	}

	@Test
	public void getSubmissionsByUserId_returnsValidSubmissionList_whenGivenValidUserId() {
		assertThat(submissionService.getSubmissionsByUserId(VALID_USER_ID), is(VALID_SUBMISSION_LIST));
	}

	@Test
	public void getSubmissionsByUserId_returnsEmptySubmissionList_whenGivenInvalidUserId() {
		assertThat(submissionService.getSubmissionsByUserId(0), is(EMPTY_SUBMISSION_LIST));
	}

}
