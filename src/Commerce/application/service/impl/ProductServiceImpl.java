package Commerce.application.service.impl;

import Commerce.application.domain.Product;
import Commerce.application.service.ProductService;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ProductServiceImpl implements ProductService {
    @Override
    public void AddCategory(String name) {
        CATERORY.add(name);
    }

    @Override
    public void EditCategory(String oldName, String newName) {
        CATERORY.add(newName);
        for (Product product: PRODUCTS) {
            if(product.getCategory().equals(oldName)) {
                PRODUCTS.get(PRODUCTS.indexOf(product)).setCategory(newName);
            }
        }
        CATERORY.remove(oldName);
    }

    @Override
    public void addProduct(Product product) {
        PRODUCTS.add(product);
    }

    @Override
    public void deleteProduct(String name) {
        for (Product product:PRODUCTS) {
            PRODUCTS.remove(product);
        }
    }

    @Override
    public void editProducts(String oldName, String name) {
        PRODUCTS.get(PRODUCTS.indexOf(oldName)).setName(name);
    }

    @Override
    public void seeAllProductsByCategory(String categoryName) {
        for (Product product: PRODUCTS) {
            if(product.getCategory().equals(categoryName)) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void purcaseProduct(String name, Integer NumbreOfProducts) {
        getByName(name).setNumberOfProducts(getByName(name).getNumberOfProducts()-NumbreOfProducts);
        System.out.println("Sucessfuly");
    }

    @Override
    public void showAllCategories() {
        for (String name: CATERORY) {
            System.out.println(name);
        }
    }

    @Override
    public void showAllProductsName() {
        for (Product product:PRODUCTS) {
            System.out.println(product);
        }
    }

    @Override
    public boolean isTheCategoryExist(String categoryName) {
        for (String name: CATERORY) {
            if(name == categoryName){
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getByName(String name) throws RuntimeException{
        for (Product product: PRODUCTS) {
            if(product.getName().equals(name))
                return product;
        }
        throw new RuntimeException();
    }

}
