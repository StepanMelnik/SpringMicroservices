package com.sme.springcloud.gateway.filter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;
import com.sme.springcloud.common.model.UserContext;

/**
 * The helper provides useful functionalities to create Zuul filters.
 */
@Component
class ZuulFilterHelper
{
    static final String PRE_FILTER_TYPE = "pre";
    static final String POST_FILTER_TYPE = "post";
    static final String ROUTE_FILTER_TYPE = "route";

    /**
     * Fetch correlation id from Zuul context.
     * 
     * @return Returns Correlation id from Zuul context.
     */
    Optional<String> getCorrelationId()
    {
        RequestContext context = RequestContext.getCurrentContext();
        return context.getRequest().getHeader(UserContext.CORRELATION_ID) != null ? Optional.of(context.getRequest().getHeader(UserContext.CORRELATION_ID))
            : Optional.ofNullable(context.getZuulRequestHeaders().get(UserContext.CORRELATION_ID));
    }
}
