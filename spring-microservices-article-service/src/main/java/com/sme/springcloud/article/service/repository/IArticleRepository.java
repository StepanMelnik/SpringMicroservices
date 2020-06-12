package com.sme.springcloud.article.service.repository;

import java.util.Optional;

import com.sme.springcloud.article.service.model.Article;

/**
 * Article repository.
 */
public interface IArticleRepository
{
    /**
     * Find {@link Article} by ID.
     * 
     * @param artId The id of article;
     * @return Returns {@link Article}.
     */
    Optional<Article> findByArtId(int artId);
}
