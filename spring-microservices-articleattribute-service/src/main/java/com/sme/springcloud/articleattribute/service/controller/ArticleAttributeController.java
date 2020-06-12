package com.sme.springcloud.articleattribute.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.model.ArticleAttributeWrapper;
import com.sme.springcloud.articleattribute.service.model.ArticlePrice;
import com.sme.springcloud.articleattribute.service.service.IArticleAttributeService;

/**
 * Article attribute controller.
 */
@RestController
@RequestMapping(value = "v1/articleattributes")
public class ArticleAttributeController
{
    private static final String ARTICLE_PRICE_HOST = "http://articlepriceservice";

    private final IArticleAttributeService articleAttributeService;
    //private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    private String articlePriceHost = ARTICLE_PRICE_HOST;

    public ArticleAttributeController(IArticleAttributeService articleAttributeService, RestTemplate restTemplate/*, WebClient.Builder webClientBuilder*/)
    {
        this.articleAttributeService = articleAttributeService;
        //this.webClientBuilder = webClientBuilder;
        this.restTemplate = restTemplate;
    }

    /**
     * Update article price host for test purpose.
     * 
     * @param articlePriceHost The article price host.
     */
    //@VisibleForTest
    void setArticlePriceHost(String articlePriceHost)
    {
        this.articlePriceHost = articlePriceHost;
    }

    /**
     * Fetch article attributes by article ID.
     * 
     * @param artId The article id;
     * @return Returns a wrapper with list of article attributes.
     */
    @RequestMapping(value = "/{artId}", method = RequestMethod.GET)
    public ResponseEntity<ArticleAttributeWrapper> getArticleAttributes(@PathVariable("artId") Integer artId)
    {
        List<ArticleAttribute> articleAttributes = articleAttributeService.findByArtId(artId)
                .stream()
                .map(aa ->
                {
                    String url = String.format(articlePriceHost + "/v1/articleprices/%d/%d/%d/%d", artId, aa.getAttr1Id(), aa.getAttr2Id(), aa.getAttr3Id());
                    ArticlePrice articlePrice = restTemplate.getForEntity(url, ArticlePrice.class).getBody();
                    aa.setArticlePrice(articlePrice);
                    return aa;
                })
                .collect(Collectors.toList());

        //CSOFF
        /*
        Mono<ArticlePrice> monoArticlePrice = webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .host(articlePriceHost)
                        .path("/v1/articleprices/1/1/0/0")
                        .build())
                .retrieve()
                .bodyToMono(ArticlePrice.class);
        ArticlePrice articlePrice = monoArticlePrice.block();
        */
        //CSON

        ArticleAttributeWrapper articleAttributeWrapper = new ArticleAttributeWrapper();
        articleAttributeWrapper.setArticleAttributes(articleAttributes);

        return ResponseEntity.ok(articleAttributeWrapper);
    }
}
