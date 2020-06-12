package com.sme.springcloud.articleprice.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sme.springcloud.articleprice.service.exception.ResourceNotFoundException;
import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.articleprice.service.service.IArticlePriceService;

/**
 * Article price controller.
 */
@RestController
@RequestMapping(value = "v1/articleprices")
public class ArticlePriceController
{
    private final IArticlePriceService articlePriceService;

    public ArticlePriceController(IArticlePriceService articlePriceService)
    {
        this.articlePriceService = articlePriceService;
    }

    /**
     * Fetch article prices for the given article and article attributes.
     * 
     * @param artId The article id;
     * @return Returns a list of article prices.
     */
    @RequestMapping(value = "/{artId}/{attr1Id}/{attr2Id}/{attr3Id}", method = RequestMethod.GET)
    public ResponseEntity<ArticlePrice> getArticlePrice(@PathVariable("artId") Integer artId,
            @PathVariable("attr1Id") Integer attr1Id,
            @PathVariable("attr2Id") Integer attr2Id,
            @PathVariable("attr3Id") Integer attr3Id)
    {
        return ResponseEntity.ok(articlePriceService.findBy(artId, attr1Id, attr2Id, attr3Id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Article Price not found with attr1Id = %d, attr2Id = %d, attr3Id = %d", attr1Id, attr2Id, attr3Id))));
    }
}
