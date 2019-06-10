package com.thisguywritescode.dibsology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.thisguywritescode.dibsology.model.User;
import com.thisguywritescode.dibsology.service.UserService;

@Component
@Controller("userController")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<User> getUserById(@PathVariable("id") final int id) {
		User user = null;
		HttpStatus status = HttpStatus.OK;
		try {
		    user = userService.getUserById(id);
		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<User>(user, status);
	}
}
