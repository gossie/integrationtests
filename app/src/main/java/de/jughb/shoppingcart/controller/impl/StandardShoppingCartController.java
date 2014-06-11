package de.jughb.shoppingcart.controller.impl;

import java.util.ArrayList;
import java.util.List;

import de.jughb.shoppingcart.controller.ShoppingCartController;
import de.jughb.shoppingcart.model.Article;

public class StandardShoppingCartController implements ShoppingCartController {
    
    private List<Article> articles = new ArrayList<>();
    private double totalPrice;
    

    @Override
    public void addArticle(Article article) {
        articles.add(article);
        totalPrice += article.getPrice();
    }
    
    
    @Override
    public List<Article> getArticles() {
        return articles;
    }


    @Override
    public double getTotalPrice() {
        return totalPrice;
    }
}
