package com.example.Noble.JournalServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/journal")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    //Dependency injection. This instantiates the journalEntry service inside the controller's constructor without doing all the  new shit
    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    public List<JournalEntry> getJournalEntries() {

        return journalEntryService.getJournalEntries();

    }

    @PostMapping
    public void newEntry(@RequestBody JournalEntry entry) {
        journalEntryService.addNewEntry(entry);

    }

    @DeleteMapping(path = "{id}")
    public void deleteEntry(@PathVariable("id") Long id) {
        journalEntryService.deleteEntry(id);
    }

    @PutMapping(path = "{id}")
    public void updateEntry(@PathVariable("id") Long id,
                            @RequestParam(required = false) String entry,
                            @RequestParam(required = false) Long mood,
                            @RequestParam(required = false) String meds) {
        journalEntryService.updateEntry(id, entry, mood, meds);
    }

}

