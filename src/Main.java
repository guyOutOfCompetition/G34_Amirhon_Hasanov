import Commerce.application.domain.Product;
import Commerce.application.domain.User;
import Commerce.application.enums.UserRole;
import Commerce.application.service.ProductService;
import Commerce.application.service.UserService;
import Commerce.application.service.impl.ProductServiceImpl;
import Commerce.application.service.impl.UserServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    static Scanner scInt = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static ProductService productService = new ProductServiceImpl();
    static Boolean inProcess = true;
    public static void main(String[] args) throws IOException {
    User user = loginMenu();
    if(user.getRole().equals(UserRole.OWNER)){
        ownerMenu();
    }
    else{
        costumerMenu(user);
    }
    }
    public static void costumerMenu(User user) throws IOException {
        while (inProcess) {
            Integer userChoose = scInt.nextInt();
            if (userChoose <= 0 || userChoose > 5) {
                break;
            }
            switch (userChoose) {
            case 1->{
                productService.showAllCategories();
                String categoryName = scStr.nextLine();
                productService.seeAllProductsByCategory(categoryName);
            }
            case 2->{
                productService.showAllProductsName();
                System.out.println("What you want to by(Name)");
                String name = scStr.nextLine();
                System.out.println("How namy want to by");
                Integer amount = scInt.nextInt();
                productService.purcaseProduct(name,amount);
                Executors executors = (Executors) Executors.newFixedThreadPool(5);
                Runnable runnable = () -> {
                    File file = new File("C:\\Users\\user\\Desktop\\custumer_history.txt");
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(file, true);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        fileOutputStream.write(
                                (name + " " + LocalDateTime.now().toString() + " buy " + amount.toString()).getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
            }
            }
        }
    }
    public static void ownerMenu(){
        while (inProcess) {
            printOwnerMenu();
            Integer ownerChoose = scInt.nextInt();
            if(ownerChoose <= 0 || ownerChoose > 5){
                break;
            }
            switch (ownerChoose) {
                case 1 -> {
                    System.out.print(" Enter new Category Name : ");
                    String categoryName = scStr.nextLine();
                    productService.AddCategory(categoryName);
                }
                case 2->{
                    productService.showAllCategories();
                    System.out.print("Enter old name of Category : ");
                    String categoryOldName = scStr.nextLine();
                    if(!productService.isTheCategoryExist(categoryOldName)) {
                       return;
                    }
                    System.out.print(" Enter new name for Category : ");
                    String categoryNewName = scStr.nextLine();
                    productService.EditCategory(categoryOldName,categoryNewName);
                }
                case 3->{
                    System.out.println("Enter product Name :");
                    String productName = scStr.nextLine();
                    System.out.println("Enter amount of product :");
                    Integer amountOfProduct = scInt.nextInt();
                    System.out.println("Enter product cagtgegory:");
                    String productCategory = scStr.nextLine();
                    Product product = new Product(productName,amountOfProduct,productCategory);
                    productService.addProduct(product);
                }
                case 4->{
                    productService.showAllProductsName();
                    System.out.println("Enter product which you want to delete :");
                    String productName = scStr.nextLine();
                    productService.deleteProduct(productName);
                }
                case 5->{
                    System.out.print("Enter old name of Product : ");
                    String productOldName = scStr.nextLine();
                    System.out.print(" Enter new name for Prouct : ");
                    String productNewName = scStr.nextLine();
                    productService.editProducts(productOldName,productNewName);
                }
            }
        }
    }
    public static User loginMenu(){
        while (inProcess) {
            printLoginMenu();
            Integer userChoose = scInt.nextInt();
            if(userChoose <= 0 || userChoose >2){
                inProcess = false;
                break;
            }
            switch (userChoose){
                case 1 -> {
                    System.out.println("Enter Name");
                    String userNewName = scStr.nextLine();
                    System.out.println("Enter Password");
                    String userNewPassword = scStr.nextLine();
                    User user = new User(userNewName,userNewPassword);
                    System.out.println(userService.registerUser(user));
                }case 2 -> {
                    System.out.println("Enter Name");
                    String userName = scStr.nextLine();
                    System.out.println("Enter Password");
                    String userPassword = scStr.nextLine();
                    return userService.login(userPassword, userName);
                }
            }
        }
        return null;
    }
    public static void printLoginMenu(){
        System.out.print("""
                1.Regiser
                2.Login
                0.STOP
                  Choose one
                """);
    }
    public static void printOwnerMenu(){
        System.out.println("""
                1.Add category
                2.Edit categoy
                3.Add product
                4.Delete product
                5.Edit product
                0.Exit
                  Choose one
                """);
    }
    public static void printCosumerMenu() {
        System.out.println("""
                1.Show products by category
                2.Purchase product
                """);
    }
}