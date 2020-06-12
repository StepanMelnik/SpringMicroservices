package com.sme.springcloud.articlename.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The wrapper to work with {@link ArticleName} list.
 */
public class ArticleNameWrapper
{
    private List<ArticleName> articleNames = new ArrayList<>();

    public List<ArticleName> getArticleNames()
    {
        return articleNames;
    }

    public void setArticleNames(List<ArticleName> articleNames)
    {
        this.articleNames = articleNames;
    }
}
