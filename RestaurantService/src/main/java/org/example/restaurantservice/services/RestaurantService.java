package org.example.restaurantservice.services;

import org.example.restaurantservice.data.RestaurantRepository;
import org.example.restaurantservice.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository){
        this.repository = repository;
    }

    public List<Restaurant> findAll(){
        return repository.findAll();
    }

    @Transactional
    public boolean postRestaurant(Restaurant newRestaurant){
        try{
            repository.save(newRestaurant);
            return true;
        }catch (Exception e){
            // Loguear la excepción o manejarla de alguna manera
            e.printStackTrace(); // o utiliza un logger
            return false;
        }
    }

}
