package com.example.Noble.JournalServer.Entries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepo extends JpaRepository<JournalEntry, Long> {


    @Query("SELECT je FROM JournalEntry je WHERE username = :username")
    List<JournalEntry> findAllByUserName(String username);
}
