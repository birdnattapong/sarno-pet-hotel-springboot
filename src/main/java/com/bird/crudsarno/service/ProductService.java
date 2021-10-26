package com.bird.crudsarno.service;

import com.bird.crudsarno.entity.Product;
import com.bird.crudsarno.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product exist = repository.findById(product.getId()).orElse(null);
        exist.setProductName(product.getProductName());
        exist.setVolumn(product.getVolumn());
        exist.setSize(product.getSize());
        exist.setStock(product.getStock());
        exist.setBasePrice(product.getBasePrice());
        exist.setSellPrice(product.getSellPrice());
        exist.setRemain(product.getRemain());
        exist.setImgUrl(product.getImgUrl());
        return repository.save(exist);
    }

    public Product sellProduct(int id, int qty) {
        Product exist = repository.findById(id).orElse(null);
        exist.setRemain(exist.getRemain() - qty);
        return repository.save(exist);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "delete product id : " + id;
    }

    public List<Product> getAlmostEmptyProducts() {
        return repository.getAlmostEmptyProducts();
    }

    public Product addProductQty(int id, int qty) {
        Product exist = repository.findById(id).orElse(null);
        int currentQty = exist.getRemain();
        exist.setRemain(currentQty + qty);
        return repository.save(exist);
    }
}