package org.example.productsservice.controllers;

import org.example.productsservice.models.Product;
import org.example.productsservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/v2/products/add")
    public ResponseEntity<String> addController(@RequestBody Product product){
        //service who save products.
        productService.addProduct(product);
        return new ResponseEntity<>("Producto creado con exito", HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/v2/products")
    public ResponseEntity<List<Product>> getController(){
        //Service who return the list of the products saved.
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v2/products/{id}")
    public ResponseEntity<Product> getProductByIdController(@PathVariable Long id){
        //Service who return the list of the products saved.
        return new ResponseEntity<>(productService.getProductsById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v2/products/restaurant/{idRestaurant}")
    public ResponseEntity<List<Product>> getProductsByRestaurantId(@PathVariable Long idRestaurant){
        return new ResponseEntity<>(productService.getProductsByRestaurantId(idRestaurant), HttpStatus.OK);
    }

}
