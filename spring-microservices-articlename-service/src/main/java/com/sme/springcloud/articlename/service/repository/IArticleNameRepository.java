package com.sme.springcloud.articlename.service.repository;

import java.util.List;

import com.sme.springcloud.articlename.service.model.ArticleName;

/**
 * Article name repository.
 */
public interface IArticleNameRepository
{
    /**
     * Find a list of {@link ArticleName} for article.
     * 
     * @param artId The id of article;
     * @return Returns a list of {@link ArticleName}.
     */
    List<ArticleName> findByArtId(int artId);
}
