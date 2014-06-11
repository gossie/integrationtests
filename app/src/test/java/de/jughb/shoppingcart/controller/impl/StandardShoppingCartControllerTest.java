package de.jughb.shoppingcart.controller.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.jughb.shoppingcart.controller.impl.StandardShoppingCartController;
import de.jughb.shoppingcart.model.Article;


public class StandardShoppingCartControllerTest {

    private StandardShoppingCartController shoppingCartController;
    
    
    @Before
    public void setUp() {
        shoppingCartController = new StandardShoppingCartController();
    }
    
    
    @Test
    public void testAddArticle() throws Exception {
        Article article = new Article("", "Telefon 4711", "", 299.00);
        shoppingCartController.addArticle(article);
        
        assertThat(shoppingCartController.getArticles(), hasSize(1));
    }


    @Test
    public void testGetTotalPrice() throws Exception {
        Article article1 = new Article("", "Telefon 4711", "", 299.00);
        Article article2 = new Article("", "Telefon 4711", "", 399.00);
        shoppingCartController.addArticle(article1);
        shoppingCartController.addArticle(article2);
        
        assertThat(shoppingCartController.getTotalPrice(), is(698.00));
    }
}
