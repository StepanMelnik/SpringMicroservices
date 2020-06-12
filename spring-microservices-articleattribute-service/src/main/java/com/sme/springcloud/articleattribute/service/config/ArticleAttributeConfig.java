package com.sme.springcloud.articleattribute.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The configuration of project.
 * 
 * <pre>
 * Check the configuration properties in config-server:
 *  <ul>
 *      <li>http://localhost:8888/articleattributeservice/default</li>
 *      <li>http://localhost:8888/articleattributeservice/dev</li>
 *      <li>http://localhost:8888/articleattributeservice/prod</li>
 *  </ul>
 * </pre>
 */
@Component
public class ArticleAttributeConfig
{
    @Value("${unique.app.property:#{null}}")
    private final String uniqueApplicationProperty = "";

    public String getUniqueApplicationProperty()
    {
        return uniqueApplicationProperty;
    }
}
