package org.example.restaurantservice.controllers;

import org.example.restaurantservice.data.RestaurantRepository;
import org.example.restaurantservice.models.Restaurant;
import org.example.restaurantservice.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postRestaurant(@RequestBody Restaurant newRestaurant){
        try{
            if (restaurantService.postRestaurant(newRestaurant)){
                return new ResponseEntity<>("Restaurante creado correctamente", HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>("Error al crear el restaurante", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear el restaurante", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
