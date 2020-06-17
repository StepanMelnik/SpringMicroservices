package com.sme.springcloud.articlename.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration of project.
 * 
 * <pre>
 * Check the configuration properties in config-server:
 *  <ul>
 *      <li>http://localhost:8888/articlenameservice/default</li>
 *      <li>http://localhost:8888/articlenameservice/dev</li>
 *      <li>http://localhost:8888/articlenameservice/prod</li>
 *  </ul>
 * </pre>
 */
@Configuration
@ComponentScan("com.sme.springcloud.common.filter")
public class ArticleNameConfig
{
    @Value("${unique.app.property:#{null}}")
    private final String uniqueApplicationProperty = "";

    public String getUniqueApplicationProperty()
    {
        return uniqueApplicationProperty;
    }
}
