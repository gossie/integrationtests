package de.jughb.shoppingcart.services.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.jughb.shoppingcart.model.Article;
import de.jughb.shoppingcart.services.impl.StandardArticleService;


public class StandardArticleServiceTest {
	
	private StandardArticleService articleService;
	
	@Before
	public void setUp() {
		articleService = new StandardArticleService();
		articleService.init();
	}
	
	@Test
	public void testProvideAllArticlesEmptyString() throws Exception {
		List<Article> articles = articleService.provideArticles("");
		assertThat(articles, hasSize(12));
	}
	
	
	@Test
	public void testProvideAllArticlesNull() throws Exception {
		List<Article> articles = articleService.provideArticles(null);
		assertThat(articles, hasSize(12));
	}
	
	
	@Test
	public void testProvideTelephone4711() throws Exception {
		assertThat(articleService.provideArticles("Telefon 4711"), hasSize(1));
	}
	
	@Test
	public void testProvideAllNotebooks() throws Exception {
		assertThat(articleService.provideArticles("Notebook"), hasSize(3));
	}
}
