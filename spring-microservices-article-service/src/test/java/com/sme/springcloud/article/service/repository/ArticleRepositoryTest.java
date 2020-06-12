package com.sme.springcloud.article.service.repository;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Unit tests of {ArticleRepsitory}.
 */
public class ArticleRepositoryTest
{
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp()
    {
        articleRepository = new ArticleRepository();
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(ArticleTD.ARTICLE_1, articleRepository.findByArtId(1).get());
        assertEquals(empty(), articleRepository.findByArtId(10000));
    }

    /**
     * Article test data in memory.
     */
    //CSOFF
    private static class ArticleTD
    {
        private static Article ARTICLE_1 = new PojoGenericBuilder<>(Article::new)
                .with(Article::setArtId, 1)
                .build();
    }
    //CSON
}
