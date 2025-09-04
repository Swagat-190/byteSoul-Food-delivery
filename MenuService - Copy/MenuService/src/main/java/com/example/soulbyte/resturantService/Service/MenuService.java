package com.example.soulbyte.resturantService.Service;

import com.example.soulbyte.resturantService.Entity.MenuCategory;
import com.example.soulbyte.resturantService.Entity.MenuItems;
import com.example.soulbyte.resturantService.Repository.MenuCategoryRepository;
import com.example.soulbyte.resturantService.Repository.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MenuService {
    private final MenuItemsRepository menuItemsRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    public MenuService(MenuItemsRepository menuItemsRepository, MenuCategoryRepository menuCategoryRepository) {
        this.menuItemsRepository = menuItemsRepository;
        this.menuCategoryRepository = menuCategoryRepository;
    }
    @Autowired
    private RestTemplate restTemplate;

    public boolean isValidRestaurant(Long restaurantId,Long categoryId) {
        try {
            String url = "http://localhost:8084/api/restaurants/" + restaurantId;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode().is2xxSuccessful()&&menuCategoryRepository.existsById(categoryId);
        }
        catch (HttpClientErrorException.NotFound e) {
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }
   /* public List<MenuItems> getItemsByRestaurant(Long restaurantId) {
        if(!isValidRestaurant(restaurantId)){
            throw new RuntimeException("Restaurant Id not found");
        }
        return  menuItemsRepository.findByRestaurantId(restaurantId);
    }*/

    public MenuItems addMenuItem(MenuItems item) {
        if(!isValidRestaurant(item.getRestaurantId(),item.getCategoryId())){
            throw new RuntimeException("Restaurant Id not found");
        }
       return menuItemsRepository.save(item);
    }

    public void deleteItem(Long id) {
        menuItemsRepository.findById(id).orElseThrow( () -> new RuntimeException("Item not Found"));
        menuItemsRepository.deleteById(id);
    }
    public MenuItems updateItem(Long id, MenuItems updatedItem) {
        MenuItems item = menuItemsRepository.findById(id).orElseThrow( () -> new RuntimeException("Item not Found"));
        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());
        item.setPrice(updatedItem.getPrice());
        item.setCategoryId(updatedItem.getCategoryId());
        item.setAvailable(updatedItem.isAvailable());
        return menuItemsRepository.save(item);
    }
    public List<MenuItems> getItemsByCategoryId(Long categoryId){
        return menuItemsRepository.findByCategoryId(categoryId);
    }
    public MenuCategory addCategory(MenuCategory menuCategory){
        return menuCategoryRepository.save(menuCategory);
    }

}

