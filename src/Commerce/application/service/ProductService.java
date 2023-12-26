package Commerce.application.service;

import Commerce.application.domain.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ProductService {
    List<String> CATERORY = new ArrayList<>();
    List<Product> PRODUCTS = new LinkedList<>();

    void AddCategory(String name);
    // this method for add Category
    void EditCategory(String oldName, String newName);
    // this method for edit name of category
    void addProduct(Product product);
    // this method for add product
    void deleteProduct(String name);
    // this method for deleting product from list
    void editProducts(String oldName, String name);
    // this method for changing name and number of products
    void seeAllProductsByCategory(String categoryName);
    void purcaseProduct(String name, Integer NumbreOfProducts);
    void showAllCategories();
    void showAllProductsName();
    boolean isTheCategoryExist(String categoryName);
    Product getByName(String name);
}
