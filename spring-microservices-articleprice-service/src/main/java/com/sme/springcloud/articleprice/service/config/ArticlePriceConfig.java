package com.sme.springcloud.articleprice.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The configuration of project.
 * 
 * <pre>
 * Check the configuration properties in config-server:
 *  <ul>
 *      <li>http://localhost:8888/articlepriceservice/default</li>
 *      <li>http://localhost:8888/articlepriceservice/dev</li>
 *      <li>http://localhost:8888/articlepriceservice/prod</li>
 *  </ul>
 * </pre>
 */
@Component
public class ArticlePriceConfig
{
    @Value("${unique.app.property:#{null}}")
    private final String uniqueApplicationProperty = "";

    public String getUniqueApplicationProperty()
    {
        return uniqueApplicationProperty;
    }
}
