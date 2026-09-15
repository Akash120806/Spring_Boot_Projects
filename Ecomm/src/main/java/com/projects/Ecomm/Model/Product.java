package com.projects.Ecomm.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Product {
    private int id ;
    private String name;
    private String description;
    private float price;
    private String category;
    private Date releasedate;
    private boolean availability;
    private int quantity;
}
