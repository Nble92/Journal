package com.example.Noble.Journal.Journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
//this annotation tells spring that this class is the service layer
public class JournalEntryService {
    private final JournalRepo journalRepo;

    public JournalEntryService(JournalRepo journalRepo) {
        this.journalRepo = journalRepo;
    }


    @Autowired
    public List<JournalEntry> getJournalEntries() {
//This little bastard does a select* without any damn SQL!!
        return journalRepo.findAll();

    }

    public void addNewEntry(JournalEntry entry) {
        journalRepo.save(entry);
        System.out.println(entry);
    }

    public void deleteEntry(Long id) {
        boolean exists = journalRepo.existsById(id);
        if (!exists) {

            throw new IllegalStateException("entry doesn't exist");
        } else {
            journalRepo.deleteById(id);
        }
    }


    @Transactional
    public void updateEntry(Long id,
                            String entry,
                            Long mood,
                            String meds) {
        JournalEntry journalEntry = journalRepo.findById(id).orElseThrow(() -> new IllegalStateException(
                "entry with id " + id + " doesn't exist"
        ));

        if (entry != null && entry.length() > 0 && !Objects.equals(journalEntry.getEntry(), entry)) {

            journalEntry.setEntry(entry);
        }
        if (meds != null && meds.length() > 0 && !Objects.equals(journalEntry.getMeds(), meds)) {

            journalEntry.setMeds(meds);
        }

        if (mood >= 0 && !Objects.equals(journalEntry.getMood(), mood)) {

            journalEntry.setMood(mood);
        }
        System.out.println(mood + meds + entry);
    }

}

