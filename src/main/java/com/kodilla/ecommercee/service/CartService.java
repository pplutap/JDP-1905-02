package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Long createNewCart() {
        List<Product> products = new ArrayList<>();
        Cart cart = new Cart(products);
        cartRepository.save(cart);
        return cart.getId();
    }

    public List<Product> addProductsToCart(Long id, List<Product> products){
        Cart cart = cartRepository.getOne(id);
        List<Product> cartProducts = cart.getProducts();
        products.stream()
                .filter(p -> productRepository.findById(p.getId()).isPresent())
                .forEach(p -> cartProducts.add(p));

        cartRepository.save(cart);

        return cart.getProducts();
    }

    public List<Product> getProductsFromTheCart (Long id){
        return cartRepository.getOne(id).getProducts();
    }

    public void deleteProductByIdInGivenCardById(Long cartId, Long productId){
        Cart cart = cartRepository.getOne(cartId);
        cart.getProducts().remove(productRepository.getOne(productId));
        cartRepository.save(cart);
    }

    public Long createNewOrder(Long userId, Long cartId){
        User user = userRepository.getOne(userId);
        Cart cart = cartRepository.getOne(cartId);
        Order order = new Order(user, cart);
        orderRepository.save(order);
        cartRepository.save(cart);

        return order.getId();
    }

}
