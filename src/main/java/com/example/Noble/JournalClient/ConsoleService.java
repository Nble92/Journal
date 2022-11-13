package com.example.Noble.JournalClient;

import com.example.Noble.JournalServer.JournalEntry;
import org.jboss.logging.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class ConsoleService {
    public ConsoleService() {
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/v1/";
    private final RestTemplate restTemplate = new RestTemplate();

    public JournalEntry addJe(JournalEntry newJE) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JournalEntry> entity = new HttpEntity<>(newJE, headers);

        JournalEntry returnedReservation = null;
        try {
            returnedReservation  = restTemplate.postForObject(API_BASE_URL + "journal", entity, JournalEntry.class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
        return returnedReservation;
    }

    }

