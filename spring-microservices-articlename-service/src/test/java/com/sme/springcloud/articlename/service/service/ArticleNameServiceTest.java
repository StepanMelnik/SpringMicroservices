package com.sme.springcloud.articlename.service.service;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sme.springcloud.articlename.service.config.ArticleNameConfig;
import com.sme.springcloud.articlename.service.model.ArticleName;
import com.sme.springcloud.articlename.service.repository.IArticleNameRepository;

/**
 * Unot tests of {@link ArticleNameService}.
 */
public class ArticleNameServiceTest
{
    @Mock
    private IArticleNameRepository articleNameRepository;

    @Mock
    private ArticleNameConfig articleNameConfig;

    private IArticleNameService articleNameService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        articleNameService = new ArticleNameService(articleNameRepository, articleNameConfig);
        whens();
    }

    private void whens()
    {
        when(articleNameRepository.findByArtId(1)).thenReturn(asList(new ArticleName()));
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(asList(new ArticleName()), articleNameService.findByArtId(1));
        verify(articleNameRepository, times(1)).findByArtId(1);
        verify(articleNameConfig, times(1)).getUniqueApplicationProperty();
    }
}
