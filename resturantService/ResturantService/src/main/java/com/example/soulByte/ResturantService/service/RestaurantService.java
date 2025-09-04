package com.example.soulByte.ResturantService.service;

import com.example.soulByte.ResturantService.entity.Restaurant;
import com.example.soulByte.ResturantService.repository.RestaurantRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Restaurant update(Long id, Restaurant updated) {
        Restaurant restaurant = getById(id);
        restaurant.setName(updated.getName());
        restaurant.setAddress(updated.getAddress());
        restaurant.setCuisine(updated.getCuisine());
        restaurant.setPhone(updated.getPhone());
        return repository.save(restaurant);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public boolean isRestaurantOpen(Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return restaurant.isOpenNow();
    }
    public boolean isAvaliable(Long id){
         Restaurant restaurant = repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant Not Avaliable"));
         if(!restaurant.isOpenNow()){
             throw new RuntimeException("Sorry The Restaurant is Closed now");
         }
         return restaurant.isOpenNow();
    }
    public List<Restaurant> nowAvaliableResturant(){
        List<Restaurant> restaurantList = repository.findAll();
        List<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant restaurant : restaurantList){
            if(restaurant.isOpenNow()){
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }
    public List<Restaurant> getByCategory(String category){
        List<Restaurant> restaurants  = repository.findByCuisineEqualsIgnoreCase(category);
        return restaurants;
    }
}
