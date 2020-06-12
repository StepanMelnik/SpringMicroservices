package com.sme.springcloud.articleprice.service.repository;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Collections.EMPTY_LIST;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Unit tests of {@link ArticlePriceRepository}.
 */
public class ArticlePriceRepositoryTest extends Assertions
{
    private ArticlePriceRepository articlePriceRepository;

    @BeforeEach
    public void setUp()
    {
        articlePriceRepository = new ArticlePriceRepository();
    }

    @Test
    void testFindById() throws Exception
    {
        List<ArticlePrice> findByArtId = articlePriceRepository.findByArtId(1);
        assertEquals(ArticlePriceTD.ARTICLE_PRICES, findByArtId);
        assertEquals(EMPTY_LIST, articlePriceRepository.findByArtId(10000));
    }

    /**
     * ArticlePrice test data.
     */
    //CSOFF
    private static class ArticlePriceTD
    {
        private static ArticlePrice ARTICLE_PRICE_1 = new PojoGenericBuilder<>(ArticlePrice::new)
                .with(ArticlePrice::setId, 1)
                .with(ArticlePrice::setArtId, 1)
                .with(ArticlePrice::setAttr1Id, 1)
                .with(ArticlePrice::setAttr2Id, 1)
                .with(ArticlePrice::setAttr3Id, 0)
                .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                .with(ArticlePrice::setVat, 0.25f)
                .build();

        private static ArticlePrice ARTICLE_PRICE_2 = new PojoGenericBuilder<>(ArticlePrice::new)
                .with(ArticlePrice::setId, 1)
                .with(ArticlePrice::setArtId, 1)
                .with(ArticlePrice::setAttr1Id, 1)
                .with(ArticlePrice::setAttr2Id, 2)
                .with(ArticlePrice::setAttr3Id, 0)
                .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                .with(ArticlePrice::setVat, 0.25f)
                .build();

        private static ArticlePrice ARTICLE_PRICE_3 = new PojoGenericBuilder<>(ArticlePrice::new)
                .with(ArticlePrice::setId, 1)
                .with(ArticlePrice::setArtId, 1)
                .with(ArticlePrice::setAttr1Id, 1)
                .with(ArticlePrice::setAttr2Id, 3)
                .with(ArticlePrice::setAttr3Id, 0)
                .with(ArticlePrice::setRecommendedPrice, new BigDecimal(99.99).setScale(2, HALF_UP))
                .with(ArticlePrice::setSalesPrice, new BigDecimal(98.01).setScale(2, HALF_UP))
                .with(ArticlePrice::setVat, 0.25f)
                .build();

        private static List<ArticlePrice> ARTICLE_PRICES = Arrays.asList(ARTICLE_PRICE_1, ARTICLE_PRICE_2, ARTICLE_PRICE_3);
    }
    //CSON
}
