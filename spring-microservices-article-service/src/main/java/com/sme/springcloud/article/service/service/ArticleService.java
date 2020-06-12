package com.sme.springcloud.article.service.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sme.springcloud.article.service.config.ArticleConfig;
import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.article.service.repository.IArticleRepository;

/**
 * Article service implementation.
 */
@Service
public class ArticleService implements IArticleService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

    private final IArticleRepository articleRepository;
    private final ArticleConfig articleConfig;

    public ArticleService(IArticleRepository articleRepository, ArticleConfig articleConfig)
    {
        this.articleRepository = articleRepository;
        this.articleConfig = articleConfig;
    }

    @Override
    public Optional<Article> findByArtId(int artId)
    {
        LOGGER.debug("Look for article by {} artId with {} unique property", artId, articleConfig.getUniqueApplicationProperty());

        return articleRepository.findByArtId(artId);
    }
}
