package com.store.services;

import com.store.enteties.Product;

public interface ProductManagementService {
    Product[] getProducts();
    Product getProductById(int productIdToAddToCart);
}
