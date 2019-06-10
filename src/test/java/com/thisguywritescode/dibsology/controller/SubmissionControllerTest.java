package com.thisguywritescode.dibsology.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.service.SubmissionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SubmissionControllerTest {

	@InjectMocks
	SubmissionController submissionController;

	@Mock
	SubmissionServiceImpl submissionService;

	@Mock
	Submission mockSubmission;

	private int VALID_SUBMISSION_ID = 1;

	@Before
	public void setUp() {
		doReturn(mockSubmission).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);
	}

	@Test
	public void getSubmissionById_returnsSubmissionAndOK_whenGivenValidId() {
		ResponseEntity<Submission> expected = new ResponseEntity<Submission>(mockSubmission, HttpStatus.OK);
		ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getSubmissionById_returnsNullAndOK_whenGivenInvalidId() {
		doReturn(null).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);

		ResponseEntity<Submission> expected = new ResponseEntity<Submission>((Submission) null, HttpStatus.OK);
		ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getSubmissionById_returnsInternalServerError_whenAServiceErrorOccurs() {
		doThrow(new NullPointerException()).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);

		ResponseEntity<Submission> expected = new ResponseEntity<Submission>((Submission) null,
				HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}

}
