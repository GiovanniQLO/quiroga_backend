package com.quiroga.backend.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.quiroga.backend.model.entity.TeamMember;

import java.util.*;

@Repository
public class TeamRepository {

    private final Map<UUID, TeamMember> teamMembers = new HashMap<>();

    @PostConstruct
    public void init() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();

        teamMembers.put(id1, new TeamMember(
                id1,
                "Javier Gallego",
                "Talent Trainer",
                "8 años de experiencia en el campo de recursos humanos",
                "http://photo.com"));

        teamMembers.put(id2, new TeamMember(
                id1,
                "Jenny",
                "Talent Trainer",
                "8 años de experiencia en el campo de recursos humanos",
                "http://photo.com"));

        teamMembers.put(id3, new TeamMember(
                id1,
                "Daniel",
                "Talent Trainer",
                "8 años de experiencia en el campo de recursos humanos",
                "http://photo.com"));

    }

    public List<TeamMember> findAll(){
        return new ArrayList<>(teamMembers.values());
    }

    public Optional<TeamMember> findById (UUID id){
        return Optional.ofNullable(teamMembers.get(id));
    }

    public TeamMember save(TeamMember teamMember){
        if(teamMember.getId()==null){
            teamMember.setId(UUID.randomUUID());
        }
        teamMembers.put(teamMember.getId(),teamMember);
        return teamMember;
    }
}
