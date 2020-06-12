package com.sme.springcloud.article.service.repository;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Article repository implementation in memory.
 */
@Repository
public class ArticleRepository implements IArticleRepository
{
    @Override
    public Optional<Article> findByArtId(int artId)
    {
        return ArticleTD.ARTICLES.stream().filter(an -> an.getArtId() == artId).findAny();
    }

    /**
     * Article Data in memory.
     */
    //CSOFF
    private static class ArticleTD
    {
        private static List<Article> ARTICLES = asList(
                new PojoGenericBuilder<>(Article::new)
                        .with(Article::setArtId, 1)
                        .build(),
                new PojoGenericBuilder<>(Article::new)
                        .with(Article::setArtId, 2)
                        .build());
    }
    //CSON
}
