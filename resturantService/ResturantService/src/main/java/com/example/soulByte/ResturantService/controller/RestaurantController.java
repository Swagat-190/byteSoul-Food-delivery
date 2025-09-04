package com.example.soulByte.ResturantService.controller;

import com.example.soulByte.ResturantService.entity.Restaurant;
import com.example.soulByte.ResturantService.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(service.create(restaurant), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(service.update(id, restaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED);
    }
    @GetMapping("/isOpen/{id}")
    public boolean isOpen(@PathVariable  Long id){
        return service.isRestaurantOpen(id);
    }
    @GetMapping("/restaurant/open")
    public ResponseEntity<List<Restaurant>> nowAvaliableRestirants(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.nowAvaliableResturant());
    }
    @GetMapping("/by/category")
    public ResponseEntity<List<Restaurant>> getByCategory(@RequestParam String category){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getByCategory(category));
    }
}

