package com.example.Noble.Journal.Journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JournalRepo extends JpaRepository<JournalEntry, Long> {


}
