package com.sme.springcloud.articleattribute.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The wrapper to work with {@link ArticleAttribute} list.
 */
public class ArticleAttributeWrapper
{
    private List<ArticleAttribute> articleAttributes = new ArrayList<>();

    public List<ArticleAttribute> getArticleAttributes()
    {
        return articleAttributes;
    }

    public void setArticleAttributes(List<ArticleAttribute> articleAttributes)
    {
        this.articleAttributes = articleAttributes;
    }
}
