package com.sme.springcloud.article.service.service;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sme.springcloud.article.service.config.ArticleConfig;
import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.article.service.repository.IArticleRepository;

/**
 * Unit tests of {@link ArticleService}.
 */
public class ArticleServiceTest
{
    @Mock
    private IArticleRepository articleRepository;

    @Mock
    private ArticleConfig articleConfig;

    private IArticleService articleService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        articleService = new ArticleService(articleRepository, articleConfig);
        whens();
    }

    private void whens()
    {
        when(articleRepository.findByArtId(1)).thenReturn(of(new Article()));
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(of(new Article()), articleService.findByArtId(1));
        verify(articleRepository, times(1)).findByArtId(1);
        verify(articleConfig, times(1)).getUniqueApplicationProperty();
    }
}
