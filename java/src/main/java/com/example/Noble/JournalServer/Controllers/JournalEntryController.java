package com.example.Noble.JournalServer.Controllers;

import com.example.Noble.JournalServer.Entries.JournalEntry;
import com.example.Noble.JournalServer.Entries.JournalEntryService;
import com.example.Noble.JournalServer.User.User;
import com.example.Noble.JournalServer.User.UserRepo;
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
    private UserRepo userRepo;

    //Dependency injection. This instantiates the journalEntry service inside the controller's constructor without doing all the  new shit
    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService, UserRepo userRepo) {
        this.journalEntryService = journalEntryService;
        this.userRepo = userRepo;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<JournalEntry> getJournalEntries(Principal principal) {

        return journalEntryService.getJournalEntries(principal.getName());

    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public void newEntry(@RequestBody JournalEntry entry,Principal principal) {
        entry.setUser(userRepo.getUserByUsername(principal.getName()));
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

