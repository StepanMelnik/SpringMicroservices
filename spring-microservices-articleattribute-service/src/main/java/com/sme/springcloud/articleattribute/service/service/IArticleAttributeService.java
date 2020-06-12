package com.sme.springcloud.articleattribute.service.service;

import java.util.List;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;

/**
 * Article attribute service.
 */
public interface IArticleAttributeService
{
    /**
     * Find article attributes.
     * 
     * @param artId The id of article;
     * @return Returns a list of {@link ArticleAttribute}.
     */
    List<ArticleAttribute> findByArtId(int artId);
}
