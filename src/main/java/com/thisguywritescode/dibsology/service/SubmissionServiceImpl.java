package com.thisguywritescode.dibsology.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.repository.SubmissionRepository;

@Component
@Service
public class SubmissionServiceImpl implements SubmissionService {

	@Autowired
	SubmissionRepository submissionRepository;

	@Override
	public Optional<Submission> getSubmissionById(int id) {
		return submissionRepository.findById(id);
	}

	@Override
	public List<Submission> getAllSubmissions() {
		return submissionRepository.findAll();
	}

	@Override
	public List<Submission> getSubmissionsByUserId(int user_id) {
		return submissionRepository.findByUserId(user_id);
	}

}
