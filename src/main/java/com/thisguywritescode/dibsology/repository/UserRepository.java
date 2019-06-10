package com.thisguywritescode.dibsology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thisguywritescode.dibsology.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
