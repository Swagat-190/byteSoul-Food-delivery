package com.example.byteSoul.cartService.Service;

import com.example.byteSoul.cartService.Entity.Cart;
import com.example.byteSoul.cartService.Entity.CartItem;
import com.example.byteSoul.cartService.Repository.CartItemRepository;
import com.example.byteSoul.cartService.Repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart createCart(Long userId, Long restaurantId) {
       Cart cart = new Cart();
       cart.setUserId(userId);
       cart.setRestaurantId(restaurantId);
       return cartRepository.save(cart);
    }

    public List<Cart> getUserCarts(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public List<CartItem> getCartItems(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem addItemToCart(Long cartId, Long menuItemId, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setMenuItemId(menuItemId);
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    @Transactional
    public void clearCart(Long cartId) {
        cartItemRepository.deleteByCartId(cartId);
    }
}
