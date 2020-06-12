package com.sme.springcloud.articlename.service.repository;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sme.springcloud.articlename.service.model.ArticleName;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Aricle name repository implementation in memory.
 */
@Repository
public class ArticleNameRepository implements IArticleNameRepository
{
    @Override
    public List<ArticleName> findByArtId(int artId)
    {
        return ArticleNameTD.ARTICLE_NAMES.stream().filter(an -> an.getArtId() == artId).collect(toList());
    }

    /**
     * ArticleName Data in memory.
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
