package com.sme.springcloud.article.service.controller;

import static java.util.Optional.ofNullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sme.springcloud.article.service.exception.ResourceNotFoundException;
import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.article.service.model.ArticleAttributeWrapper;
import com.sme.springcloud.article.service.model.ArticleNameWrapper;
import com.sme.springcloud.article.service.service.ArticleService;
import com.sme.springcloud.article.service.service.IArticleService;

/**
 * Article controller.
 */
@RestController
@RequestMapping(value = "v1/articles")
public class ArticleController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
    private static final String ARTICLE_ATTRIBUTE_HOST = "http://articleattributeservice";
    private static final String ARTICLE_NAME_HOST = "http://articlenameservice";

    private final IArticleService articleService;
    private final RestTemplate restTemplate;

    private String articleAttributeHost = ARTICLE_ATTRIBUTE_HOST;
    private String articleNameHost = ARTICLE_NAME_HOST;

    public ArticleController(IArticleService articleService, RestTemplate restTemplate)
    {
        this.articleService = articleService;
        this.restTemplate = restTemplate;
    }

    /**
     * Update article attribute host for test purpose.
     * 
     * @param articleAttributeHost The article attribute host.
     */
    //@VisibleForTest
    void setArticleAttributeHost(String articleAttributeHost)
    {
        this.articleAttributeHost = articleAttributeHost;
    }

    /**
     * Update article name host for test purpose.
     * 
     * @param articleNameHost The article name host.
     */
    //@VisibleForTest
    void setArticleNameHost(String articleNameHost)
    {
        this.articleNameHost = articleNameHost;
    }

    /**
     * Fetch article by ID.
     * 
     * @param artId The article id;
     * @return Returns the {@link Article} instance.
     */
    @RequestMapping(value = "/{artId}", method = RequestMethod.GET)
    public ResponseEntity<Article> getArticle(@PathVariable("artId") Integer artId)
    {
        LOGGER.debug("Process GET v1/articles/{} request", artId);

        Article article = articleService.findByArtId(artId).orElseThrow(() -> new ResourceNotFoundException("Article not found"));

        String articleNameUrl = String.format(articleNameHost + "/v1/articlenames/%d", artId);
        LOGGER.debug("Process GET {} request", articleNameUrl);
        ArticleNameWrapper articleNameWrapper = restTemplate.getForEntity(articleNameUrl, ArticleNameWrapper.class).getBody();
        ofNullable(articleNameWrapper).ifPresent(w -> article.setArticleNames(w.getArticleNames()));

        String articleAttributeUrl = String.format(articleAttributeHost + "/v1/articleattributes/%d", artId);
        LOGGER.debug("Process GET {} request", articleAttributeUrl);
        ArticleAttributeWrapper articleAttributeWrapper = restTemplate.getForEntity(articleAttributeUrl, ArticleAttributeWrapper.class).getBody();
        ofNullable(articleAttributeWrapper).ifPresent(w -> article.setArticleAtributes(w.getArticleAttributes()));

        return ResponseEntity.ok(article);
    }
}
