package com.example.soulbyte.resturantService.Controller;

import com.example.soulbyte.resturantService.Entity.MenuCategory;
import com.example.soulbyte.resturantService.Entity.MenuItems;
import com.example.soulbyte.resturantService.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/menu")
public class MenuController {

        @Autowired
        private MenuService menuService;

       /* @GetMapping("/{restaurantId}")
        public List<MenuItems> getMenu(@PathVariable Long restaurantId) {
            return menuService.getItemsByRestaurant(restaurantId);
        }*/

        @PostMapping("/")
        public MenuItems addItem(@RequestBody MenuItems item) {
            return menuService.addMenuItem(item);
        }

        @PutMapping("/{id}")
        public MenuItems updateItem(@PathVariable Long id, @RequestBody MenuItems item) {
            return menuService.updateItem(id, item);
        }

        @DeleteMapping("/{id}")
        public void deleteItem(@PathVariable Long id) {

            menuService.deleteItem(id);
        }

        @GetMapping("/by/categoryid/{id}")
        public List<MenuItems>  getItemsByCategoryId(@PathVariable Long id){
            return menuService.getItemsByCategoryId(id);
        }
    @PostMapping("/addCategory")
    public MenuCategory addCategory(@RequestBody MenuCategory menuCategory) {
        return menuService.addCategory(menuCategory);
    }
    }


