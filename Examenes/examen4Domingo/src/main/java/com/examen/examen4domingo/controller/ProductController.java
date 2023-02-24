package com.examen.examen4domingo.controller;

import com.examen.examen4domingo.domain.Cart;
import com.examen.examen4domingo.domain.Product;
import com.examen.examen4domingo.service.CartService;
import com.examen.examen4domingo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductController {
    private final ProductService productService;
    private final CartService cartService;

    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping(value={"","/"}, params = {"!buscar", "!ordenar"})
    public List<Product> all() {
        log.info("Accediendo a todos los productos");
        return this.productService.all();
    }

    @GetMapping(value={"","/"})
    public List<Product> all(@RequestParam("buscar") Optional<String> buscarOptional,
                               @RequestParam("ordenar") Optional<String> ordenarOptional) {
        return this.productService.allByQueryFilters(buscarOptional, ordenarOptional);
    }

    @GetMapping(value={"/cart"})
    public List<Cart> allCart(@RequestParam("id") Optional<String> id) {
        log.info("Accediendo a todos los productos del carrito");
        return this.cartService.all(id);
    }

    @PostMapping({"/buy"})
    public Cart addCart(@RequestBody Cart cart) {
        return this.cartService.save(cart);
    }

    @PostMapping({"","/"})
    public Product newProduct(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable("id") Long id) {
        return this.productService.one(id);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return this.productService.replace(id, product);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }
}
