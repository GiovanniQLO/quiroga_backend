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
                "Javier",
                "Immigration Attorney",
                "10 years of experience in immigration law with expertise in asylum and refugee cases",
                "./assets/lawyer-m.svg"));

        teamMembers.put(id2, new TeamMember(
                id2,
                "Jenny",
                "Immigration Attorney",
                "8 years of experience helping families navigate the immigration process and reunite safely",
                "./assets/lawyer-f.svg"));

        teamMembers.put(id3, new TeamMember(
                id3,
                "Daniel",
                "Immigration Attorney",
                "12 years of experience in deportation defense and removal proceedings",
                "./assets/lawyer-m.svg"));

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
