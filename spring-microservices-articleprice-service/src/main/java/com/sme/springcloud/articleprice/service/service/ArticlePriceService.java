package com.sme.springcloud.articleprice.service.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sme.springcloud.articleprice.service.config.ArticlePriceConfig;
import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.articleprice.service.repository.IArticlePriceRepository;

/**
 * Article price service implementation.
 */
@Service
public class ArticlePriceService implements IArticlePriceService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticlePriceService.class);

    private final IArticlePriceRepository articlePriceRepository;
    private final ArticlePriceConfig articlePriceConfig;

    public ArticlePriceService(IArticlePriceRepository articlePriceRepository, ArticlePriceConfig articlePriceConfig)
    {
        this.articlePriceRepository = articlePriceRepository;
        this.articlePriceConfig = articlePriceConfig;
    }

    @Override
    public List<ArticlePrice> findByArtId(int artId)
    {
        LOGGER.debug("Look for article names by {} artId with {} unique property", artId, articlePriceConfig.getUniqueApplicationProperty());

        return articlePriceRepository.findByArtId(artId);
    }

    @Override
    public Optional<ArticlePrice> findBy(Integer artId, Integer attr1Id, Integer attr2Id, Integer attr3Id)
    {
        LOGGER.debug("Look for article names by {} artId, {} attr1Id, {} attr2Id, {} attr3Id with {} unique property", artId, attr1Id, attr2Id, attr3Id,
                articlePriceConfig.getUniqueApplicationProperty());

        return articlePriceRepository.findBy(artId, attr1Id, attr2Id, attr3Id);
    }
}
