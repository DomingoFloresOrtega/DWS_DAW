package com.examen.examen4domingo.service;

import com.examen.examen4domingo.domain.Cart;
import com.examen.examen4domingo.exception.ProductNotFoundException;
import com.examen.examen4domingo.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> all(Optional<String> id) {
        return this.cartRepository.queryFindAllById(id);
    }

    public Cart save(Cart cart) {
        return this.cartRepository.save(cart);
    }

    public Cart one(Long id) {
        return this.cartRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Cart replace(Long id, Cart cart) {

        return this.cartRepository.findById(id).map( p -> (id.equals(cart.getId())  ?
                                                            this.cartRepository.save(cart) : null))
                .orElseThrow(() -> new ProductNotFoundException(id));

    }

    public void delete(Long id) {
        this.cartRepository.findById(id).map(p -> {this.cartRepository.delete(p);
                                                        return p;})
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

}
