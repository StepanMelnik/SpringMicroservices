package com.sme.springcloud.article.service.controller;

import static java.util.Optional.of;
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

import com.sme.springcloud.article.service.model.Article;
import com.sme.springcloud.article.service.service.IArticleService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Unit tests of {@link ArticleController}.
 */
public class ArticleControllerTest
{
    @Mock
    private IArticleService articleService;

    private MockWebServer server;
    private ArticleController articleController;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        whens();

        server = new MockWebServer();

        articleController = new ArticleController(articleService, new RestTemplate());
        articleController.setArticleAttributeHost(server.url("/attributes").toString());
        articleController.setArticleNameHost(server.url("/names").toString());
    }

    @AfterEach
    void shutdown() throws IOException
    {
        this.server.shutdown();
    }

    private void whens()
    {
        when(articleService.findByArtId(1)).thenReturn(of(new Article()));
    }

    @Test
    void testfindByArtId() throws Exception
    {
        prepareResponse(response -> response
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));

        prepareResponse(response -> response
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));

        ResponseEntity<Article> article = articleController.getArticle(1);
        assertEquals(HttpStatus.OK, article.getStatusCode());
        assertEquals(new Article(), article.getBody());

        verify(articleService, times(1)).findByArtId(1);
    }

    private void prepareResponse(Consumer<MockResponse> consumer)
    {
        MockResponse response = new MockResponse();
        consumer.accept(response);
        this.server.enqueue(response);
    }
}
