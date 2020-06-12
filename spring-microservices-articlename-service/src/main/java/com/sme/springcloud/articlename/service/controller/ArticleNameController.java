package com.sme.springcloud.articlename.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sme.springcloud.articlename.service.model.ArticleNameWrapper;
import com.sme.springcloud.articlename.service.service.IArticleNameService;

/**
 * Article name controller.
 */
@RestController
@RequestMapping(value = "v1/articlenames")
public class ArticleNameController
{
    private final IArticleNameService articleNameService;

    public ArticleNameController(IArticleNameService articleNameService)
    {
        this.articleNameService = articleNameService;
    }

    /**
     * Fetch article names by article ID.
     * 
     * @param artId The article id;
     * @return Returns a wrapper with list of article names.
     */
    @RequestMapping(value = "/{artId}", method = RequestMethod.GET)
    public ResponseEntity<ArticleNameWrapper> getArticleNames(@PathVariable("artId") Integer artId)
    {
        ArticleNameWrapper articleNameWrapper = new ArticleNameWrapper();
        articleNameWrapper.setArticleNames(articleNameService.findByArtId(artId));

        return ResponseEntity.ok(articleNameWrapper);
    }
}
