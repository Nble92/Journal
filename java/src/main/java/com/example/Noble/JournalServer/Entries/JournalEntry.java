package com.example.Noble.JournalServer.Entries;

import com.example.Noble.JournalServer.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class JournalEntry {
    @Id
    @SequenceGenerator(
            name = "journal_sequence",
            sequenceName = "journal_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "journal_sequence"

    )
    private long id;
    private LocalDateTime date = LocalDateTime.now();
    @JsonProperty("entry")
    private String entry;
    @JsonProperty("mood")

    private Long mood;
    @JsonProperty("meds")
    private String meds;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public JournalEntry(long id, LocalDateTime date, String entry, Long mood, String meds) {
        this.id = id;
        this.date = date;
        this.entry = entry;
        this.mood = mood;
        this.meds = meds;
    }

    public JournalEntry(LocalDateTime date, String entry, Long mood, String meds) {
        this.date = date;
        this.entry = entry;
        this.mood = mood;
        this.meds = meds;
    }

    public JournalEntry(String entry, Long mood, String meds) {
        this.entry = entry;
        this.mood = mood;
        this.meds = meds;
    }

    public JournalEntry() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Long getMood() {
        return mood;
    }

    public void setMood(long mood) {
        this.mood = mood;
    }

    public String getMeds() {
        return meds;
    }

    public void setMeds(String meds) {
        this.meds = meds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "JournalEntry{" +
                "id=" + id +
                ", \n date=" + date +
                ", \n entry='" + entry + '\'' +
                ", \n mood=" + mood +
                ", \n meds='" + meds + '\'' +
                '}';
    }
}
