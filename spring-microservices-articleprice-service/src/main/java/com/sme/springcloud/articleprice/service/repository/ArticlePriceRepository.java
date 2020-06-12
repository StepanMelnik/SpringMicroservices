package com.sme.springcloud.articleprice.service.repository;

import static java.math.RoundingMode.HALF_UP;
import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Article price repository in memory implementation.
 */
@Repository
public class ArticlePriceRepository implements IArticlePriceRepository
{
    @Override
    public List<ArticlePrice> findByArtId(int artId)
    {
        return ArticlePriceTD.ARTICLE_PRICES.stream().filter(ap -> ap.getArtId() == artId).collect(toList());
    }

    @Override
    public Optional<ArticlePrice> findBy(Integer artId, Integer attr1Id, Integer attr2Id, Integer attr3Id)
    {
        return ArticlePriceTD.ARTICLE_PRICES.stream()
                .filter(ap -> ap.getArtId() == artId && ap.getAttr1Id() == attr1Id && ap.getAttr2Id() == attr2Id && ap.getAttr3Id() == attr3Id)
                .findAny();
    }

    /**
     * ArticlePrice Data in memory.
     */
    //CSOFF
    private static class ArticlePriceTD
    {
        private static List<ArticlePrice> ARTICLE_PRICES = Arrays.asList(
                new PojoGenericBuilder<>(ArticlePrice::new)
                        .with(ArticlePrice::setId, 1)
                        .with(ArticlePrice::setArtId, 1)
                        .with(ArticlePrice::setAttr1Id, 1)
                        .with(ArticlePrice::setAttr2Id, 1)
                        .with(ArticlePrice::setAttr3Id, 0)
                        .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                        .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                        .with(ArticlePrice::setVat, 0.25f)
                        .build(),
                new PojoGenericBuilder<>(ArticlePrice::new)
                        .with(ArticlePrice::setId, 1)
                        .with(ArticlePrice::setArtId, 1)
                        .with(ArticlePrice::setAttr1Id, 1)
                        .with(ArticlePrice::setAttr2Id, 2)
                        .with(ArticlePrice::setAttr3Id, 0)
                        .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                        .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                        .with(ArticlePrice::setVat, 0.25f)
                        .build(),
                new PojoGenericBuilder<>(ArticlePrice::new)
                        .with(ArticlePrice::setId, 1)
                        .with(ArticlePrice::setArtId, 1)
                        .with(ArticlePrice::setAttr1Id, 1)
                        .with(ArticlePrice::setAttr2Id, 3)
                        .with(ArticlePrice::setAttr3Id, 0)
                        .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                        .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                        .with(ArticlePrice::setVat, 0.25f)
                        .build());
    }
    //CSON
}
