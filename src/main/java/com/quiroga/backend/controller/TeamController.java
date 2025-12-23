package com.quiroga.backend.controller;

import com.quiroga.backend.model.dto.TeamMemberDTO;
import com.quiroga.backend.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "*")
public class TeamController {
    
    private final TeamService teamService;
    
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    
    @GetMapping
    public ResponseEntity<List<TeamMemberDTO>> getAllTeamMembers() {
        List<TeamMemberDTO> teamMembers = teamService.getAllTeamMembers();
        return ResponseEntity.ok(teamMembers);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberDTO> getTeamMemberById(@PathVariable UUID id) {
        return teamService.getTeamMemberById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}