package com.thisguywritescode.dibsology.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;

@Component
@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    
    //List<Submission> findByUser(User user) throws DataAccessException;
}
