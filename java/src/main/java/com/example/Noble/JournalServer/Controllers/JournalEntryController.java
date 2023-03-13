package com.example.Noble.JournalServer.Controllers;

import com.example.Noble.JournalServer.Entries.JournalEntry;
import com.example.Noble.JournalServer.Entries.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/journal")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;
    private Principal principal;

    //Dependency injection. This instantiates the journalEntry service inside the controller's constructor without doing all the  new shit
    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<JournalEntry> getJournalEntries(@RequestParam String username) {

        return journalEntryService.getJournalEntries(principal.getName());

    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
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

