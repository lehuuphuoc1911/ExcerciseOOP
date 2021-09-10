package com.store.services.impl;

import com.store.enteties.Product;
import com.store.enteties.impl.DefaultProduct;
import com.store.services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {
    private static DefaultProductManagementService instance;

    private static Product[] products;

    static {
        initProducts();
    }

    private static void initProducts() {
        products = new Product[] {
                new DefaultProduct(1, "Running shoes 1", "Shoes", 111.11),
                new DefaultProduct(2, "Running shoes 2", "Shoes", 222.22),
                new DefaultProduct(3, "Running shoes 3", "Shoes", 333.33),
                new DefaultProduct(4, "Football shoes 1", "Shoes", 500.00),
                new DefaultProduct(5, "Football shoes 2", "Shoes", 600.00),
                new DefaultProduct(6, "Football shirt 1", "Shirt", 60.00),
                new DefaultProduct(7, "Football shirt 2", "Shirt", 70.00),
                new DefaultProduct(8, "Football shirt 3", "Shirt", 80.00),
                new DefaultProduct(9, "Football shirt 4", "Shirt", 90.00),
                new DefaultProduct(10, "Football shirt 5", "Shirt", 99.00),
        };
    }

    private DefaultProductManagementService() {

    }

    public static ProductManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultProductManagementService();
        }
        return instance;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        for (Product product : products) {
            if (product != null && product.getId() == productIdToAddToCart) {
                return product;
            }
        }
        return null;
    }
}
