package de.jughb.shoppingcart.controller;

import java.util.List;

import de.jughb.shoppingcart.model.Article;

public interface ArticleController {

    void searchArticles();
    
    String getSearchValue();

    void setSearchValue(String searchValue);

    List<Article> getFoundArticles();
}
