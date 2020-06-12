package com.sme.springcloud.articlename.service.service;

import java.util.List;

import com.sme.springcloud.articlename.service.model.ArticleName;

/**
 * Article name service.
 */
public interface IArticleNameService
{
    /**
     * Find article names.
     * 
     * @param artId The id of article;
     * @return Returns a list of {@link ArticleName}.
     */
    List<ArticleName> findByArtId(int artId);
}
