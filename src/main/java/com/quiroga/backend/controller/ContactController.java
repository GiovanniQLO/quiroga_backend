package com.quiroga.backend.controller;

import com.quiroga.backend.model.dto.ContactRequest;
import com.quiroga.backend.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactRequest contactRequest) {
        boolean isValid = contactService.validateAndLogSubmission(contactRequest);
        
        if (isValid) {
            return ResponseEntity.ok("Contact form submitted successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or missing required fields");
        }
    }
}