package com.projects.Ecomm.controller;

import com.projects.Ecomm.model.Product;
import com.projects.Ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/allproduct")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.ACCEPTED );
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Product> getbyId(@PathVariable int id){
        Product pro = productService.getbyId(id).orElse(null);
        if(pro!=null){
            return new ResponseEntity<>(pro, HttpStatus.OK);

        }
        else{
            return new   ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public 
}
