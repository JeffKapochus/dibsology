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
import com.thisguywritescode.dibsology.model.User;
import com.thisguywritescode.dibsology.repository.SubmissionRepository;

@Component
@Controller("testController")
public class TestController {
	
	@Autowired
	SubmissionRepository submissionRepository;
    
    @GetMapping(value = "/")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("You did it, buddy", HttpStatus.OK);
    }
    
    //@GetMapping(value = "/all")
    //@CrossOrigin(origins = "http://localhost:3000")
    //public ResponseEntity<Submission> test2() {
        //return new ResponseEntity<Submission>(new Submission("test title", "test text", new User("Jeff","jeff.kapochus@gmail.com")), HttpStatus.OK);
    //}
    
    @GetMapping(value = "/thisistheREALtest/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Submission> test3(@PathVariable("id") int id){
    	Submission sub = null;
    	HttpStatus status = HttpStatus.OK;
    	try {
    		sub = submissionRepository.getOne(id);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    		status = HttpStatus.INTERNAL_SERVER_ERROR;
    	}
    	return new ResponseEntity<Submission>(sub, status);
    }
}
