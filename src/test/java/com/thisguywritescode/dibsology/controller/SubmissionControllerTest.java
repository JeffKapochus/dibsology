package com.thisguywritescode.dibsology.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import java.util.ArrayList;
import java.util.List;
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

	private final int VALID_SUBMISSION_ID = 1;
	private List<Submission> VALID_SUBMISSION_LIST;

	@Before
	public void setUp() {
		VALID_SUBMISSION_LIST = new ArrayList<Submission>();
		VALID_SUBMISSION_LIST.add(mockSubmission);
		VALID_SUBMISSION_LIST.add(mockSubmission);
		
		doReturn(mockSubmission).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);
		doReturn(VALID_SUBMISSION_LIST).when(submissionService).getAllSubmissions();
	}

	@Test
	public void getSubmissionById_returnsSubmissionAndOK_whenGivenValidId() {
		final ResponseEntity<Submission> expected = new ResponseEntity<Submission>(mockSubmission, HttpStatus.OK);
		final ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getSubmissionById_returnsNullAndOK_whenGivenInvalidId() {
		doReturn(null).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);

		final ResponseEntity<Submission> expected = new ResponseEntity<Submission>((Submission) null, HttpStatus.OK);
		final ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getSubmissionById_returnsInternalServerError_whenAServiceErrorOccurs() {
		doThrow(new NullPointerException()).when(submissionService).getSubmissionById(VALID_SUBMISSION_ID);

		final ResponseEntity<Submission> expected = new ResponseEntity<Submission>((Submission) null,
				HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<Submission> result = submissionController.getSubmissionById(VALID_SUBMISSION_ID);

		assertThat(result, is(expected));
	}
	
	@Test
    public void getAllSubmissions_returnsValidList_byDefault() {
	    final ResponseEntity<List<Submission>> expected = new ResponseEntity<List<Submission>>(VALID_SUBMISSION_LIST, HttpStatus.OK);
        final ResponseEntity<List<Submission>> result = submissionController.getSubmissions();

        assertThat(result, is(expected));
    }
	
	@Test
    public void getAllSubmissions_returnsEmptyList_whenNoSubmissionsMatch() {
	    final List<Submission> emptyList = new ArrayList<Submission>();
	    doReturn(emptyList).when(submissionService).getAllSubmissions();
	    
        final ResponseEntity<List<Submission>> expected = new ResponseEntity<List<Submission>>(emptyList, HttpStatus.OK);
        final ResponseEntity<List<Submission>> result = submissionController.getSubmissions();

        assertThat(result, is(expected));
    }
	
	@Test
    public void getAllSubmissions_returnsInternalServerError_whenAServiceErrorOccurs() {
        doThrow(new NullPointerException()).when(submissionService).getAllSubmissions();

        final ResponseEntity<List<Submission>> expected = new ResponseEntity<List<Submission>>((List<Submission>)null,
                HttpStatus.INTERNAL_SERVER_ERROR);
        final ResponseEntity<List<Submission>> result = submissionController.getSubmissions();

        assertThat(result, is(expected));
    }

}
