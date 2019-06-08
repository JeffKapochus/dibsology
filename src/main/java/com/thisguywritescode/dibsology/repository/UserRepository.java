package com.thisguywritescode.dibsology.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    //User findBySubmission(Submission submission) throws DataAccessException;
}
