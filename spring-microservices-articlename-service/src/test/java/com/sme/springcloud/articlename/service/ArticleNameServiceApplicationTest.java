package com.sme.springcloud.articlename.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sme.springcloud.articlename.service.config.ArticleNameConfig;
import com.sme.springcloud.articlename.service.controller.ArticleNameController;

/**
 * Unit tests of {@link ArticleNameServiceApplication}.
 */
@SpringBootTest(classes = ArticleNameServiceApplication.class)
public class ArticleNameServiceApplicationTest
{
    @Autowired
    private ArticleNameController articleNameController;

    @Autowired
    private ArticleNameConfig articleNameConfig;

    @Test
    void testContext() throws Exception
    {
        assertNotNull(articleNameController, "Expects started context");
        assertEquals("", articleNameConfig.getUniqueApplicationProperty());
    }
}
