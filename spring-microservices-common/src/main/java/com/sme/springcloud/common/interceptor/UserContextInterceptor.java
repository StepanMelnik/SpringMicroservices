package com.sme.springcloud.common.interceptor;

import static com.sme.springcloud.common.util.UserContextHolder.getContext;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import com.sme.springcloud.common.model.UserContext;

/**
 * Request interceptor to specify headers in request.
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException
    {
        LOGGER.debug("Set CorrelationId and AuthToken in headers");

        HttpHeaders headers = request.getHeaders();
        headers.add(UserContext.CORRELATION_ID, getContext().getCorrelationId());
        headers.add(UserContext.AUTH_TOKEN, getContext().getAuthToken());

        return execution.execute(request, body);
    }
}
