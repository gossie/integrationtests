package de.jughb.shoppingcart.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.jughb.shoppingcart.controller.ArticleController;
import de.jughb.shoppingcart.model.Article;
import de.jughb.shoppingcart.services.ArticleService;

public class StandardArticleController implements ArticleController {
    
    @Autowired
    private ArticleService articleService;

    private List<Article> foundArticles = new ArrayList<>();
    private String searchValue;
    
    
    @Override
    public void searchArticles() {
        foundArticles.clear();
        foundArticles.addAll(articleService.provideArticles(searchValue));
    }


    @Override
    public String getSearchValue() {
        return searchValue;
    }


    @Override
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }


    @Override
    public List<Article> getFoundArticles() {
        return foundArticles;
    }
}
