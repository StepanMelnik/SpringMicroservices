package com.sme.springcloud.articleattribute.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sme.springcloud.articleattribute.service.config.ArticleAttributeConfig;
import com.sme.springcloud.articleattribute.service.controller.ArticleAttributeController;

/**
 * Unit tests of {@link ArticleAttributeServiceApplication}.
 */
@SpringBootTest(classes = ArticleAttributeServiceApplication.class)
public class ArticleAttributeServiceApplicationTest
{
    @Autowired
    private ArticleAttributeController articleAttributeController;

    @Autowired
    private ArticleAttributeConfig articleAttributeConfig;

    @Test
    public void testContext() throws Exception
    {
        assertNotNull(articleAttributeController, "Expects started context");
        assertEquals("", articleAttributeConfig.getUniqueApplicationProperty());
    }
}
