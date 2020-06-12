package com.sme.springcloud.articlename.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sme.springcloud.articlename.service.config.ArticleNameConfig;
import com.sme.springcloud.articlename.service.model.ArticleName;
import com.sme.springcloud.articlename.service.repository.IArticleNameRepository;

/**
 * Article name service implementation.
 */
@Service
public class ArticleNameService implements IArticleNameService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleNameService.class);

    private final IArticleNameRepository articleNameRepository;
    private final ArticleNameConfig articleNameConfig;

    public ArticleNameService(IArticleNameRepository articleNameRepository, ArticleNameConfig articleNameConfig)
    {
        this.articleNameRepository = articleNameRepository;
        this.articleNameConfig = articleNameConfig;
    }

    @Override
    public List<ArticleName> findByArtId(int artId)
    {
        LOGGER.debug("Look for article names by {} artId with {} unique property", artId, articleNameConfig.getUniqueApplicationProperty());

        return articleNameRepository.findByArtId(artId);
    }
}
