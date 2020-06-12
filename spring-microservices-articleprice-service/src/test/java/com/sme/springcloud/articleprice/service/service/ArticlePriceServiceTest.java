package com.sme.springcloud.articleprice.service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sme.springcloud.articleprice.service.config.ArticlePriceConfig;
import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.articleprice.service.repository.IArticlePriceRepository;

/**
 * Unit tests of {@link ArticlePriceService}.
 */
public class ArticlePriceServiceTest
{
    @Mock
    private IArticlePriceRepository articlePriceRepository;

    @Mock
    private ArticlePriceConfig articlePriceConfig;

    private IArticlePriceService articlePriceService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        articlePriceService = new ArticlePriceService(articlePriceRepository, articlePriceConfig);
        whens();
    }

    private void whens()
    {
        when(articlePriceRepository.findBy(1, 1, 1, 0)).thenReturn(Optional.of(new ArticlePrice()));
    }

    @Test
    void testFindBy() throws Exception
    {
        assertEquals(new ArticlePrice(), articlePriceService.findBy(1, 1, 1, 0).get());
        verify(articlePriceRepository, times(1)).findBy(1, 1, 1, 0);
        verify(articlePriceConfig, times(1)).getUniqueApplicationProperty();
    }
}
