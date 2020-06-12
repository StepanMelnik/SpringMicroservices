package com.sme.springcloud.articlename.service.repository;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sme.springcloud.articlename.service.model.ArticleName;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Unit tests of {@link ArticleNameRepository}.
 */
public class ArticleNameRepositoryTest
{
    private ArticleNameRepository articleNameRepository;

    @BeforeEach
    public void setUp()
    {
        articleNameRepository = new ArticleNameRepository();
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(ArticleNameTD.ARTICLE_NAMES, articleNameRepository.findByArtId(1));
        assertEquals(EMPTY_LIST, articleNameRepository.findByArtId(10000));
    }

    /**
     * ArticleName test data in memory.
     */
    //CSOFF
    private static class ArticleNameTD
    {
        private static List<ArticleName> ARTICLE_NAMES = asList(
                new PojoGenericBuilder<>(ArticleName::new)
                        .with(ArticleName::setId, 1)
                        .with(ArticleName::setArtId, 1)
                        .with(ArticleName::setActiveFlg, true)
                        .with(ArticleName::setDescription, "Spring t-shirt description")
                        .with(ArticleName::setLangId, 1)
                        .with(ArticleName::setLinkFriendlyName, "/articles/spring-t-shirt")
                        .with(ArticleName::setName, "Spring t-shirt")
                        .build(),
                new PojoGenericBuilder<>(ArticleName::new)
                        .with(ArticleName::setId, 2)
                        .with(ArticleName::setArtId, 1)
                        .with(ArticleName::setActiveFlg, true)
                        .with(ArticleName::setDescription, "Omega t-shirt description (NO language)")
                        .with(ArticleName::setLangId, 2)
                        .with(ArticleName::setLinkFriendlyName, "/no/articles/spring-t-shirt")
                        .with(ArticleName::setName, "Omega t-shirt (NO language)")
                        .build());
    }
    //CSON
}
