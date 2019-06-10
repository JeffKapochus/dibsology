package com.thisguywritescode.dibsology.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;
import com.thisguywritescode.dibsology.repository.UserRepository;

@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SubmissionServiceImpl submissionService;

    @Override
    public User getUserById(final int id) {
        User user = null;
        final Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserBySubmission(final Submission submission) {
        if(submission !=  null) {
            return getUserById(submission.getUser().getId());
        }
        return null;
    }

}
