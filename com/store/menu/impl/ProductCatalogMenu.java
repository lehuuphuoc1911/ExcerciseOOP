package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.Cart;
import com.store.enteties.Product;
import com.store.enteties.impl.DefaultProduct;
import com.store.menu.Menu;
import com.store.services.ProductManagementService;
import com.store.services.impl.DefaultProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;
    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();

    }

    @Override
    public void start() {
        Menu gotoMenu = null;
        printMenuHeader();
        while (true){

            String userInput = readUserInput();
            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                gotoMenu = new MainMenu();
                break;
            } else {
                if (context.getLoggedInUser()==null){
                    System.out.println("You have not logged in yet. Enter `menu` to go back.");
                    gotoMenu = context.getMainMenu();
                    break;
                } else {
                    if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)){
                        Cart sessionCart = context.getSessionCart();
                        if (sessionCart == null || sessionCart.isEmpty()) {
                            System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
                        } else {
                            gotoMenu = new CheckOutMenu();
                            break;
                        }

                    } else {
                        try{
                            int productID = Integer.parseInt(userInput);
                            Product product = productManagementService.getProductById(productID);
                            context.getSessionCart().addProduct(product);
                            System.out.println("Add product: " + product.toString());

                        } catch (Exception e){
                            System.out.println("Product Id does not exist.");
                        }
                    }
                }
            }

        }
        gotoMenu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
        printProductsToConsole();
    }
    private void printProductsToConsole() {


        for (int i = 0; i<productManagementService.getProducts().length;i++){
            if (productManagementService.getProducts()[i]!=null) {
                System.out.println(productManagementService.getProducts()[i].toString());
            }
        }
    }
    private String readUserInput() {
        System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        return userInput;
    }
}
