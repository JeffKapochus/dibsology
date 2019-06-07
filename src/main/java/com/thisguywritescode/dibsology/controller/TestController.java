package com.thisguywritescode.dibsology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

@Controller("testController")
public class TestController {
    
    @GetMapping(value = "/")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Submission> test() {
        return new ResponseEntity<Submission>(new Submission("test title", "test text", new User("Jeff","jeff.kapochus@gmail.com")), HttpStatus.OK);
    }
    
}
