package com.thisguywritescode.dibsology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thisguywritescode.dibsology.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

}
