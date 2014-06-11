package de.jughb.shoppingcart.services.impl;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

import de.jughb.shoppingcart.model.Article;
import de.jughb.shoppingcart.services.ArticleService;

public class StandardArticleService implements ArticleService {
	private List<Article> articles = new ArrayList<Article>();
	

	public void init() {
		articles.add(new Article(new UID().toString(), "Telefon 4711", "Ein supergeiles Telefon", 99.99));
		articles.add(new Article(new UID().toString(), "Telefon 4712", "Ein supergeiles Telefon", 199.99));
		articles.add(new Article(new UID().toString(), "Telefon 4713", "Ein supergeiles Telefon", 299.99));
		articles.add(new Article(new UID().toString(), "Telefon 4714", "Ein supergeiles Telefon", 399.99));
		articles.add(new Article(new UID().toString(), "Telefon 4715", "Ein supergeiles Telefon", 499.99));
		articles.add(new Article(new UID().toString(), "Notebook 4711", "Ein supergeiles Notebook", 599.99));
		articles.add(new Article(new UID().toString(), "Notebook 4712", "Ein supergeiles Notebook", 899.99));
		articles.add(new Article(new UID().toString(), "Notebook 4713", "Ein supergeiles Notebook", 1199.99));
		articles.add(new Article(new UID().toString(), "Tablet 4711", "Ein supergeiles Tablet", 299.99));
		articles.add(new Article(new UID().toString(), "Tablet 4712", "Ein supergeiles Tablet", 399.99));
		articles.add(new Article(new UID().toString(), "Tablet 4713", "Ein supergeiles Tablet", 499.99));
		articles.add(new Article(new UID().toString(), "Tablet 4714", "Ein supergeiles Tablet", 599.99));
	}

	
	@Override
	public List<Article> provideArticles(String searchValue) {
		String prefix = getPrefix(searchValue);
		
		List<Article> result = new ArrayList<>();
		for(Article article : articles) {
			if(article.getName().startsWith(prefix)) {
				result.add(article);
			}
		}
		return result;
	}


	private String getPrefix(String searchValue) {
		String prefix = "";
		if(searchValue != null) {
			prefix = searchValue;
		}
		return prefix;
	}
}
