package com.sme.springcloud.articleprice.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sme.springcloud.articleprice.service.model.ArticlePrice;
import com.sme.springcloud.articleprice.service.service.IArticlePriceService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Unit tests of {@link ArticlePriceController}.
 */
public class ArticlePriceControllerTest
{
    @Mock
    private IArticlePriceService articlePriceService;

    private MockWebServer server;
    private ArticlePriceController articlePriceController;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        whens();

        server = new MockWebServer();

        articlePriceController = new ArticlePriceController(articlePriceService);
    }

    @AfterEach
    void shutdown() throws IOException
    {
        this.server.shutdown();
    }

    private void whens()
    {
        when(articlePriceService.findBy(1, 1, 1, 0)).thenReturn(Optional.of(new ArticlePrice()));
    }

    @Test
    void testGetArticlePrice() throws Exception
    {
        prepareResponse(response -> response
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));

        ResponseEntity<ArticlePrice> articlePrice = articlePriceController.getArticlePrice(1, 1, 1, 0);
        assertEquals(HttpStatus.OK, articlePrice.getStatusCode());
        assertEquals(new ArticlePrice(), articlePrice.getBody());

        verify(articlePriceService, times(1)).findBy(1, 1, 1, 0);
    }

    private void prepareResponse(Consumer<MockResponse> consumer)
    {
        MockResponse response = new MockResponse();
        consumer.accept(response);
        this.server.enqueue(response);
    }
}
