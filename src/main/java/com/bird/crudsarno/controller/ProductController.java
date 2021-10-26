package com.bird.crudsarno.controller;

import com.bird.crudsarno.entity.Product;
import com.bird.crudsarno.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/getProducts/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    public Product sellProduct(int id, int qty) {
        return service.sellProduct(id, qty);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("/getAlmostEmptyProducts")
    public List<Product> getAlmostEmptyProducts() {
        return service.getAlmostEmptyProducts();
    }

    @PutMapping("/addProductQty/{id}/{qty}")
    public Product addProductQty(@PathVariable int id, @PathVariable int qty) {
        return service.addProductQty(id, qty);
    }
}
