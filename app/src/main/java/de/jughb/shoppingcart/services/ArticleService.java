package de.jughb.shoppingcart.services;

import java.util.List;

import de.jughb.shoppingcart.model.Article;

public interface ArticleService {
	List<Article> provideArticles(String searchValue);
}
