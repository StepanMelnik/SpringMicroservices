package com.sme.springcloud.articleattribute.service.service;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sme.springcloud.articleattribute.service.config.ArticleAttributeConfig;
import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.repository.IArticleAttributeRepository;

/**
 * Uit tests of {@link ArticleAttributeService}.
 */
public class ArticleAttributeServiceTest
{
    @Mock
    private IArticleAttributeRepository articleAttributeRepository;

    @Mock
    private ArticleAttributeConfig articleAttributeConfig;

    private IArticleAttributeService articleAttributeService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        articleAttributeService = new ArticleAttributeService(articleAttributeRepository, articleAttributeConfig);
        whens();
    }

    private void whens()
    {
        when(articleAttributeRepository.findByArtId(1)).thenReturn(asList(new ArticleAttribute()));
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(asList(new ArticleAttribute()), articleAttributeService.findByArtId(1));
        verify(articleAttributeRepository, times(1)).findByArtId(1);
        verify(articleAttributeConfig, times(1)).getUniqueApplicationProperty();
    }
}
