package com.sme.springcloud.article.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The configuration of project.
 * 
 * <pre>
 * Check the configuration properties in config-server:
 *  <ul>
 *      <li>http://localhost:8888/articleservice/default</li>
 *      <li>http://localhost:8888/articleservice/dev</li>
 *      <li>http://localhost:8888/articleservice/prod</li>
 *  </ul>
 * </pre>
 */
@Component
public class ArticleConfig
{
    @Value("${unique.app.property:#{null}}")
    private final String uniqueApplicationProperty = "";

    public String getUniqueApplicationProperty()
    {
        return uniqueApplicationProperty;
    }
}
