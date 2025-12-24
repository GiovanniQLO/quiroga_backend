package com.quiroga.backend.service;

import com.quiroga.backend.model.dto.ContactRequest;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ContactService {

    private static final String LOG_FILE = "contact.log";
    private static final String EMAIL_REGEX = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
    
    public boolean validateAndLogSubmission(ContactRequest contactRequest) {
        boolean isValid = true;
        
        if (contactRequest.getName() == null || contactRequest.getName().trim().isEmpty()) {
            logSubmissionFailure("missing name");
            isValid = false;
        }
        
        if (contactRequest.getEmail() == null || contactRequest.getEmail().trim().isEmpty()) {
            logSubmissionFailure("missing email");
            isValid = false;
        } else if (!isValidEmail(contactRequest.getEmail())) {
            logSubmissionFailure("invalid email: " + contactRequest.getEmail());
            isValid = false;
        }
        
        if (contactRequest.getMessage() == null || contactRequest.getMessage().trim().isEmpty()) {
            logSubmissionFailure("missing message");
            isValid = false;
        }
        
        if (isValid) {
            logSuccessfulSubmission(contactRequest);
        }
        
        return isValid;
    }
    
    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
    
    private void logSuccessfulSubmission(ContactRequest contactRequest) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            out.println("[" + timestamp + "] " + contactRequest.getName() + " (" +
                       contactRequest.getEmail() + "): \"" + contactRequest.getMessage() + "\"");
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }
    }
    
    private void logSubmissionFailure(String reason) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            out.println("[" + timestamp + "] Submission failed – " + reason);
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }
    }
}