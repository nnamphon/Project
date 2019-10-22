package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/product")
    private Collection<Product> getProductCollection(){
        return this.productRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/product/{id}")
    private Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long nid) {
        return productRepository.findById(nid).map(product -> {
            product.setProName(newProduct.getProName());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProduct.setProductID(nid);
            return productRepository.save(newProduct);
        });
    }
    @PostMapping(path = "/product")
   private Product newDoctor(@RequestBody Product newProduct){
       return productRepository.save(newProduct);
    }
}

