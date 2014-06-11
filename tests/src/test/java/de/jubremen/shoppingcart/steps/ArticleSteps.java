package de.jubremen.shoppingcart.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.jubremen.shoppingcart.pages.ArticlePage;

public class ArticleSteps {

    @Given("the user has started the application")
    public void startApplication() {
        ArticlePage articlePage = new ArticlePage();
        articlePage.get();
    }
    
    
    @When("the user searches for (.*)")
    public void search(String searchValue) {
        ArticlePage articlePage = getArticlePage();
        
        articlePage.searchForArticles(searchValue);
    }
    
    
    @When("the user adds the article (.*)")
    public void addArticle(String name) {
        ArticlePage articlePage = getArticlePage();
        
        articlePage.addArticle(name);
    }
    
    
    @Then("the total price should be (.*)")
    public void checkTotalPrice(double expectedPrice) {
        ArticlePage articlePage = getArticlePage();
        
        assertThat(articlePage.getTotalPrice(), is(expectedPrice));
    }


    private ArticlePage getArticlePage() {
        ArticlePage articlePage = new ArticlePage();
        articlePage.get();
        return articlePage;
    }
}
