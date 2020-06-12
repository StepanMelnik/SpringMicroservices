package com.sme.springcloud.articleattribute.service.repository;

import java.util.List;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;

/**
 * Article attribute repository.
 */
public interface IArticleAttributeRepository
{
    /**
     * Find a list of {@link ArticleAttribute} for article.
     * 
     * @param artId The id of article;
     * @return Returns a list of {@link ArticleAttribute}.
     */
    List<ArticleAttribute> findByArtId(int artId);
}
