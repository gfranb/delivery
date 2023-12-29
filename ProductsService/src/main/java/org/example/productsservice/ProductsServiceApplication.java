package org.example.productsservice;

import org.example.productsservice.data.ProductRepository;
import org.example.productsservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ProductsServiceApplication {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProductsServiceApplication.class, args);
		ProductRepository repository = context.getBean(ProductRepository.class);
		repository.save(new Product(null,"Iphone","Nuevo Iphone",10,null));

	}

}
