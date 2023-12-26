package Commerce.application.domain;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private Integer numberOfProducts;
    private String category;

    public Product(String name, Integer amountOfProduct, String category) {
        this.name = name;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", numberOfProducts=" + numberOfProducts +
                '}';
    }
}
