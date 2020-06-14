package com.sme.springcloud.article.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sme.springcloud.article.service.service.ArticleDiscoveryService;

/**
 * Article discovery controller.
 */
@RestController
@RequestMapping(value = "v1/tools")
public class ArticleDiscoveryController
{
    private final ArticleDiscoveryService articleDiscoveryService;

    public ArticleDiscoveryController(ArticleDiscoveryService articleDiscoveryService)
    {
        this.articleDiscoveryService = articleDiscoveryService;
    }

    @RequestMapping(value = "/eureka/services", method = RequestMethod.GET)
    public List<String> getEurekaServices()
    {
        return articleDiscoveryService.getEurekaServices();
    }
}
