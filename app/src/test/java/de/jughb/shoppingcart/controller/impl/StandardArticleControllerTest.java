package de.jughb.shoppingcart.controller.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.rmi.server.UID;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.jughb.shoppingcart.controller.impl.StandardArticleController;
import de.jughb.shoppingcart.model.Article;
import de.jughb.shoppingcart.services.ArticleService;

@RunWith(MockitoJUnitRunner.class)
public class StandardArticleControllerTest {

    @InjectMocks
    private StandardArticleController articleController;
    @Mock
    private ArticleService articleService;
    
    
    @Before
    public void setUp() {
        Article article = new Article(new UID().toString(), "Telefon 4711", "Ein supergeiles Telefon", 299.99);
        when(articleService.provideArticles("Telefon 4711")).thenReturn(Arrays.asList(article));
    }
    
    
    @Test
    public void testSearchForArticles() throws Exception {
        articleController.setSearchValue("Telefon 4711");
        articleController.searchArticles();
        
        assertThat(articleController.getSearchValue(), is("Telefon 4711"));
        assertThat(articleController.getFoundArticles(), hasSize(1));
    }
}
