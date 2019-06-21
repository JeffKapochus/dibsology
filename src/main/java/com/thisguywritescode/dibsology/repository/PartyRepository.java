package com.thisguywritescode.dibsology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thisguywritescode.dibsology.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {

}
