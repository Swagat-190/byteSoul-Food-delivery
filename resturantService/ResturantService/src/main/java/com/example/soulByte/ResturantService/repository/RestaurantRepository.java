package com.example.soulByte.ResturantService.repository;

import com.example.soulByte.ResturantService.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByCuisineEqualsIgnoreCase(String cuisine);

}
