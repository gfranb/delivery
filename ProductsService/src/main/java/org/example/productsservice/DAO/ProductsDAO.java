package org.example.productsservice.DAO;

import org.example.productsservice.models.Product;

import java.util.List;

public interface ProductsDAO {
    List<Product> findAll();

}
