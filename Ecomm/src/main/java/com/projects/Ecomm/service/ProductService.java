package com.projects.Ecomm.service;

import com.projects.Ecomm.model.Product;
import com.projects.Ecomm.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productrepo;
    public ProductService(ProductRepo productrepo){
        this.productrepo=productrepo;
    }
    public List<Product> getAllProduct(){
        return productrepo.findAll();
    }
    public Optional<Product> getbyId(int id){
        return productrepo.findById(id);
    }

}
