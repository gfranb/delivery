package org.example.restaurantservice.data;

import org.example.restaurantservice.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository <Restaurant,Long> {

}
