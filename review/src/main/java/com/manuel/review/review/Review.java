package com.manuel.review.review;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String description;
    private double rating;
    private Long companyId;


}
