package com.sumit.ecom_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import java.math.BigDecimal;
import java.util.Date;
import java.util.jar.Attributes;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    @Column(name = "release_date")
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    private String imageName;

    private String imageType;
    @Lob
    private byte[] imageData;

}
