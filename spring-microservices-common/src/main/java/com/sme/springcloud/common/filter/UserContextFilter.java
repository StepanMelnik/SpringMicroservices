package com.sme.springcloud.common.filter;

import static com.sme.springcloud.common.model.UserContext.AUTH_TOKEN;
import static com.sme.springcloud.common.model.UserContext.CORRELATION_ID;
import static com.sme.springcloud.common.model.UserContext.USER_ID;
import static com.sme.springcloud.common.util.UserContextHolder.getContext;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sme.springcloud.common.model.UserContext;

/**
 * User context filter to fetch an info about user from headers and create {@link UserContext}.
 */
@Component
public class UserContextFilter implements Filter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        getContext().setCorrelationId(httpServletRequest.getHeader(CORRELATION_ID));
        getContext().setUserId(httpServletRequest.getHeader(USER_ID));
        getContext().setAuthToken(httpServletRequest.getHeader(AUTH_TOKEN));

        LOGGER.debug("Incoming Correlation id: {}", getContext().getCorrelationId());

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void destroy()
    {
    }
}
