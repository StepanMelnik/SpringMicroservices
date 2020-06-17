package com.sme.springcloud.gateway.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static java.util.UUID.randomUUID;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.sme.springcloud.common.model.UserContext;

/**
 * Tracking filter based on {@link ZuulFilter}.
 */
@Component
public class ZuulTrackingFilter extends ZuulFilter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulTrackingFilter.class);

    private final ZuulFilterHelper zuuFilterHelper;

    public ZuulTrackingFilter(ZuulFilterHelper zuuFilterHelper)
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
        LOGGER.debug("Processing request", getCurrentContext().getRequest().getRequestURI());

        Optional<String> correlationId = zuuFilterHelper.getCorrelationId();
        if (correlationId.isPresent())
        {
            LOGGER.debug("The {} correlation id found in tracking filter", correlationId.get());
        }
        else
        {
            getCurrentContext().addZuulRequestHeader(UserContext.CORRELATION_ID, randomUUID().toString());
            LOGGER.debug("Generated {} correlation id in tracking filter", zuuFilterHelper.getCorrelationId().get());
        }

        return null;
    }

    @Override
    public String filterType()
    {
        return ZuulFilterHelper.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return 0;
    }
}
