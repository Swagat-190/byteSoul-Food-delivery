package com.example.byteSoul.cartService.Controller;
import com.example.byteSoul.cartService.Entity.Cart;
import com.example.byteSoul.cartService.Entity.CartItem;
import com.example.byteSoul.cartService.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private  CartService cartService;


    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestParam Long userId,
                                           @RequestParam Long restaurantId) {
        return ResponseEntity.ok(cartService.createCart(userId, restaurantId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getUserCarts(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getUserCarts(userId));
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getCartItems(cartId));
    }

    @PostMapping("/{cartId}/items/add")
    public ResponseEntity<CartItem> addItem(@PathVariable Long cartId,
                                            @RequestParam Long menuItemId,
                                            @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.addItemToCart(cartId, menuItemId, quantity));
    }

    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<String> clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.ok("Cart cleared successfully.");
    }
}

