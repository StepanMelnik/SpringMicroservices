package com.sme.springcloud.article.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sme.springcloud.article.service.config.ArticleConfig;
import com.sme.springcloud.article.service.controller.ArticleController;

/**
 * Unit tests of {@link ArticleServiceApplication}.
 */
@SpringBootTest(classes = ArticleServiceApplication.class)
public class ArticleServiceApplicationTest
{
    @Autowired
    private ArticleController articleController;

    @Autowired
    private ArticleConfig articleConfig;

    @Test
    public void testContext() throws Exception
    {
        assertNotNull(articleController, "Expects started context");
        assertEquals("", articleConfig.getUniqueApplicationProperty());
    }
}
