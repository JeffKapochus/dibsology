package com.thisguywritescode.dibsology.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.thisguywritescode.dibsology.model.Submission;

@Component
@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {

	@Query("SELECT s FROM Submission s WHERE user_id = ?1")
	List<Submission> findByUserId(int userId) throws DataAccessException;

}
