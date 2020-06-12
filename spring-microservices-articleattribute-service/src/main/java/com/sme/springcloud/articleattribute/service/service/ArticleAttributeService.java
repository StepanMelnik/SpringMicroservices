package com.sme.springcloud.articleattribute.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sme.springcloud.articleattribute.service.config.ArticleAttributeConfig;
import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.repository.IArticleAttributeRepository;

/**
 * Implementation of article attribute service.
 */
@Service
public class ArticleAttributeService implements IArticleAttributeService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleAttributeService.class);

    private final IArticleAttributeRepository articleAttributeRepository;
    private final ArticleAttributeConfig articleAttributeConfig;

    public ArticleAttributeService(IArticleAttributeRepository articleAttributeRepository, ArticleAttributeConfig articleAttributeConfig)
    {
        this.articleAttributeRepository = articleAttributeRepository;
        this.articleAttributeConfig = articleAttributeConfig;
    }

    @Override
    public List<ArticleAttribute> findByArtId(int artId)
    {
        LOGGER.debug("Look for article attributes by {} artId with {} unique property", artId, articleAttributeConfig.getUniqueApplicationProperty());

        return articleAttributeRepository.findByArtId(artId);
    }
}
