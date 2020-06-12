package com.sme.springcloud.articleprice.service.repository;

import java.util.List;
import java.util.Optional;

import com.sme.springcloud.articleprice.service.model.ArticlePrice;

/**
 * Article price repository.
 */
public interface IArticlePriceRepository
{
    /**
     * Find a list or article prices for article.
     * 
     * @param artId The id of article;
     * @return Returns a list or article prices for article.
     */
    List<ArticlePrice> findByArtId(int artId);

    /**
     * Fetch article price by the given article and article attributes.
     * 
     * @param artId The article id;
     * @param attr1Id The article attribute1 id;
     * @param attr2Id The article attribute2 id;
     * @param attr3Id The article attribute3 id;
     * @return Returns the fetched article.
     */
    Optional<ArticlePrice> findBy(Integer artId, Integer attr1Id, Integer attr2Id, Integer attr3Id);
}
