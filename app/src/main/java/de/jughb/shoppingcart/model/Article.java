package de.jughb.shoppingcart.model;

public class Article {

    private String id;
    private String name;
    private String description;
    private double price;
    
    
    public Article(String id, String name, String description, double price) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    
    public String getId() {
        return id;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public String getDescription() {
        return description;
    }
    
    
    public double getPrice() {
        return price;
    }
}
