package com.sme.springcloud.articleattribute.service.controller;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.function.Consumer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sme.springcloud.articleattribute.service.model.ArticleAttribute;
import com.sme.springcloud.articleattribute.service.model.ArticleAttributeWrapper;
import com.sme.springcloud.articleattribute.service.service.IArticleAttributeService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Unit tests of {@link ArticleAttributeController}.
 */
public class ArticleAttributeControllerTest
{
    @Mock
    private IArticleAttributeService articleAttributeService;

    private MockWebServer server;
    private ArticleAttributeController articleAttributeController;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        whens();

        server = new MockWebServer();

        articleAttributeController = new ArticleAttributeController(articleAttributeService, new RestTemplate());
        articleAttributeController.setArticlePriceHost(server.url("/").toString());
    }

    @AfterEach
    void shutdown() throws IOException
    {
        this.server.shutdown();
    }

    private void whens()
    {
        when(articleAttributeService.findByArtId(1)).thenReturn(asList(new ArticleAttribute()));
    }

    @Test
    void testGetArticleAttributes() throws Exception
    {
        prepareResponse(response -> response
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));

        ResponseEntity<ArticleAttributeWrapper> articleAttributeWrapper = articleAttributeController.getArticleAttributes(1);
        assertEquals(HttpStatus.OK, articleAttributeWrapper.getStatusCode());

        ArticleAttributeWrapper expectedArticleAttributeWrapper = new ArticleAttributeWrapper();
        expectedArticleAttributeWrapper.setArticleAttributes(asList(new ArticleAttribute()));
        assertEquals(expectedArticleAttributeWrapper.getArticleAttributes(), articleAttributeWrapper.getBody().getArticleAttributes());

        verify(articleAttributeService, times(1)).findByArtId(1);
    }

    private void prepareResponse(Consumer<MockResponse> consumer)
    {
        MockResponse response = new MockResponse();
        consumer.accept(response);
        this.server.enqueue(response);
    }
}
