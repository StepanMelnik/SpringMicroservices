package com.sme.springcloud.articleattribute.service.repository;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.model.Attribute1;
import com.sme.springcloud.articleattribute.service.model.Attribute2;
import com.sme.springcloud.articleattribute.service.model.Attribute3;
import com.sme.springcloud.common.builder.PojoGenericBuilder;

/**
 * Article attribute repository in memory implementation.
 */
@Repository
public class ArticleAttributeRepository implements IArticleAttributeRepository
{
    @Override
    public List<ArticleAttribute> findByArtId(int artId)
    {
        return ArticleAttributeTD.ARTICLE_ATTRIBUTES.stream()
                .filter(aa -> aa.getArtId() == artId)
                .collect(toList());
    }

    /**
     * ArticleAttribute Data in memory.
     */
    //CSOFF
    private static class ArticleAttributeTD
    {
        private static List<ArticleAttribute> ARTICLE_ATTRIBUTES = asList(
                new PojoGenericBuilder<>(ArticleAttribute::new)
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
                        .build(),
                new PojoGenericBuilder<>(ArticleAttribute::new)
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
                        .build(),
                new PojoGenericBuilder<>(ArticleAttribute::new)
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
                        .build());
    }
    //CSON
}
