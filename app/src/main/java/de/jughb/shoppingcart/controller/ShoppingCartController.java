package de.jughb.shoppingcart.controller;

import java.util.List;

import de.jughb.shoppingcart.model.Article;

public interface ShoppingCartController {

	void addArticle(Article article);
	
	
	List<Article> getArticles();
	
	
	double getTotalPrice();
}
