package com.sme.springcloud.articleattribute.service.repository;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.model.Attribute1;
import com.sme.springcloud.articleattribute.service.model.Attribute2;
import com.sme.springcloud.articleattribute.service.model.Attribute3;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Unit tests of {@link ArticleAttributeRepository}.
 */
public class ArticleAtributeRepositoryTest
{
    private ArticleAttributeRepository articleAtributeRepository;

    @BeforeEach
    public void setUp()
    {
        articleAtributeRepository = new ArticleAttributeRepository();
    }

    @Test
    void testFindById() throws Exception
    {
        assertEquals(ArticleAttributeTD.ARTICLE_ATTRIBUTES, articleAtributeRepository.findByArtId(1));
        assertEquals(EMPTY_LIST, articleAtributeRepository.findByArtId(10000));
    }

    /**
     * ArticleAttribute test data.
     */
    //CSOFF
    private static class ArticleAttributeTD
    {
        private static ArticleAttribute ARTICLE_ATTRIBUTE_1 = new PojoGenericBuilder<>(ArticleAttribute::new)
                .with(ArticleAttribute::setId, 1)
                .with(ArticleAttribute::setArtId, 1)
                .with(ArticleAttribute::setAttr1Id, 1)
                .with(ArticleAttribute::setAttribute1,
                        new PojoGenericBuilder<>(Attribute1::new)
                                .with(Attribute1::setAttr1Id, 1)
                                .with(Attribute1::setAttr1Code, "Black")
                                .with(Attribute1::setAttr1Desc, "Black")
                                .with(Attribute1::setAttr1No, "No1")
                                .with(Attribute1::setRgbCode, "black")
                                .build())
                .with(ArticleAttribute::setAttr2Id, 1)
                .with(ArticleAttribute::setAttribute2,
                        new PojoGenericBuilder<>(Attribute2::new)
                                .with(Attribute2::setAttr2Id, 2)
                                .with(Attribute2::setAttr2Code, "Large")
                                .with(Attribute2::setAttr2Desc, "Large size")
                                .build())
                .with(ArticleAttribute::setAttr3Id, 0)
                .with(ArticleAttribute::setAttribute3,
                        new PojoGenericBuilder<>(Attribute3::new)
                                .with(Attribute3::setAttr3Id, 0)
                                .with(Attribute3::setAttr3Code, "Default")
                                .with(Attribute3::setAttr3Desc, "Default")
                                .build())
                .with(ArticleAttribute::setBalanceDisp, 10)
                .with(ArticleAttribute::setBalancePhy, 10)
                .with(ArticleAttribute::setEan13, "code")
                .with(ArticleAttribute::setHeight, 80.0d)
                .with(ArticleAttribute::setWidth, 10.0d)
                .with(ArticleAttribute::setWeight, 80.0d)
                .build();

        private static ArticleAttribute ARTICLE_ATTRIBUTE_2 = new PojoGenericBuilder<>(ArticleAttribute::new)
                .with(ArticleAttribute::setId, 2)
                .with(ArticleAttribute::setArtId, 1)
                .with(ArticleAttribute::setAttr1Id, 1)
                .with(ArticleAttribute::setAttribute1,
                        new PojoGenericBuilder<>(Attribute1::new)
                                .with(Attribute1::setAttr1Id, 1)
                                .with(Attribute1::setAttr1Code, "Black")
                                .with(Attribute1::setAttr1Desc, "Black")
                                .with(Attribute1::setAttr1No, "No1")
                                .with(Attribute1::setRgbCode, "black")
                                .build())
                .with(ArticleAttribute::setAttr2Id, 2)
                .with(ArticleAttribute::setAttribute2,
                        new PojoGenericBuilder<>(Attribute2::new)
                                .with(Attribute2::setAttr2Id, 2)
                                .with(Attribute2::setAttr2Code, "Smal")
                                .with(Attribute2::setAttr2Desc, "Smal size")
                                .build())
                .with(ArticleAttribute::setAttr3Id, 0)
                .with(ArticleAttribute::setAttribute3,
                        new PojoGenericBuilder<>(Attribute3::new)
                                .with(Attribute3::setAttr3Id, 0)
                                .with(Attribute3::setAttr3Code, "Default")
                                .with(Attribute3::setAttr3Desc, "Default")
                                .build())
                .with(ArticleAttribute::setBalanceDisp, 12)
                .with(ArticleAttribute::setBalancePhy, 12)
                .with(ArticleAttribute::setEan13, "code")
                .with(ArticleAttribute::setHeight, 50.0d)
                .with(ArticleAttribute::setWidth, 10.0d)
                .with(ArticleAttribute::setWeight, 70.0d)
                .build();

        private static ArticleAttribute ARTICLE_ATTRIBUTE_3 = new PojoGenericBuilder<>(ArticleAttribute::new)
                .with(ArticleAttribute::setId, 2)
                .with(ArticleAttribute::setArtId, 1)
                .with(ArticleAttribute::setAttr1Id, 1)
                .with(ArticleAttribute::setAttribute1,
                        new PojoGenericBuilder<>(Attribute1::new)
                                .with(Attribute1::setAttr1Id, 1)
                                .with(Attribute1::setAttr1Code, "Black")
                                .with(Attribute1::setAttr1Desc, "Black")
                                .with(Attribute1::setAttr1No, "No1")
                                .with(Attribute1::setRgbCode, "black")
                                .build())
                .with(ArticleAttribute::setAttr2Id, 3)
                .with(ArticleAttribute::setAttribute2,
                        new PojoGenericBuilder<>(Attribute2::new)
                                .with(Attribute2::setAttr2Id, 3)
                                .with(Attribute2::setAttr2Code, "Middle")
                                .with(Attribute2::setAttr2Desc, "Middl size")
                                .build())
                .with(ArticleAttribute::setAttr3Id, 0)
                .with(ArticleAttribute::setAttribute3,
                        new PojoGenericBuilder<>(Attribute3::new)
                                .with(Attribute3::setAttr3Id, 0)
                                .with(Attribute3::setAttr3Code, "Default")
                                .with(Attribute3::setAttr3Desc, "Default")
                                .build())
                .with(ArticleAttribute::setBalanceDisp, 1)
                .with(ArticleAttribute::setBalancePhy, 1)
                .with(ArticleAttribute::setEan13, "code")
                .with(ArticleAttribute::setHeight, 60.0d)
                .with(ArticleAttribute::setWidth, 12.0d)
                .with(ArticleAttribute::setWeight, 70.0d)
                .build();

        private static List<ArticleAttribute> ARTICLE_ATTRIBUTES = asList(ARTICLE_ATTRIBUTE_1, ARTICLE_ATTRIBUTE_2, ARTICLE_ATTRIBUTE_3);
    }
    //CSON
}
