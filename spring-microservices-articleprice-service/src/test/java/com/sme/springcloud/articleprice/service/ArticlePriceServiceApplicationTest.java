package com.sme.springcloud.articleprice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sme.springcloud.articleprice.service.config.ArticlePriceConfig;
import com.sme.springcloud.articleprice.service.controller.ArticlePriceController;

/**
 * Unit tests of {@link ArticlePriceServiceApplication}.
 */

@SpringBootTest(classes = ArticlePriceServiceApplication.class)
public class ArticlePriceServiceApplicationTest
{
    @Autowired
    private ArticlePriceController articlePriceController;

    @Autowired
    private ArticlePriceConfig articlePriceConfig;

    @Test
    void testContext() throws Exception
    {
        assertNotNull(articlePriceController, "Expects started context");
        assertEquals("", articlePriceConfig.getUniqueApplicationProperty());
    }
}
