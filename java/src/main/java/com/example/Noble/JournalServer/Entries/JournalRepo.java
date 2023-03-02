package com.example.Noble.JournalServer.Entries;

import com.example.Noble.JournalServer.Entries.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepo extends JpaRepository<JournalEntry, Long> {


}
