package com.examen.examen4domingo.service;

import com.examen.examen4domingo.domain.Product;
import com.examen.examen4domingo.exception.ProductNotFoundException;
import com.examen.examen4domingo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
        No ejecuta

       public Map<String, Object> all(int pagina, int tamanio){

        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());

        Page<Product> pageAll = this.productRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("products", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }*/

    public List<Product> all() {
        return this.productRepository.findAll();
    }

    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public Product one(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product replace(Long id, Product product) {

        return this.productRepository.findById(id).map( p -> (id.equals(product.getId())  ?
                                                            this.productRepository.save(product) : null))
                .orElseThrow(() -> new ProductNotFoundException(id));

    }

    public void delete(Long id) {
        this.productRepository.findById(id).map(p -> {this.productRepository.delete(p);
                                                        return p;})
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> allByQueryFilters(Optional<String> buscarOptional, Optional<String> ordenarOptional){
        if (buscarOptional.isPresent() && ordenarOptional.isPresent()) {
            if (ordenarOptional.get().equalsIgnoreCase("asc")) {
                return this.productRepository.queryBuscarOrdenarAsc(buscarOptional);
            } else if(ordenarOptional.get().equalsIgnoreCase("desc")){
                return this.productRepository.queryBuscarOrdenarDesc(buscarOptional);
            }
        } else if (!buscarOptional.isPresent() && ordenarOptional.isPresent()) {
            if (ordenarOptional.get().equalsIgnoreCase("asc")) {
                return this.productRepository.queryOrdenarAsc(ordenarOptional);
            } else if(ordenarOptional.get().equalsIgnoreCase("desc")){
                return this.productRepository.queryOrdenarDesc(ordenarOptional);
            }
        } else if (buscarOptional.isPresent() && !ordenarOptional.isPresent()) {
            return this.productRepository.queryBuscar(buscarOptional);
        }

        return this.productRepository.findAll();
    }

}
