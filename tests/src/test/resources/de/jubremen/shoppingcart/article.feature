Feature: Articles
	Scenario Outline: A user adds some articles
		Given the user has started the application
		When the user searches for <searchValue1>
		And the user adds the article <article1>
		And the user searches for <searchValue2>
		And the user adds the article <article2>
		And the user searches for <searchValue3>
		And the user adds the article <article3>
		Then the total price should be <expectedPrice>
		
	Examples:
	    | searchValue1 | article1    | searchValue2 | article2      | searchValue3 | article3     | expectedPrice |
	    | Tablet       | Tablet 4713 | Notebook     | Notebook 4711 | Telefon      | Telefon 4712 | 1299.97       |
	    | Tablet       | Tablet 4711 | Notebook     | Notebook 4711 | Telefon      | Telefon 4711 | 999.97        |
