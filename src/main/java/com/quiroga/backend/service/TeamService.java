package com.quiroga.backend.service;

import com.quiroga.backend.model.dto.TeamMemberDTO;
import com.quiroga.backend.model.entity.TeamMember;
import com.quiroga.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {
    
    private final TeamRepository teamRepository;
    
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    
    public List<TeamMemberDTO> getAllTeamMembers() {
        return teamRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public Optional<TeamMemberDTO> getTeamMemberById(UUID id) {
        return teamRepository.findById(id)
            .map(this::convertToDTO);
    }
    
    private TeamMemberDTO convertToDTO(TeamMember teamMember) {
        return new TeamMemberDTO(
            teamMember.getId(),
            teamMember.getName(),
            teamMember.getRole(),
            teamMember.getBio(),
            teamMember.getPhotoUrl()
        );
    }
}