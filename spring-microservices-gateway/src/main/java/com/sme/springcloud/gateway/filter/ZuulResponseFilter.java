package com.sme.springcloud.gateway.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.sme.springcloud.common.model.UserContext;

/**
 * Zuul response filter.
 */
@Component
public class ZuulResponseFilter extends ZuulFilter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulResponseFilter.class);

    private final ZuulFilterHelper zuuFilterHelper;

    public ZuulResponseFilter(ZuulFilterHelper zuuFilterHelper)
    {
        this.zuuFilterHelper = zuuFilterHelper;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        LOGGER.debug("Processing response headers with {} correlation id", zuuFilterHelper.getCorrelationId());
        getCurrentContext().getResponse().addHeader(UserContext.CORRELATION_ID, zuuFilterHelper.getCorrelationId().get());
        LOGGER.debug("Fiishing {} request", getCurrentContext().getRequest().getRequestURI());

        return null;
    }

    @Override
    public String filterType()
    {
        return ZuulFilterHelper.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return 0;
    }
}
