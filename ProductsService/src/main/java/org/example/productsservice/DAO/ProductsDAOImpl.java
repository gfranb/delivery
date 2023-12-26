package org.example.productsservice.DAO;

import org.example.productsservice.models.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO{

    private Session session;

    public ProductsDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Product> findAll(){
        return session.createQuery("from Product ", Product.class).list();
    }

}
