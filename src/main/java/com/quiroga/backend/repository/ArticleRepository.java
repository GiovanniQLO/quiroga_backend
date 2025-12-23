package com.quiroga.backend.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.quiroga.backend.model.entity.Article;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ArticleRepository {

    private final Map<UUID, Article> articles = new HashMap<>();

    @PostConstruct
    public void init() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        articles.put(id1, new Article(
                id1,
                "The injustice of waiting",
                "injustice-waiting",
                "A father of a family who has been waiting for almost 5 years to obtain his residence is just one of the cases that had to be sued in the Court, so that the Citizenship and Immigration Service (USCIS) deliver a response to cases where a pardon is required to acquire a residence",
                "A father of a family who has been waiting for almost 5 years to \r\n" + //
                        "obtain his residence is just one of the cases that had to be sued in the Court, so that the \r\n"
                        + //
                        "Citizenship and Immigration Service (USCIS) deliver a response to cases where a pardon is \r\n"
                        + //
                        "required to acquire a residence. \r\n" + //
                        "The pain, despair and anxiety of this father is not only related with the restriction to work legally \r\n"
                        + //
                        "in the country, but also in the impossibility of carrying an identification, helping financially his family \r\n"
                        + //
                        "and even the limitation of mobility by not being able to travel, which constitutes a deprivation of \r\n"
                        + //
                        "their liberties that, in the end, affects their family.",
                LocalDateTime.now().minusHours(5)));

        articles.put(id2, new Article(
                id2,
                "The firm Quiroga Law Office opens new office in Wenatchee",
                "QLO-new-office-wenatchee",
                "A father of a family who has been waiting for almost 5 years to obtain his residence is just one of the cases that had to be sued in the Court, so that the Citizenship and Immigration Service (USCIS) deliver a response to cases where a pardon is required to acquire a residence",
                "A father of a family who has been waiting for almost 5 years to \r\n" + //
                        "obtain his residence is just one of the cases that had to be sued in the Court, so that the \r\n"
                        + //
                        "Citizenship and Immigration Service (USCIS) deliver a response to cases where a pardon is \r\n"
                        + //
                        "required to acquire a residence. \r\n" + //
                        "The pain, despair and anxiety of this father is not only related with the restriction to work legally \r\n"
                        + //
                        "in the country, but also in the impossibility of carrying an identification, helping financially his family \r\n"
                        + //
                        "and even the limitation of mobility by not being able to travel, which constitutes a deprivation of \r\n"
                        + //
                        "their liberties that, in the end, affects their family.",
                LocalDateTime.now().minusHours(5)

        ));

    }

    public List<Article> findAll() {
        return new ArrayList<>(articles.values());
    }

    public Optional<Article> findById(UUID id) {
        return Optional.ofNullable(articles.get(id));
    }

    public Optional<Article> findBySlug(String slug) {
        return articles.values().stream().filter(article -> article.getSlug().equals(slug)).findFirst();
    }

    public Article save (Article article){
        if(article.getId() == null){
            article.setId(UUID.randomUUID());
        }
        articles.put(article.getId(),article);
        return article;
    }
}
