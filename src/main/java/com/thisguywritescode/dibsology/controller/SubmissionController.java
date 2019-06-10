package com.thisguywritescode.dibsology.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.service.SubmissionService;

@Component
@Controller("submissionController")
public class SubmissionController {

	@Autowired
	SubmissionService submissionService;
	
	@GetMapping(value = "/submission")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Submission>> getSubmissions() {
        List<Submission> subList = null;
        HttpStatus status = HttpStatus.OK;
        try {
            subList = submissionService.getAllSubmissions();
        } catch (final Exception e) {
            System.out.println(e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<List<Submission>>(subList, status);
    }

	@GetMapping(value = "/submission/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Submission> getSubmissionById(@PathVariable("id") final int id) {
		Submission sub = null;
		HttpStatus status = HttpStatus.OK;
		try {
			sub = submissionService.getSubmissionById(id);
		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Submission>(sub, status);
	}
}
