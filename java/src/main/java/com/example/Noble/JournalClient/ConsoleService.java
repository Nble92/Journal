package com.example.Noble.JournalClient;

import com.example.Noble.JournalServer.Entries.JournalEntry;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class ConsoleService {

    //This identifies which port we use
    private static final String API_BASE_URL = "http://localhost:8080/api/v1/";

    //this is Java's restTemplate that allows us to make all the http requests we want. seems a bit verbose, but it gets the job done.
    private final RestTemplate restTemplate = new RestTemplate();

    public ConsoleService() {
    }

    public void addJe(JournalEntry newJE) {
// this automatically sets the headers based on the object you pass through
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JournalEntry> entity = new HttpEntity<>(newJE, headers);

        JournalEntry returnedReservation = null;
        try {
            returnedReservation = restTemplate.postForObject(API_BASE_URL + "journal", entity, JournalEntry.class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
    }

    public JournalEntry [] getJeList() {
// this automatically sets the headers based on the object you pass through
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JournalEntry [] entries = null;
        try {
            entries = restTemplate.getForObject(API_BASE_URL + "journal", JournalEntry[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
return entries;
    }
}

