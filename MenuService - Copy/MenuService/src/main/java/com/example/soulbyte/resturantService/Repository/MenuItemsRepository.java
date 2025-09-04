package com.example.soulbyte.resturantService.Repository;

import com.example.soulbyte.resturantService.Entity.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems,Long> {
  List<MenuItems> findByRestaurantId(Long restaurantId);
  List<MenuItems> findByCategoryId(Long id);
}
