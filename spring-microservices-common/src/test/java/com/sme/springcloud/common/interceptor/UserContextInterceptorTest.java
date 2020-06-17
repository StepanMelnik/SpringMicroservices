package com.sme.springcloud.common.interceptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.LinkedMultiValueMap;

import com.sme.springcloud.common.util.UserContextHolder;

/**
 * Unit tests of {@link UserContextInterceptor}.
 */
public class UserContextInterceptorTest
{
    @Mock
    private ClientHttpRequestExecution clientHttpRequestExecution;
    @Mock
    private HttpRequest httpRequest;
    @Mock
    private HttpHeaders httpHeaders;
    @Mock
    private ClientHttpResponse clientHttpResponse;

    private UserContextInterceptor userContextInterceptor;

    @BeforeEach
    public void setUp() throws Exception
    {
        UserContextHolder.remove();
        MockitoAnnotations.initMocks(this);

        userContextInterceptor = new UserContextInterceptor();
        mockWhens();
    }

    @AfterEach
    public void tearDown() throws Exception
    {
        UserContextHolder.remove();
    }

    private void mockWhens() throws IOException
    {
        when(httpRequest.getHeaders()).thenReturn(new HttpHeaders());
        when(clientHttpRequestExecution.execute(httpRequest, new byte[] {})).thenReturn(clientHttpResponse);
    }

    @Test
    void testIntercept() throws Exception
    {
        userContextInterceptor.intercept(httpRequest, new byte[] {}, clientHttpRequestExecution);

        LinkedMultiValueMap<String, String> expected = new LinkedMultiValueMap<>(2);
        expected.put("correlation-id", Arrays.asList(""));
        expected.put("auth-token", Arrays.asList(""));

        assertEquals(expected, httpRequest.getHeaders(), "Expects correlation-id and auth-token headers");
    }
}
