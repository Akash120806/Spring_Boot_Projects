package com.example.WebApp.productservice;

import com.example.WebApp.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService{
    List<Product> items= new ArrayList<>(Arrays.asList(
            new Product(101,"Victus",60000),
            new Product(102,"LOQ",80000),
            new Product(103,"Tuf",70000)
    ));
 //etMapping("/id/{id}")
    public List<Product >getAll(){

        return items;
    }
 public Product getByIde (int id){
    for( Product item:items){
      if(item.getId()==id){
          return item;
      }
    }
    return null;
 }
//  @GetMapping("/name/{name}")
 public Product getByName( String name){
     return items.stream()
             .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
             .findFirst()
             .orElse(null);
 }
  public void addingProduct(Product product){
        items.add(product);
  }

}
