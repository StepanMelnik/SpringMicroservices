package com.sme.springcloud.articlename.service.controller;

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

import com.sme.springcloud.articlename.service.model.ArticleName;
import com.sme.springcloud.articlename.service.model.ArticleNameWrapper;
import com.sme.springcloud.articlename.service.service.IArticleNameService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Unit tests of {@link ArticleNameController}.
 */
public class ArticleNameControllerTest
{
    @Mock
    private IArticleNameService articleNameService;

    private MockWebServer server;
    private ArticleNameController articleNameController;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        whens();

        server = new MockWebServer();

        articleNameController = new ArticleNameController(articleNameService);
    }

    @AfterEach
    void shutdown() throws IOException
    {
        this.server.shutdown();
    }

    private void whens()
    {
        when(articleNameService.findByArtId(1)).thenReturn(asList(new ArticleName()));
    }

    @Test
    void testGetArticleNames() throws Exception
    {
        prepareResponse(response -> response
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));

        ResponseEntity<ArticleNameWrapper> articleNameWrapper = articleNameController.getArticleNames(1);
        assertEquals(HttpStatus.OK, articleNameWrapper.getStatusCode());

        ArticleNameWrapper expectedArticleNameWrapper = new ArticleNameWrapper();
        expectedArticleNameWrapper.setArticleNames(asList(new ArticleName()));
        assertEquals(expectedArticleNameWrapper.getArticleNames(), articleNameWrapper.getBody().getArticleNames());

        verify(articleNameService, times(1)).findByArtId(1);
    }

    private void prepareResponse(Consumer<MockResponse> consumer)
    {
        MockResponse response = new MockResponse();
        consumer.accept(response);
        this.server.enqueue(response);
    }
}
