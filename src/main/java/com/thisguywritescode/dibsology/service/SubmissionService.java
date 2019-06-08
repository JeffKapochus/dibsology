package com.thisguywritescode.dibsology.service;

import java.util.List;
import java.util.Optional;

import com.thisguywritescode.dibsology.model.Submission;

public interface SubmissionService {
	
	public Optional<Submission> getSubmissionById(int id);
	
	public List<Submission> getAllSubmissions();
	
	public List<Submission> getSubmissionsByUserId(int user_id);

}
