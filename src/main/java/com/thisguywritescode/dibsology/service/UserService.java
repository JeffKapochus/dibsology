package com.thisguywritescode.dibsology.service;

import java.util.List;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

public interface UserService {

	public User getUserById(int id);

	public List<User> getAllUsers();

	public User getUserBySubmission(Submission submission);

}
