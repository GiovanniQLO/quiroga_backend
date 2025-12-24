package com.quiroga.backend.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.quiroga.backend.model.entity.SuccessStory;

import java.time.LocalDate;
import java.util.*;

@Repository
public class SuccessRepository {

    private final Map<UUID, SuccessStory> successStories = new HashMap<>();

    @PostConstruct
    public void init() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();

        successStories.put(id1, new SuccessStory(
                id1,
                "Family Reunification and Permanent Residency for the Ramirez Family",
                "Maria and Carlos Ramirez",
                "Immigration Services",
                "We successfully guided Maria and Carlos Ramirez, who fled violence in their home country, through the complex asylum process. After years of uncertainty, they obtained permanent residency, allowing them to reunite with their two children and build a stable life in safety...",
                LocalDate.now().minusMonths(3)));

        successStories.put(id2, new SuccessStory(
                id2,
                "Work Visa and Career Launch for Tech Professional",
                "Alejandro Torres",
                "Immigration Services",
                "We assisted Alejandro Torres, a talented software engineer, in securing an H-1B work visa and later a green card. This enabled him to join a leading tech company, contribute his expertise to innovative projects, and support his family back home while establishing roots in his new country...",
                LocalDate.now().minusMonths(2)));

        successStories.put(id3, new SuccessStory(
                id3,
                "Complex Deportation Defense and Cancellation of Removal",
                "Roberto Santos",
                "Immigration Services",
                "We represented Roberto Santos in his deportation proceedings, where he faced removal based on a past criminal conviction. After demonstrating that he had been physically present in the U.S. for over 10 years, had good moral character, and that his removal would cause exceptional hardship to his U.S. citizen spouse and children, we successfully obtained cancellation of removal...",
                LocalDate.now().minusMonths(1)));
    }

    public List<SuccessStory> findAll() {
        return new ArrayList<>(successStories.values());
    }

    public Optional<SuccessStory> findById(UUID id) {
        return Optional.ofNullable(successStories.get(id));
    }

    public SuccessStory save(SuccessStory successStory) {
        if (successStory.getId() == null) {
            successStory.setId(UUID.randomUUID());
        }
        successStories.put(successStory.getId(), successStory);
        return successStory;
    }
}