package com.sme.springcloud.article.service.service;

import java.util.Optional;

import com.sme.springcloud.article.service.model.Article;

/**
 * Article service.
 */
public interface IArticleService
{
    /**
     * Find {@link Article} by ID.
     * 
     * @param artId The id of article;
     * @return Returns {@link Article}.
     */
    Optional<Article> findByArtId(int artId);
}
