package org.example.productsservice.services;

import org.example.productsservice.ProductRepository;
import org.example.productsservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public boolean addProduct(Product product){
        try{
            repository.save(product);
            return true;
        }catch (Exception e){
            // Loguear la excepción o manejarla de alguna manera
            e.printStackTrace(); // o utiliza un logger
            return false;
        }
    }

    @Transactional
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @Transactional
    public Product getProductsById(Long id){
        return repository.findById(id).orElse(null);
    }

}
